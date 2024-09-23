package unit13.practice;


public class Incrementor implements Runnable {
    private static int[] count = new int[1];

    public synchronized void increment() {
        synchronized(count) {
            Incrementor.count[0]++;
        }
    }

    public void run() {
        for (int i = 0; i < 100000; i++) {
            increment();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[10];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new Incrementor());
            threads[i].start();
        }
        for (int i = 0; i < threads.length; i++) {
            threads[i].join();
        }

        System.out.println(Incrementor.count[0]);
    }
}
