package unit13.practice;

import java.util.Random;

public class Sleeper implements Runnable {
    private int seconds;

    public Sleeper(int seconds) {
        this.seconds = seconds;
    }

    @Override
    public void run() {
        System.out.println("Going to sleep...");
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException ioe) {}
        
        System.out.println("Awake!");
    }

    public static void main(String[] args) throws InterruptedException {
        // Random random = new Random();
        // Thread t1 = new Thread(new Sleeper(random.nextInt(5)));
        // Thread t2 = new Thread(new Sleeper(random.nextInt(5)));
        // Thread t3 = new Thread(new Sleeper(random.nextInt(5)));
        // Thread t4 = new Thread(new Sleeper(random.nextInt(5)));
        // Thread t5 = new Thread(new Sleeper(random.nextInt(5)));
        // t1.start();
        // t2.start();
        // t3.start();
        // t4.start();
        // t5.start();
        // t1.join();
        // t2.join();
        // t3.join();
        // t4.join();
        // t5.join();
        // System.out.println("Done!");

        Thread[] threads = new Thread[5];
        Random random = new Random();
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new Sleeper(random.nextInt(10) + 1));
            threads[i].start();
        }
        for (int i = 0; i < threads.length; i++) {
            threads[i].join();
        }

        System.out.println("Done!");

    }
}
