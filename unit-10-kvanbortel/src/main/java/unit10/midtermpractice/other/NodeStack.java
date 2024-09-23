package unit10.midtermpractice.other;

import java.util.Iterator;

public class NodeStack extends Node<String> implements Stack {
    private Node<String> top;
    private int size;

    public NodeStack() {
        super(null);
        this.top = null;
        this.size = 0;
    }

    @Override
    public void push(String value) {
        Node<String> newNode = new Node<>(value, top);
        top = newNode;
        size++;
    }

    @Override
    public String top() {
        return top.getValue();
    }

    @Override
    public String pop() {
        String value = top.getValue();
        if (top != null) {
            Node<String> temp = top;
            top = top.getNext();
            temp.setNext(null);
            size--;
        }
        return value;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<String> iterator() {
        Iterator<String> i = new NodeIterator(top);
        return i;
    }

    public static void main(String[] args) {
        NodeStack stack = new NodeStack();
        // Iterator<String> i = stack.iterator();
        stack.push("a");
        stack.push("b");

        System.out.println(stack.size);
        for (String e: stack) {
            System.out.println(e);
            stack.pop();
            // i.remove();
        }
        System.out.println(stack.size);
    }
}
