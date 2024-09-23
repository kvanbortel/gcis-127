package unit13;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class TaskTest {
    @Test
    public void taskSet_6() {
        // Setup
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task("Mop", 2));
        tasks.add(new Task("Sweep", 1));
        tasks.add(new Task("Clean Office", 6));
        tasks.add(new Task("Laundry", 3));
        tasks.add(new Task("Landscaping", 4));
        tasks.add(new Task("Clean Basement", 5));

        // Invoke
        List<Task> subset = Task.subset(tasks, 6);

        // Analysis
        List<Task> expected = new ArrayList<>();
        expected.add(tasks.get(0));
        expected.add(tasks.get(1));
        expected.add(tasks.get(2));
        assertEquals(expected, subset);
    }
}
