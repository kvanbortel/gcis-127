package unit10.graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Vertex<E> {
    private E value;
    private Set<Vertex<E>> neighbors;

    public Vertex(E value) {
        this.value = value;
        neighbors = new HashSet<>();
    }

    public E getValue() {
        return value;
    }

    public Set<Vertex<E>> getNeighbors() {
        return neighbors;
    }

    public void connect(Vertex<E> neighbor) {
        neighbors.add(neighbor);
    }

    public boolean connected(Vertex<E> neighbor) {
        return neighbors.contains(neighbor);
    }

    @Override
    public String toString() {
        String output = "";
        output += value.toString() + ": [";
        List<Vertex<E>> neighborList = new ArrayList<>(neighbors);
        for (Vertex<E> neighbor: neighborList) {
            if (neighbor != neighborList.get(0)) {
                output += ", ";
            }
            output += neighbor.value.toString();
        }
        output += "]";
        return output;
    }
}
