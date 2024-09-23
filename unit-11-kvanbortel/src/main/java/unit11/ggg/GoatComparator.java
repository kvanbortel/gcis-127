package unit11.ggg;

import java.util.Comparator;

public class GoatComparator implements Comparator<Goat> {

    @Override
    public int compare(Goat a, Goat b) {
        return b.getTurnipsEaten() - a.getTurnipsEaten();
    }
    
}
