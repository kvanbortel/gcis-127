package unit10.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class AdjacencyGraph<E> implements Graph<E> {
    private Map<E, Vertex<E>> verticies;

    public AdjacencyGraph() {
        verticies = new HashMap<>();
    }

    @Override
    public void add(E value) {
        verticies.put(value, new Vertex<>(value));
    }

    @Override
    public boolean contains(E value) {
        return verticies.containsKey(value);
    }

    @Override
    public int size() {
        return verticies.size();
    }

    @Override
    public void connectDirected(E a, E b) {
        Vertex<E> vA = verticies.get(a);
        Vertex<E> vB = verticies.get(b);
        vA.connect(vB);
    }

    @Override
    public void connectUndirected(E a, E b) {
        Vertex<E> vA = verticies.get(a);
        Vertex<E> vB = verticies.get(b);
        vA.connect(vB);
        vB.connect(vA);
    }

    @Override
    public boolean connected(E a, E b) {
        Vertex<E> vA = verticies.get(a);
        Vertex<E> vB = verticies.get(b);
        return vA.connected(vB);
    }

    @Override
    public List<E> bfSearch(E start, E end) {
        Vertex<E> vStart = verticies.get(start);
        Vertex<E> vEnd = verticies.get(end);
        Queue<Vertex<E>> queue = new LinkedList<>();
        queue.add(vStart);
        Map<Vertex<E>, Vertex<E>> predecessors = new HashMap<>();
        predecessors.put(vStart, null);
        
        while (!queue.isEmpty()) {
            Vertex<E> v = queue.remove();
            if (v == vEnd) {
                break;
            }
            else {
                for (Vertex<E> neighbor: v.getNeighbors()) {
                    if (!predecessors.containsKey(neighbor)) {
                        queue.add(neighbor);
                        predecessors.put(neighbor, v);
                    }
                }
            }
        }
        return makePath(predecessors, vEnd);
    }

    private List<E> makePath(Map<Vertex<E>, Vertex<E>> predecessors, Vertex<E> end) {
        if (!predecessors.containsKey(end)) {
            return null;
        }
        else {
            List<E> path = new LinkedList<>();
            Vertex<E> current = end;
            while (current != null) {
                path.add(0, current.getValue());
                current = predecessors.get(current);
            }
            return path;
        }
    }
    
    @Override
    public List<E> dfSearch(E start, E end) {
        Vertex<E> vStart = verticies.get(start);
        Vertex<E> vEnd = verticies.get(end);
        Set<Vertex<E>> visited = new HashSet<>();
        visited.add(vStart);
        return visitDFS(vStart, vEnd, visited);
    }
    
    public List<E> visitDFS(Vertex<E> v, Vertex<E> e, Set<Vertex<E>> visited) {
        if (v == e) {
            List<E> path = new LinkedList<>();
            path.add(e.getValue());
            return path;
        }
        else {
            for (Vertex<E> neighbor: v.getNeighbors()) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    List<E> path = visitDFS(neighbor, e, visited);
                    if(path != null) {
                        path.add(0, v.getValue());
                        return path;
                    }
                }
            }
            return null;
        }
    }

    @Override
    public int countConnectedComponents() {
        /** Check to see which verticies connect to the first one and remove those as they are a part of the same
         * component. Increment the count. Move on to the next available vertex until all are gone from the list.
         */
        int count = 0;
        Set<E> verticiesSet = new HashSet<>();
        for (E e: verticies.keySet()) {
            verticiesSet.add(e);
        }
        List<E> vList = new ArrayList<E>(verticiesSet);
        // System.out.println(vList.toString());;
        while (!vList.isEmpty()) {
            E start = vList.get(0);
            for (int i = 1; i < vList.size(); i++) {
                E stop = vList.get(i);
                // System.out.println("Stop is " + stop);
                List<E> path = bfSearch(start, stop);
                if (path == null) {
                    // System.out.println(start + " / " + stop);
                }
                else {
                    vList.remove(stop);
                    // System.out.println("Removed " + stop);
                    i--;
                }
            }
            count += 1;
            vList.remove(start);
        }
        return count;
    }

    public Map<E, Vertex<E>> getVerticies() {
        return verticies;
    }
}
