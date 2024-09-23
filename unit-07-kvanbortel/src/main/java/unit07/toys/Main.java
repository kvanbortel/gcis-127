/** This program simulates loading and unloading trucks at complexes with different product factories.
 *  Author: Kayla Van Bortel */

package unit07.toys;

import unit07.products.ActionFigureFactory;
import unit07.products.Complex;
import unit07.products.DollFactory;
import unit07.products.RobotFactory;
import unit07.products.Factory;
import unit07.products.Truck;

public class Main {
    public static void main(String[] args) {
        /* Polymorphism is used to decrease copies of the same code and to make the program more flexible for
            adding new products. All that needs to be added is a new class for the new product, and the truck
            and complex classes will already be able to handle it.*/
        Complex complex = new Complex(new Factory[] {new RobotFactory(), new DollFactory(), new ActionFigureFactory()});
        Truck truck = new Truck(6);
        complex.loadWithProducts(truck);
        while (!truck.isEmpty()) {
            System.out.println(truck.unload());
        }
    }
}
