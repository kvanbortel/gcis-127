package unit10.midtermpractice.other;

import java.util.Iterator;;

public class NodeIterator implements Iterator<String> {
    private Node<String> node;

    public NodeIterator(Node<String> node) {
        this.node = node;
    }

    public boolean hasNext() {
        return node != null;
    }

    public String next() {
        String value = node.getValue();
        node = node.getNext();
        return value;
    }

    // public void remove() {}
}
