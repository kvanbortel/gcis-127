package unit08.mcf;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class FibonacciRangeTest {
    @Test
    public void ConstructorTest() {
        // setup

        // invoke
        Range range = new FibonacciRange(45);

        // analysis
        assertEquals("FibonacciRange(45)", range.toString());
    }
    
    @Test
    public void SizeTest() {
        // setup
        Range range = new FibonacciRange(10);

        // invoke
        int actual = range.size();

        // analysis
        assertEquals(10, actual);
    }

    @Test
    public void GetTest() {
        // setup
        Range range = new FibonacciRange(10);

        // invoke
        int actual = range.get(5);

        // analysis
        assertEquals(5, actual);
    }

    @Test
    public void ForEachTest() {
        // setup
        Range range = new FibonacciRange(5);
        int[] nums = new int[] {0, 1, 1, 2, 3};

        // invoke
        int index = 0;
        for(int i : range) {
            assertEquals(nums[index], i);
            index++;
        }

        // analysis
        assertEquals(nums.length, index);
    }
}
