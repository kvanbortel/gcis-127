package unit11.activities;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Producer implements Runnable {
    private Queue<String> queue;
    private int id;
    private int count;

    public Producer(Queue<String> queue, int id) {
        this.queue = queue;
        this.id = id;
        count = 0;
    }

    
    @Override
    public void run() {
        Random random = new Random();
        while(true) {
            int num = random.nextInt(1, 5);
            for (int i = 0; i < num; i++) {
                synchronized(queue) {
                    queue.add(id + ": Message" + count);
                }
                count++;
            }
            synchronized(queue) {
                queue.notifyAll();
            }
            try {
                Thread.sleep(1000);
            } catch(InterruptedException ie) {}
        }
    }

    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        Consumer consumer = new Consumer(queue, 1);
        Producer producer = new Producer(queue, 10);
        new Thread(consumer).start();
        new Thread(producer).start();
    }
    
}
