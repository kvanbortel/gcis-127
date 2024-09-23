/* This program creates Doll, Robot, and ActionFigure toys which can be played with in different ways.
   Author: Kayla Van Bortel */

package unit07.toys;

import unit07.products.Product;

public abstract class Toy extends Product {
    private static int count = 0;

    public Toy(String name, double msrp) {
        super(name, msrp, generateProductCode());
        count++;
    }

    public static int generateProductCode() {
    /** Each product code is unique because it's based on the object count */
        return 1000000 + count;
    }
}
