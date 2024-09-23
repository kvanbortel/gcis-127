package unit09.practicum;

import java.util.Iterator;
import java.util.Arrays;

public class ArrayTuple<E> implements Tuple<E> {
    private Object[] elements;
    private int size;

    public ArrayTuple(Object[] elements) {
        this.elements = elements;
    }

    @Override
    public int size() {
        return elements.length;
    }

    @Override
    public E get(int index) {
        return (E)elements[index];
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayIterator<>(elements, size);
    }

    @Override
    public String toString() {
        return "(" + Arrays.toString(elements) + ")";
    }
}
