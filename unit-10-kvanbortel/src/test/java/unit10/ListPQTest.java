package unit10;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.LinkedList;

import org.junit.jupiter.api.Test;

import unit10.practicum.HeapPQ;

public class ListPQTest {
    @Test
    public void enqueueTest() {
        // setup
        ListPQ<Integer> list = new ListPQ<>();

        // invoke
        list.enqueue(3);
        list.enqueue(6);
        list.enqueue(1);

        // analysis
        assertEquals("3, 6, 1", list.toString());
    }

    @Test
    public void dequeueTest() {
        // setup
        ListPQ<Integer> list = new ListPQ<>();

        // invoke
        list.enqueue(3);
        list.enqueue(1);
        list.enqueue(6);
        Object value = list.dequeue();

        // analysis
        assertEquals(1, value);
    }
}
