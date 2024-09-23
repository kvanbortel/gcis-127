package unit10.graphs;

import java.util.List;
import java.util.Map;

public interface Graph<E> {
    void add(E value);
    boolean contains(E value);
    int size();
    void connectDirected(E a, E b);
    void connectUndirected(E a, E b);
    boolean connected(E a, E b);
    Map<E, Vertex<E>> getVerticies();

    default List<E> bfSearch(E start, E end) {
        throw new UnsupportedOperationException();
    }

    default List<E> dfSearch(E start, E end) {
        throw new UnsupportedOperationException();
    }

    default int countConnectedComponents() {
        throw new UnsupportedOperationException();
    }
}
