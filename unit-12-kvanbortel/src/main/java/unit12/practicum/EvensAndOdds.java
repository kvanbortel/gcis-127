package unit12.practicum;

public class EvensAndOdds implements Runnable {
    // private static Object lock1;
    // private static Object lock2;

    public EvensAndOdds() {
    }


    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            if (i % 2 != 0) {
                System.out.println(i);
            }
        }

        synchronized(this) {
            try {
                this.wait();
            } catch(InterruptedException ie) {}
        }

        for (int i = 1; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }
        notifyAll();
    }

    public static void main(String[] args) {
        EvensAndOdds odds = new EvensAndOdds();
        EvensAndOdds evens = new EvensAndOdds();
        
        Thread oddsT = new Thread(odds);
        oddsT.start();
        Thread evensT = new Thread(evens);
        evensT.start();
    }
}
