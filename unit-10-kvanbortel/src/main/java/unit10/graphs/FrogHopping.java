/* This program maps a path where a frog jumps over pegs from a start to end hole
 * Author: Kayla Van Bortel
 */

package unit10.graphs;

import static unit10.FileLineReader.open;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Iterator;

public class FrogHopping {
    private char[][] arrayBoard;
    private final int ROWS, COLS;
    private static final int[][] DIRECTIONS = {
        new int[] {-1, -1}, new int[] {-1,  0}, new int[] {-1,  1},
        new int[] { 0, -1},                     new int[] { 0,  1},
        new int[] { 1, -1}, new int[] { 1,  0}, new int[] { 1,  1}
    };
    private Graph<Hole> graph = new AdjacencyGraph<>();

    public FrogHopping(String filename) throws IOException{
        // Initialize all of the fields
        // Construct the array and add all vertices to the graph
        // ROWS = 0;
        // COLS = 0;

        Iterator<String> lines = open(filename).iterator();
        String line = lines.next();
        ROWS = Integer.parseInt(String.valueOf(line.charAt(0)));
        COLS = Integer.parseInt(String.valueOf(line.charAt(2)));
        arrayBoard = new char[ROWS][COLS];
        int count = 0;
        while (lines.hasNext()) {
            line = lines.next();
            char[] row = new char[COLS];
            for (int i = 0; i < COLS; i++) {
                row[i] = line.charAt(i * 2);
            }
            arrayBoard[count] = row;
            count++;
        }

        // Connect vertices
        connectVertices();      
             
    }
    private void connectVertices(){
        /* Connect the holes based on if there is a peg between them */
        // Look at each space on the board
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                // System.out.println(i + "/" + j);
                if (arrayBoard[i][j] != 'H') {
                    continue; // Only holes can be connected
                }
                Hole ijHole = new Hole(i, j);
                if (!graph.contains(ijHole)) {
                    graph.add(ijHole);
                }
                // Look at each space that could be connected
                for (int[] offset: DIRECTIONS) {
                    int holeRow = i + offset[0] * 2;
                    int holeCol = j + offset[1] * 2;
                    int pegRow = i + offset[0];
                    int pegCol = j + offset[1];
                    if (holeRow >= ROWS || pegRow >= ROWS) {
                        continue;
                    }
                    if (holeCol >= COLS || pegCol >= COLS) {
                        continue;
                    }
                    if (holeRow < 0 || holeCol < 0 || pegRow < 0 || pegCol < 0) {
                        continue;
                    }
                    char peg = arrayBoard[pegRow][pegCol];
                    char hole = arrayBoard[holeRow][holeCol];
                    // System.out.println(i + "/" + j + " PR:" + pegRow + " PC:" + pegCol + " Peg:" + peg);
                    // System.out.println(i + "/" + j + " HR:" + holeRow + " HC:" + holeCol + " Hole:" + hole);
                    if (peg == 'P' && hole == 'H') {
                        Hole newHole = new Hole(holeRow, holeCol);
                        if (!graph.contains(newHole)) {
                            graph.add(newHole);
                        }
                        graph.connectUndirected(new Hole(i, j), new Hole(holeRow, holeCol));
                        // System.out.println("Connected " + i + "/" + j + " and " + holeRow + "/" + holeCol);
                    }
                }
            }
        }
    }

    @Override
    public String toString() {
        String output = "";
        Map<Hole, Vertex<Hole>> verticies = graph.getVerticies();
        for (Vertex<Hole> hole: verticies.values()) {
            output += hole.toString() + "\n";
        }
        return output;
    }
    
    // The frog can't jump to a hole which was visited before
    public List<Hole> dfPathV0(Hole start, Hole end) {
        return graph.dfSearch(start, end);
    }
    // The frog can't jump over the same peg more than once
    public List<Hole> dfPathV1(Hole start, Hole end) {
        return null;
    }
    public static void main(String[] args) throws IOException {
        FrogHopping frog = new FrogHopping("data/dfs/frog_3.txt");
        // System.out.println(frog);
        Hole start = new Hole(2, 1);
        Hole end = new Hole(0, 5);
        System.out.println(frog.dfPathV0(start, end)); //[(2,1), (0,3), (2,5), (2,3), (0,5)]
        System.out.println(frog.dfPathV1(start, end)); //[(2,1), (0,3), (2,5), (2,3), (0,3), (0,5)]
        System.out.println("The frog game graph representation:");

        System.out.println(frog);
        
    }
}
