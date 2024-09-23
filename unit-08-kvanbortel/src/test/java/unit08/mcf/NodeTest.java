package unit08.mcf;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class NodeTest {
    @Test
    public void ConstructorTest() {
        // setup
        String value = "First";

        //invoke
        Node<String> actual = new Node<>(value);

        //analysis
        assertEquals(actual.getValue(), value);
        assertEquals(actual.getNext(), null);
    }

    @Test
    public void SetNextTest() {
        // setup
        String value = "First";
        Node<String> first = new Node<>(value);
        Node<String> second = new Node<>("Last");

        // invoke
        first.setNext(second);
        
        //analysis
        assertEquals(first.getNext(), second);
    }
}
