package unit08.mcf;

import java.util.Arrays;
import java.util.Iterator;

public class ArrayList<E> implements List<E> {
    private Object[] elements;
    private int size;

    public ArrayList() {
        elements = new Object[2];
        size = 0;
    }

    @Override
    public void append(E value) {
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, size * 2);
        }
        elements[size] = value;
        size++;
    }

    @Override
    public E get(int index) {
        return (E)elements[index];
    }

    @Override
    public void set(int index, E value) {
        elements[index] = value;
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
        return new ArrayIterator<>(elements, size);
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.append("1");
        list.append("2");
        list.append("3");
        list.append("4");
        System.out.println(list.toString());
    }
    
}
