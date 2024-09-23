/* This program simulates dropping various amounts of turnips into a trough.
*  Author: Kayla Van Bortel */

package unit11.ggg;

import java.util.Random;

public class TurnipDropper implements Runnable {
    private final Trough trough;

    public TurnipDropper(Trough trough) {
        this.trough = trough;
    }

    @Override
    public void run() {
        /** The dropper drops turnips with random pauses in between */
        Random random = new Random();
        while (keepDropping()) {
            dropTurnips();
            int num = random.nextInt(1, 251);
            try {
                Thread.sleep(num);
            } catch(InterruptedException e) {}
        }
        System.out.println("The turnip dropper has run out of turnips!");
    }

    protected boolean keepDropping() {
        /** The dropper will keep dropping if the trough has not reached its limit */
        synchronized(trough) {
            return !trough.atLimit();
        }
    }

    protected void dropTurnips() {
        /** 1 to 3 turnips are dropped and the goats are notified */
        Random random = new Random();
        int num = random.nextInt(1, 4);
        for (int turnip = 0; turnip < num; turnip++) {
            synchronized(trough) {
                trough.drop();
                trough.notifyAll();
            }
        }
    }
    
}
