/* This program creates a graph given a txt file
 * Author: Kayla Van Bortel */

package unit10.graphs;

import static unit10.FileLineReader.open;

public class GraphReader{
    
    public static Graph<String> readGraph(String filename) {
        /** Sets the first character as the root and connects all following characters to it, then increments
         * to the next line and does the same
         */
        Graph<String> graph = new AdjacencyGraph<>();
        for(String line : open(filename)) {
            line.strip();
            if (line.charAt(0) != '#') {
                String vertex = String.valueOf(line.charAt(0));
                if (!graph.contains(vertex)) {
                    graph.add(vertex);
                }
                for (int i = 1; i < line.length(); i++) {
                    char connected = line.charAt(i);
                    if (connected >= 'A' && connected <= 'Z') {
                        // System.out.println(String.valueOf(connected));
                        if (!graph.contains(String.valueOf(connected))) {
                            graph.add(String.valueOf(connected));
                        }
                        graph.connectUndirected(vertex, String.valueOf(connected));
                        // System.out.println(vertex + "-" + String.valueOf(connected));
                    }
                }
            }
        }
        return graph;
    }

    public static void main(String[] args) {
        // System.out.println(readGraph("data/bfs/a_6_1.txt"));
    }
}
