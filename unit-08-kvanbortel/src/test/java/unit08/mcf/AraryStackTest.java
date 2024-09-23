package unit08.mcf;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class AraryStackTest {
    @Test
    public void ConstructorTest() {
        //setup

        //invoke
        ArrayStack stack = new ArrayStack();

        //analyze
        assertEquals("[null, null, null]", stack.toString());
    }

 
    @Test
    public void SizeTestTwo() {
        //setup
        ArrayStack stack = new ArrayStack();
        stack.push("One");
        stack.push("Two");

        //invoke
        

        //analyze
        assertEquals(2, stack.size());
    }

    @Test
    public void SizeTestFour() {
        //setup
        ArrayStack stack = new ArrayStack();
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
        ArrayStack stack = new ArrayStack();

        //invoke
        stack.push("One");
        stack.push("Two");
        

        //analyze
        assertEquals("[One, Two, null]", stack.toString());
    }

    @Test
    public void PushTestFour() {
        //setup
        ArrayStack stack = new ArrayStack();

        //invoke
        stack.push("One");
        stack.push("Two");
        stack.push("Three");
        stack.push("Four");

        //analyze
        assertEquals("[One, Two, Three, Four]", stack.toString());
    }

    @Test
    public void PopTest() {
        //setup
        ArrayStack stack = new ArrayStack();
        stack.push("One");
        stack.push("Two");
        stack.push("Three");
        stack.push("Four");

        //invoke
        String actual = stack.pop();
        

        //analyze
        assertEquals("[One, Two, Three, null]", stack.toString());
        assertEquals("Four", actual);
    }

    @Test
    public void TopTest() {
        //setup
        ArrayStack stack = new ArrayStack();
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
