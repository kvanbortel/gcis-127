/* This program simulates a stack using nodes. 
   Author: Kayla Van Bortel */


package unit08.mcf;

public class NodeStack extends Node<String> implements Stack {
    private Node<String> top;
    private int size;

    public NodeStack() {
        super(null);
        top = null;
        size = 0;
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public void push(String value) {
        /** Adds a new node to the stack */
        Node<String> newNode = new Node<>(value, top);
        top = newNode;
        size++;
    }

    @Override
    public String pop() {
        /** Returns the value of the node at the top of the stack */
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
    public String top() {
        /** Top is a reference to the first node in the sequence */
        return top.getValue();
    }

    @Override
    public String toString() {
        return size + ", " + top;
    }
    
}
