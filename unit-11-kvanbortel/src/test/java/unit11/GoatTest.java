package unit11;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import unit11.ggg.Color;
import unit11.ggg.Goat;
import unit11.ggg.Trough;
import unit11.ggg.TurnipDropper;

public class GoatTest {
    @Test
    public void constructor() {
        // setup
        Color color = Color.CYAN;
        Trough trough = new Trough(10);

        // invoke
        Goat goat = new Goat(color, trough);

        // analysis
        assertEquals("The CYAN goat", goat.toString());
    }

    @Test
    public void runOneTurnip() {
        // setup
        Trough trough = new Trough(1);
        Thread td = new Thread(new TurnipDropper(trough));
        Goat goat = new Goat(Color.CYAN, trough);
        Thread goatThread = new Thread(goat);

        // invoke
        td.start();
        goatThread.start();
        try {
            goatThread.join();
        } catch (InterruptedException ie) {}

        // analysis
        assertEquals(true, trough.isEmpty());
        assertEquals(1, goat.getTurnipsEaten());
    }
}
