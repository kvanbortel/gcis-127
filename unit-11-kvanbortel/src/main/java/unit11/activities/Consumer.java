package unit11.activities;

import java.util.LinkedList;
import java.util.Queue;

public class Consumer implements Runnable {
    private Queue<String> queue;
    private int id;

    public Consumer(Queue<String> queue, int id) {
        this.queue = queue;
        this.id = id;
    }

    @Override
    public void run() {
        while(true) {
            synchronized(queue) {
                if (!queue.isEmpty()) {
                    System.out.println(id + ": " + queue.remove());
                }
                else {
                    try {
                        System.out.println("Waiting for item to be added to queue.");
                        queue.wait();
                    } catch (InterruptedException ie) {}
                }
            }
        }
    }

    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        queue.add("First");
        queue.add("Second");
        Consumer consumer = new Consumer(queue, 1);
        new Thread(consumer).start();
    }
    
}
