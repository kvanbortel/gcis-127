package unit13.practice;

public class Polite implements Runnable {
    private String message;
    private Object synchronizer;

    public Polite(String message, Object synchronizer) {
        this.message = message;
        this.synchronizer = synchronizer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            synchronized(synchronizer) {
                try {
                    synchronizer.wait();
                    System.out.println(message);
                    synchronizer.notify();
                } catch (InterruptedException ie) {}
            }
        }
    }
    
    public static void main(String[] args) throws InterruptedException {
        Object synchronizer = new Object();
        Thread one = new Thread(new Polite("After you...", synchronizer));
        Thread two = new Thread(new Polite("No, after you...", synchronizer));
        one.start();
        two.start();
        Thread.sleep(1);
        synchronized(synchronizer) {
            synchronizer.notify();
        }
    }
}
