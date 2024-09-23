package unit08;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class MugTest {
    @Test
    public void ConstructorTest() {
        // setup
        double size = 16;
        String color = "Teal";
        Material material = Material.STAINLESS_STEEL;
        String phrase = "Constructor Test";

        // invoke
        Mug actual = new Mug(size, color, material, phrase);

        // analyze
        assertEquals(actual.getSize(), size);
        assertEquals(actual.getColor(), color);
        assertEquals(actual.getMaterial(), material);
        assertEquals(actual.getPhrase(), phrase);
    }

    // @Test
    // public void FillTest() {
    //     double amount = 4;

    //     int actual = 4;

    //     assertEquals(actual.fill(), fillLevel);
    // }
}
