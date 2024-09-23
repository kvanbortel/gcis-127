package unit08.mcf;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ArrayListTest {
    @Test
    public void ConstructorTest() {
        // setup

        // invoke
        List<String> list = new ArrayList<>();

        // analysis
        assertEquals("0, [null, null]", list.toString());
    }

    @Test
    public void AppendTest() {
        // setup
        List<String> list = new ArrayList<>();

        // invoke
        list.append("One");

        // analysis
        assertEquals("1, [One, null]", list.toString());
    }

    @Test
    public void AppendThreeTest() {
        // setup
        List<String> list = new ArrayList<>();

        // invoke
        list.append("One");
        list.append("Two");
        list.append("Three");

        // analysis
        assertEquals("3, [One, Two, Three, null]", list.toString());
    }
}
