package unit11.activities;

public class Waiter implements Runnable {
    private Object lock;

    public Waiter(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            synchronized(lock) {
                lock.wait();
            }
        } catch(InterruptedException e) {}
        System.out.println("I'm awake!");
    }

    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        for (int i = 0; i < 10; i++) {
            Waiter waiter = new Waiter(lock);
            new Thread(waiter).start();
        }

        Thread.sleep(1);

        synchronized(lock) {
            lock.notifyAll();
            System.out.println("Notified!");
        }
    }
    
}
