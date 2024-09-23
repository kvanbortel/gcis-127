package unit11;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import unit11.ggg.Color;
import unit11.ggg.Goat;
import unit11.ggg.Trough;
import unit11.ggg.TurnipDropper;

public class TurnipDropperTest {
    @Test
    public void dropTurnipsTest() {
        // setup
        Trough trough = new Trough(10);
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
        assertEquals(10, trough.getTurnipsSoFar());
    }
}
