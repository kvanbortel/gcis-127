package unit09.practicum;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ArrayTupleTest<E> {
    @Test
    public void ForEachTest() {
        // setup
        Object[] elements = new Object[]{1, 2, 3};
        Tuple<E> tuple = new ArrayTuple<>(elements);

        // invoke
        String output = "([";
        for (E each : tuple) {
            output += each + ", ";
        }
        output += "])";

        // analyze
        assertEquals(tuple.toString(), output);
    }

    @Test
    public void GetTest() {
        // setup
        Object[] elements = new Object[]{1, 2, 3};
        Tuple<E> tuple = new ArrayTuple<>(elements);

        // invoke
        E value = tuple.get(1);

        // analysis
        assertEquals(2, value);
    }
}
