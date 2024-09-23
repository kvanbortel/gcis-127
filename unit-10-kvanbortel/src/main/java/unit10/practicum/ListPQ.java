package unit10.practicum;

import java.util.Collections;
import java.util.LinkedList;

public class ListPQ<E> implements Queue<E> {
    private int size;
    private LinkedList<E> list = new LinkedList<>();

    public ListPQ() {
        this.size = 0;
        this.list = new LinkedList<>();
    }

    @Override
    public void enqueue(E value) {
        // boolean added = false;
        // for (E element : list) {
        //     if ((Integer)value.compareTo((Integer)element) > 0) {
        //         list.add(value);
        //         added = true;
        //     }
        // }
        // if (!added) {
        //     list.add(value);
        // }
        list.add(value);
        Collections.sort(list);
        size++;
    }

    @Override
    public E dequeue() {
        size--;
        return list.remove();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        return this.toString();
    }
    
}
