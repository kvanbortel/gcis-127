package unit10.weighted;

import java.util.HashMap;
import java.util.Map;

public class WAdjacencyGraph<E> implements WGraph<E> {
    private final Map<E, WVertex<E>> vertices;
    
    public WAdjacencyGraph() {
        vertices = new HashMap<>();
    }

    @Override
    public void add(E value) {
        WVertex<E> vertex = new WVertex<>(value);
        vertices.put(value, vertex);
    }

    @Override
    public boolean contains(E value) {
        return vertices.containsKey(value);
    }

    @Override
    public int size() {
        return vertices.size();
    }

    @Override
    public void connect(E a, E b, double weight) {
        WVertex<E> vertexA = vertices.get(a);
        WVertex<E> vertexB = vertices.get(b);
        vertexA.connect(vertexB, weight);
        vertexB.connect(vertexA, weight);
    }

    @Override
    public boolean connected(E a, E b) {
        WVertex<E> vertexA = vertices.get(a);
        WVertex<E> vertexB = vertices.get(b);
        return vertexA.edge(vertexB) != null;
    }

    @Override
    public double weight(E a, E b) {
        WVertex<E> vertexA = vertices.get(a);
        WVertex<E> vertexB = vertices.get(b);
        return vertexA.edge(vertexB).getWeight();
    }

    @Override
    public WPath<E> dijkstrasPath(E start, E end) {
        WVertex<E> vStart = vertices.get(start);
        WVertex<E> vEnd = vertices.get(end);
        Map<WVertex<E>, PathTuple<E>> predecessors = new HashMap<>();
        TupleQueue<E> queue = new TupleQueue<>();

        for (WVertex<E> v: vertices.values()) {
            PathTuple<E> pathTuple = new PathTuple<>(v);
            predecessors.put(v, pathTuple);
            queue.enqueue(pathTuple);
        }

        PathTuple<E> startT = predecessors.get(vStart);
        startT.update(null, 0);

        while(queue.size() != 0) {
            PathTuple<E> pt = queue.dequeue();
            if (pt.getDistance() == Double.POSITIVE_INFINITY) {
                break;
            }
            WVertex<E> v = pt.getVertex();
            for (Edge<E> edge: v.edges()) {
                WVertex<E> n = edge.getTo();
                double distance = pt.getDistance() + edge.getWeight();
                PathTuple<E> pn = predecessors.get(n);
                if (distance < pn.getDistance()) {
                    pn.update(v, distance);
                }
            }
        }
        PathTuple<E> pe = predecessors.get(vEnd);
        double distance = pe.getDistance();
        if (distance == Double.POSITIVE_INFINITY) {
            return null;
        }
        else {
            WPath<E> path = new WPath<>(vEnd.getValue());
            WVertex<E> v = pe.getPredecessor();
            while (v != null) {
                path.prepend(v.getValue(), distance);
                distance = 0;
                PathTuple<E> pv = predecessors.get(v);
                v = pv.getPredecessor();
            }
            return path;
        }
    }
}
