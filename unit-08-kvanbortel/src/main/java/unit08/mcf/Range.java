package unit08.mcf;

import java.util.Iterator;

public interface Range extends Iterable<Integer> {
    int size();
    int get(int index);
    Iterator<Integer> iterator();

}
