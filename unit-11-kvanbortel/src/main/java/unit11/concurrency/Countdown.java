package unit11.concurrency;

public class Countdown implements Runnable {
    
    @Override
    public void run() {
        int t = -10;
        while (true) {
            System.out.println("T" + t);
            try {
                Thread.sleep(1000);
            } catch(InterruptedException ie) {}
            t++;
        }
    }

    public static void main(String[] args) {
        Countdown cd = new Countdown();
        new Thread(cd).start();
    }
}
