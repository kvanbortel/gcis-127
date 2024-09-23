package unit10.practicum;

import java.util.PriorityQueue;

public class HeapPQ<E> implements Queue<E> {
    private int size;
    private PriorityQueue<E> heap = new PriorityQueue<>();

    public HeapPQ() {
        this.size = 0;
        this.heap = new PriorityQueue<>();
    }

    @Override
    public void enqueue(E value) {
        heap.add(value);
        size++;
    }

    @Override
    public E dequeue() {
        size--;
        return heap.remove();
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
