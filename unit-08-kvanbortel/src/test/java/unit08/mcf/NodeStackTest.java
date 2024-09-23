package unit08.mcf;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class NodeStackTest {
    @Test
    public void ConstructorTest() {
        //setup

        //invoke
        NodeStack stack = new NodeStack();

        //analyze
        assertEquals("0, null", stack.toString());
    }

 
    @Test
    public void SizeTestTwo() {
        //setup
        NodeStack stack = new NodeStack();
        stack.push("One");
        stack.push("Two");

        //invoke
        

        //analyze
        assertEquals(2, stack.size());
    }

    @Test
    public void SizeTestFour() {
        //setup
        NodeStack stack = new NodeStack();
        stack.push("One");
        stack.push("Two");
        stack.push("Three");
        stack.push("Four");

        //invoke
        

        //analyze
        assertEquals(4, stack.size());
    }

    @Test
    public void PushTestTwo() {
        //setup
        NodeStack stack = new NodeStack();

        //invoke
        stack.push("One");
        stack.push("Two");
        

        //analyze
        assertEquals("2, Two->One->null", stack.toString());
    }

    @Test
    public void PushTestFour() {
        //setup
        NodeStack stack = new NodeStack();

        //invoke
        stack.push("One");
        stack.push("Two");
        stack.push("Three");
        stack.push("Four");

        //analyze
        assertEquals("4, Four->Three->Two->One->null", stack.toString());
    }

    @Test
    public void PopTest() {
        //setup
        NodeStack stack = new NodeStack();
        stack.push("One");
        stack.push("Two");
        stack.push("Three");
        stack.push("Four");

        //invoke
        String actual = stack.pop();
        

        //analyze
        assertEquals("3, Three->Two->One->null", stack.toString());
        assertEquals("Four", actual);
    }

    @Test
    public void TopTest() {
        //setup
        NodeStack stack = new NodeStack();
        stack.push("One");
        stack.push("Two");
        stack.push("Three");
        stack.push("Four");

        //invoke
        String actual = stack.top();
        

        //analyze
        assertEquals("Four", actual);
    }
}
