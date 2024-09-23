package unit11.practicum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import unit11.graphs.Graph;
import unit11.graphs.AdjacencyGraph;
import unit11.graphs.Vertex;

public class Mothers<E> {
    public static List<Vertex<E>> findMothers (AdjacencyGraph<String> graph, Set<String> values) {
        Arrays.asList(values);
        Set<Vertex<E>> visited = new HashSet<>();
        List<Vertex<E>> mothers = new HashSet<>();
        for (Vertex<E> each: values) {
            mothers.add(each);
        }
        List<E> path = new LinkedList<>();
        for (Vertex<E> each: values) {
            for (Vertex<E> remaining: values) {
                path = each.dfSearch(remaining);
                if (path == null) {
                    mothers.remove(each);
                }
            }
            
        }
        return mothers;
    }

    public static void main(String[] args) {
        AdjacencyGraph<String> graph1 = new AdjacencyGraph<>();
        graph1.add("A");
        graph1.add("B");
        graph1.add("C");
        graph1.add("D");
        graph1.add("E");
        graph1.connectDirected("A", "B");
        graph1.connectDirected("B", "C");
        graph1.connectDirected("B", "E");
        graph1.connectDirected("C", "D");
        graph1.connectDirected("E", "A");

        AdjacencyGraph<String> graph2 = new AdjacencyGraph<>();
        graph2.add("T");
        graph2.add("U");
        graph2.add("V");
        graph2.add("W");
        graph2.add("X");
        graph2.add("Y");
        graph2.add("Z");
        graph2.connectDirected("T", "V");
        graph2.connectDirected("W", "T");
        graph2.connectDirected("X", "T");
        graph2.connectDirected("X", "U");
        graph2.connectDirected("Y", "X");
        graph2.connectDirected("Y", "W");
        graph2.connectDirected("Z", "U");
        graph2.connectDirected("Z", "Y");

        System.out.println(findMothers(graph1, graph1.getVertices().keySet()));
        System.out.println(findMothers(graph2, graph2.getVertices().keySet()));
    }
}
