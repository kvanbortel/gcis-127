/* This program returns a subset of the most tasks that can be completed in a given time
   Author: Kayla Van Bortel */

package unit13;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Task implements Comparable<Task> {
    private String name;
    private int hours;

    public Task(String name, int hours) {
        this.name = name;
        this.hours = hours;
    }

    public int getHours() {
        return hours;
    }

    public String getName() {
        return name;
    }

    /**
     * Get a subset of the most tasks that can be completed in the given time
     * @param tasks full list of tasks
     * @param maxHours the given time
     * @return
     */
    public static List<Task> subset(List<Task> tasks, int maxHours) {
        // Sort tasks in order of time to complete from smallest to largest
        Collections.sort(tasks);
        List<Task> subset = new ArrayList<>();
        int total = 0;
        // Loop over the tasks and add them to the subset until the max time is exceeded
        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            total += task.getHours();
            if (total > maxHours) {
                break;
            }
            subset.add(task);
        }
        return subset;
    }

    /**
     * Compare tasks by least time, otherwise alphabetically by name
     * @param o the other task
     * @return
     */
    @Override
    public int compareTo(Task o) {
        int hourCompare = this.getHours() - o.getHours();
        if (hourCompare != 0) {
            return hourCompare;
        }
        return this.getName().compareTo(o.getName());
    }

    @Override
    public String toString() {
        return this.name + " (" + this.hours + " hours)";
    }

    public static void main(String[] args) {
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task("Mop", 2));
        tasks.add(new Task("Sweep", 1));
        tasks.add(new Task("Clean Office", 6));
        tasks.add(new Task("Laundry", 3));
        tasks.add(new Task("Landscaping", 4));
        tasks.add(new Task("Clean Basement", 5));
        List<Task> subset = subset(tasks, 6);
        System.out.println(subset.toString());
    }
}
