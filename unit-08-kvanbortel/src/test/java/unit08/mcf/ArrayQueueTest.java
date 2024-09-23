package unit08.mcf;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ArrayQueueTest {
    @Test
    public void ConstructorTest() {
        // setup

        // invoke
        Queue<String> queue = new ArrayQueue<>();

        // analyze
        assertEquals(queue.toString(), "0, [null, null, null]");
    }

    @Test
    public void enqueueThree() {
        // setup
        Queue<String> queue = new ArrayQueue<>();

        // invoke
        queue.enqueue("First");
        queue.enqueue("Second");
        queue.enqueue("Third");

        // analyze
        assertEquals(queue.toString(), "3, [First, Second, Third]");
    }

    @Test
    public void dequeueTestOne() {
        // setup
        Queue<String> queue = new ArrayQueue<>();
        queue.enqueue("First");

        // invoke
        String actual = queue.dequeue();

        // analyze
        assertEquals(queue.toString(), "0, [null, null, null]");
        assertEquals(actual, "First");
    }

    @Test
    public void dequeueTestThree() {
        // setup
        Queue<String> queue = new ArrayQueue<>();
        queue.enqueue("First");
        queue.enqueue("Second");
        queue.enqueue("Third");

        // invoke
        String actual = queue.dequeue();

        // analyze
        assertEquals(actual, "First");
        assertEquals(queue.toString(), "2, [null, Second, Third]");
    }

    @Test
    public void wrapping() {
        // setup
        Queue<String> queue = new ArrayQueue<>();
        queue.enqueue("First");
        queue.enqueue("Second");
        queue.enqueue("Third");
        queue.dequeue();
        queue.enqueue("Fourth");

        // invoke
        String actual = queue.dequeue();

        // analyze
        assertEquals(actual, "Second");
        assertEquals(queue.toString(), "2, [Fourth, null, Third]");
    }

    @Test
    public void resize() {
        // setup
        Queue<String> queue = new ArrayQueue<>();
        queue.enqueue("First");
        queue.enqueue("Second");
        queue.dequeue();
        queue.dequeue();
        queue.enqueue("Third");
        queue.enqueue("Fourth");
        queue.enqueue("Fifth");

        // invoke
        queue.enqueue("Sixth");

        // analyze
        assertEquals(queue.toString(), "4, [Third, Fourth, Fifth, Sixth, null, null]");
    }
}
