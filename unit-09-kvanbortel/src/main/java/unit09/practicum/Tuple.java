package unit09.practicum;

import java.util.Iterator;

public interface Tuple<E> extends Iterable<E> {
    int size();
    E get(int index);
    Iterator<E> iterator();
}

