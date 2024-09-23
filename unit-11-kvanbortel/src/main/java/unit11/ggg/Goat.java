/* This program simulates a goat that tries to eat turnips from a trough.
*  Author: Kayla Van Bortel */

package unit11.ggg;

public class Goat implements Runnable {
    private Color color;
    private Trough trough;
    private int turnipsEaten;

    public Goat(Color color, Trough trough) {
        this.color = color;
        this.trough = trough;
    }

    @Override
    public void run() {
        /** The goat tries to eat turnips so long as it can. Otherwise, it waits. */
        while (keepEating()) {
            tryToEat();
        }
        System.out.println(this.toString() + " is waiting for more turnips.");
        waitForTurnips();
    }

    public int getTurnipsEaten() {
        return turnipsEaten;
    }
    
    @Override
    public String toString() {
        return "The " + color + " goat";
    }

    protected boolean keepEating() {
        /** The goat can keep eating if the trough is not at the limit and is not empty */
        synchronized(trough) {
            return !(trough.atLimit() && trough.isEmpty());
        }
    }

    protected void waitForTurnips() {
        /** The goat waits for turnips while the trough is empty and not at its limit */
        synchronized(trough) {
            while(!trough.atLimit() && trough.isEmpty()) {
                try {
                    trough.wait();
                } catch(InterruptedException e) {}
            }
        }
    }

    protected void tryToEat() {
        /** The eats turnips, adding to the amount they have eaten. */
        synchronized(trough) {
            if(trough.eat()) {
                System.out.println(this.toString() + " has eaten a turnip!");
                this.turnipsEaten++;
            }
        }
    }
}
