package unit08.mcf;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class NodeQueueTest {
    @Test
    public void sizeTest() {
        // setup
        Queue<String> queue = new NodeQueue<>();

        // invoke
        int actual = queue.size();

        // analyze
        assertEquals(actual, 0);
    }

    @Test
    public void toStringTest() {
        // setup
        Queue<String> queue = new NodeQueue<>();

        // invoke
        String actual = queue.toString();

        // analyze
        assertEquals(actual, "0, null");
    }

    @Test
    public void enqueueTestEmpty() {
        // setup
        Queue<String> queue = new NodeQueue<>();

        // invoke
        queue.enqueue("value");

        // analyze
        assertEquals(queue.toString(), "1, value->null");
    }

    @Test
    public void enqueueTestNotEmpty() {
        // setup
        Queue<String> queue = new NodeQueue<>();

        // invoke
        queue.enqueue("First");
        queue.enqueue("Second");
        queue.enqueue("Third");

        // analyze
        assertEquals(queue.toString(), "3, First->Second->Third->null");
    }

    @Test
    public void dequeueTestOne() {
        // setup
        Queue<String> queue = new NodeQueue<>();
        queue.enqueue("First");

        // invoke
        String actual = queue.dequeue();

        // analyze
        assertEquals(queue.toString(), "0, null");
        assertEquals(actual, "First");
    }

    @Test
    public void dequeueTestThree() {
        // setup
        Queue<String> queue = new NodeQueue<>();
        queue.enqueue("First");
        queue.enqueue("Second");
        queue.enqueue("Third");

        // invoke
        String actual = queue.dequeue();

        // analyze
        assertEquals(actual, "First");
        assertEquals(queue.toString(), "2, Second->Third->null");
    }
}
