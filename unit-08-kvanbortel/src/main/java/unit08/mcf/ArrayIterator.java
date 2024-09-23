package unit08.mcf;

import java.util.Iterator;

public class ArrayIterator<E> implements Iterator<E> {
    private Object[] elements;
    private int index;
    private int size;

    public ArrayIterator(Object[] elements, int size) {
        this.elements = elements;
        this.size = size;
        index = 0;
    }

    public boolean hasNext() {
        return index < size;
    }

    public E next() {
        E value = (E)elements[index];
        index++;
        return value;
    }
}
