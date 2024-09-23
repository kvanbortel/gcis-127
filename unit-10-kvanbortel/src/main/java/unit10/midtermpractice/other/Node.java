package unit10.midtermpractice.other;

public class Node<E> {
    private E value;
    private Node<E> next;

    public Node(E value) {
        this(value, null);
    }

    public Node(E value, Node<E> next) {
        this.value = value;
        this.next = next;
    }

    public E getValue() {
        return value;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }

    public Node<E> getNext() {
        return next;
    }

    @Override
    public String toString() {
        return value + "->" + next;
    }
}
