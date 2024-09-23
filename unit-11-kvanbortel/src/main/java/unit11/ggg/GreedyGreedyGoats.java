/* This program simulates goats fighting over turnips that are being dropped into a trough to see which can eat the msot.
*  Author: Kayla Van Bortel */

package unit11.ggg;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GreedyGreedyGoats {
    public static void main(String[] args) {
        final int LIMIT = 250;

        // A turnip dropper and four goats are initialized and begin running as threds
        Trough trough = new Trough(LIMIT);
        Thread td = new Thread(new TurnipDropper(trough));
        td.start();
        Goat goat1 = new Goat(Color.CYAN, trough);
        Goat goat2 = new Goat(Color.GREEN, trough);
        Goat goat3 = new Goat(Color.ORANGE, trough);
        Goat goat4 = new Goat(Color.YELLOW, trough);
        Thread g1 = new Thread(goat1);
        Thread g2 = new Thread(goat2);
        Thread g3 = new Thread(goat3);
        Thread g4 = new Thread(goat4);
        g1.start();
        g2.start();
        g3.start();
        g4.start();

        // The threads are joined so that messages can print when they are complete
        try {
            g1.join();
            g2.join();
            g3.join();
            g4.join();
            td.join();
        } catch (InterruptedException e) {}

        System.out.println("The game is over! A total of " + trough.getTurnipsSoFar() +
                            " turnips were dropped into the trough!");
        // The goats are sorted by how much they have eaten and then printed
        List<Goat> goats = new ArrayList<>();
        goats.add(goat1);
        goats.add(goat2);
        goats.add(goat3);
        goats.add(goat4);
        Collections.sort(goats, new GoatComparator());
        int total = 0;
        for (Goat goat: goats) {
            System.out.println(goat.toString() + " ate " + goat.getTurnipsEaten() + " turnips!");
            total += goat.getTurnipsEaten();
        }
        System.out.println("Together, the goats ate " + total + "/" + LIMIT + " turnips!");
    }


}
