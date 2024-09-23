/* This program simulates a stack using arrays. 
   Author: Kayla Van Bortel */


package unit08.mcf;

import java.util.Arrays;

public class ArrayStack implements Stack {
    private String[] elements;
    private int size;

    public ArrayStack() {
        elements = new String[3];
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void push(String value) {
        /** Adds a new element to the stack */
        if (size == elements.length) {
            String[] newElements = Arrays.copyOf(elements, elements.length + 1);
            newElements[newElements.length - 1] = value;
            elements = newElements;
            size++;
        }
        else {
            elements[size] = value;
            size++;
        }
    }

    @Override
    public String pop() {
        /** Returns the top value of the stack */
        String top = elements[elements.length - 1];
        elements[elements.length - 1] = null;
        size--;
        return top;
    }

    @Override
    public String top() {
        return elements[elements.length - 1];
    }

    @Override
    public String toString() {
        return Arrays.toString(elements);
    }
    
}
