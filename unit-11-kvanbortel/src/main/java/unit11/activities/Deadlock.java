package unit11.activities;

public class Deadlock implements Runnable {
    private Object lock1;
    private Object lock2;
    private int id;

    public Deadlock(Object lock1, Object lock2, int id) {
        this.lock1 = lock1;
        this.lock2 = lock2;
        this.id = id;
    }

    @Override
    public void run() {
        while(true) {
            synchronized(lock1) {
                // try {
                //     Thread.sleep(100);} catch (InterruptedException ie) {}
                // }
                synchronized(lock2) {
                    System.out.println(id + ": Do stuff");
                }
            }
        }
    }
    
    public static void main(String[] args) {
        Object lock1 = new Object();
        Object lock2 = new Object();
        // Circular hold and wait
        Deadlock d1 = new Deadlock(lock1, lock2, 1);
        Deadlock d2 = new Deadlock(lock2, lock1, 2);
        new Thread(d1).start();
        new Thread(d2).start();
    }
}
