package unit08.mcf;

public interface Queue<E> extends Iterable<E> {
    
    void enqueue(E value);

    E dequeue();

    int size();
}
