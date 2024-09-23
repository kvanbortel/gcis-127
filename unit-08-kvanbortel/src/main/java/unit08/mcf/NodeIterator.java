package unit08.mcf;

import java.util.Iterator;

public class NodeIterator<E> implements Iterator<E> {
    private Node<E> node;

    public NodeIterator(Node<E> node) {
        this.node = node;
    }

    public boolean hasNext() {
        return node != null;
    }

    public E next() {
        E value = node.getValue();
        node = node.getNext();
        return value;
    }
}
