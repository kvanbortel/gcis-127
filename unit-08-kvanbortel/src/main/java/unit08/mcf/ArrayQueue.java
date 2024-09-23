package unit08.mcf;

import java.util.Arrays;
import java.util.Iterator;

public class ArrayQueue<E> implements Queue<E> {
    private E[] elements;
    private int front;
    private int back;
    private int size;

    public ArrayQueue() {
        elements = (E[])new Object[3];
        front = 0;
        back = 0;
        size = 0;
    }

    private void resize() {
        E[] newElements = (E[])new Object[elements.length * 2];
        int i = 0;
        while (front != back) {
            newElements[i] = elements[front];
            i++;
            front = (front + 1) % elements.length;
        }
        // for (int i = 0; i < elements.length; i++) {
        //     newElements[i] = elements[(front + i) % size];
        // }
        front = 0;
        back = size;
        elements = newElements;
    }

    @Override
    public void enqueue(E value) {
        if (size == (elements.length - 1)) {
            resize();
        }
        elements[back] = value;
        back = (back + 1) % elements.length;
        size++;
    }

    @Override
    public E dequeue() {
        E value = elements[front];
        elements[front] = null;
        front = (front + 1) % elements.length;
        size--;
        return value;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        return size + ", " + Arrays.toString(elements);
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayIterator<E>(elements, size);
    }

    public static void main(String[] args) {
        Queue<String> q = new ArrayQueue<>();
        q.enqueue("Test");
        q.enqueue("Two");
        for (String s : q) {
            System.out.println(s);
        }
    }
    
}
