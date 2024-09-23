package unit10;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import unit10.practicum.HeapPQ;

public class HeapPQTest {
    @Test
    public void enqueueTest() {
        // setup
        HeapPQ<Integer> heap = new HeapPQ<>();

        // invoke
        heap.enqueue(3);
        heap.enqueue(6);
        heap.enqueue(1);

        // analysis
        assertEquals("3, 6, 1", heap.toString());
    }

    @Test
    public void dequeueTest() {
        // setup
        HeapPQ<Integer> heap = new HeapPQ<>();

        // invoke
        heap.enqueue(3);
        heap.enqueue(1);
        heap.enqueue(6);
        Object value = heap.dequeue();

        // analysis
        assertEquals(1, value);
    }
}
