package unit07.products;

import java.util.Random;

public class Complex {
    private Factory[] factories;

    public Complex(Factory[] factories) {
        this.factories = factories;
    }

    public void loadWithProducts(Truck truck) {
        /** Load with products from random factories until the truck is full */
        Random random = new Random();
        while (!truck.isFull()) {
            int factoryIndex = random.nextInt(factories.length);
            Product product = factories[factoryIndex].manufacture();
            truck.load(product);
        }
    }
}
