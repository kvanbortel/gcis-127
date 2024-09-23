package unit06;

public enum Material {
    CERAMIC(3.99),
    STAINLESS_STEEL(10.99),
    GLASS(15.99),
    BAMBOO(6.99),
    PORCELAIN(3.99),
    PLASTIC(2.99);

    private double price;

    private Material(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name() + " (" + price + ")";
    }
}
