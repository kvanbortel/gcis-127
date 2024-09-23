package unit07.products;

public class Truck {
    private int capacity;
    private Product[] products;
    private int next = 0;

    public Truck(int capacity) {
        this.capacity = capacity;
        this.products = new Product[capacity];
    }

    public void load(Product product) {
        products[next] = product;
        next++;
    }

    public Product unload() {
        next--;
        return products[next];
    }

    public boolean isFull() {
        return next == capacity;
    }

    public boolean isEmpty() {
        return next == 0;
    }
}
