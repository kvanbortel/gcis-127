package unit08.mcf;

import java.util.Iterator;

public interface List<E> extends Iterable<E> {
    void append(E value);

    E get(int index);

    void set(int index, E value);

    int size();
    
    @Override
    default Iterator<E> iterator() {
        throw new UnsupportedOperationException ("Unimplemented method 'iterator'");
    }
}
