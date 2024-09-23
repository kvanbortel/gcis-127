package unit10.graphs;

import java.util.HashMap;
import java.util.Map;

public class Hole{
    private final int row, col;
    public Hole(int row, int col){
        this.row = row;
        this.col = col;
    }
    public int getRow(){
        return row;
    }
    public int getCol(){
        return col;
    }

    @Override
    public String toString() {
        return "(" + row + ", " + col + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Hole) {
            Hole other = (Hole)obj;
            return row == other.getRow() && col == other.getCol();
        }
        else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return (row * (int)Math.pow(2, 14)) + col;
    }

    public static void main(String[] args) {
        Map<Hole, Integer> map = new HashMap<>();
        map.put(new Hole(0, 0), 0);
        map.put(new Hole(0, 3), 0);
        map.put(new Hole(5, 2), 5);
        System.out.println(map.containsKey(new Hole(5, 2))); //true
        System.out.println(map.get(new Hole(5, 2))); //5  
        
        Graph<Hole> graph = new AdjacencyGraph<>();
        Hole H01 = new Hole(0, 1);
        Hole H03 = new Hole(0, 3);
        Hole H05 = new Hole(0, 5);
        Hole H21 = new Hole(2, 1);
        Hole H23 = new Hole(2, 3);
        Hole H25 = new Hole(2, 5);
        graph.add(H01);
        graph.add(H03);
        graph.add(H05);
        graph.add(H21);
        graph.add(H23);
        graph.add(H25);
        graph.connectUndirected(H01, H21);
        graph.connectUndirected(H01, H23);
        graph.connectUndirected(H03, H05);
        graph.connectUndirected(H03, H21);
        graph.connectUndirected(H03, H23);
        graph.connectUndirected(H03, H25);
        graph.connectUndirected(H05, H23);
        graph.connectUndirected(H23, H25);
        System.out.println(graph.bfSearch(H21, H05));
        System.out.println(graph.dfSearch(H21, H05));
    }
}
