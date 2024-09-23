package unit08.mcf;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class IntRangeTest {
    @Test
    public void ConstructorTest() {
        // setup

        // invoke
        Range range = new IntRange(1, 5, 2);

        // analysis
        assertEquals("1, 5, 2", range.toString());
    }
    
    @Test
    public void SizeTest() {
        // setup
        Range range = new IntRange(10);

        // invoke
        int actual = range.size();

        // analysis
        assertEquals(10, actual);
    }

    @Test
    public void GetTest() {
        // setup
        Range range = new IntRange(10);

        // invoke
        int actual = range.get(5);

        // analysis
        assertEquals(5, actual);
    }

    @Test
    public void ForEachTest() {
        // setup
        Range range = new IntRange(2, 10, 2);
        int[] nums = new int[] {2, 4, 6, 8};

        // invoke
        int index = 0;
        for(int i : range) {
            assertEquals(nums[index], i);
            index++;
        }

        // analysis
        
    }
}
