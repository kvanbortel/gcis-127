package unit10.graphs;

public class Main extends GraphReader {
    public static void main(String[] args) {
        System.out.println("a_13_5.txt connected components: " + readGraph("data/bfs/a_13_5.txt").countConnectedComponents());
        System.out.println("a_22_3.txt connected components: " + readGraph("data/bfs/a_22_3.txt").countConnectedComponents());
        System.out.println("a_26_4.txt connected components: " + readGraph("data/bfs/a_26_4.txt").countConnectedComponents());
        System.out.println("a_6_1.txt connected components: " + readGraph("data/bfs/a_6_1.txt").countConnectedComponents());
        System.out.println("a_7_3.txt connected components: " + readGraph("data/bfs/a_7_3.txt").countConnectedComponents());
        System.out.println("bipartite.txt connected components: " + readGraph("data/bfs/bipartite.txt").countConnectedComponents());
        System.out.println("k2.txt connected components: " + readGraph("data/bfs/k2.txt").countConnectedComponents());
        System.out.println("k2_2.txt connected components: " + readGraph("data/bfs/k2_2.txt").countConnectedComponents());
        System.out.println("k3.txt connected components: " + readGraph("data/bfs/k3.txt").countConnectedComponents());
        System.out.println("k4.txt connected components: " + readGraph("data/bfs/k4.txt").countConnectedComponents());
        System.out.println("k5.txt connected components: " + readGraph("data/bfs/k5.txt").countConnectedComponents());
        System.out.println("non_bipartite.txt connected components: " + readGraph("data/bfs/non_bipartite.txt").countConnectedComponents());
        System.out.println("v2.txt connected components: " + readGraph("data/bfs/v2.txt").countConnectedComponents());

// a_13_5.txt connected components: 5
// a_22_3.txt connected components: 3       
// a_26_4.txt connected components: 4       
// a_6_1.txt connected components: 1        
// a_7_3.txt connected components: 3        
// bipartite.txt connected components: 3    
// k2.txt connected components: 1
// k2_2.txt connected components: 1
// k3.txt connected components: 1
// k3_3.txt connected components: 1
// k4.txt connected components: 1
// k5.txt connected components: 1
// non_bipartite.txt connected components: 3
// v2.txt connected components: 2

    }
    
}
