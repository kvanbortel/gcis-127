package unit08.mcf;

import java.util.Iterator;

public class NodeQueue<E> implements Queue<E> {
    private Node<E> front;
    private Node<E> back;
    private int size;

    public NodeQueue() {
        front = null;
        back = null;
        size = 0;
    }
    
    @Override
    public void enqueue(E value) {
        Node<E> newNode = new Node<>(value);
        if (size == 0) {
            front = newNode;
        }
        else {
            back.setNext(newNode);
        }
        back = newNode;
        size++;
    }

    @Override
    public E dequeue() {
        E value = front.getValue();
        front = front.getNext();
        if (front == null) {
            back = null;
        }
        size--;
        return value;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        return size + ", " + front;
    }

    @Override
    public Iterator<E> iterator() {
        return new NodeIterator<E>(front);
    }

    public static void main(String[] args) {
        Queue<String> q = new NodeQueue<>();
        q.enqueue("Test");
        q.enqueue("Two");
        for (String s : q) {
            System.out.println(s);
        }
    }
    
}
