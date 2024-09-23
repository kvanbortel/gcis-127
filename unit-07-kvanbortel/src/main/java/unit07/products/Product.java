package unit07.products;

public abstract class Product {
    private String name;
    private int productCode;
    private double msrp;

    public Product(String name, double msrp, int productCode) {
        this.name = name;
        this.msrp = msrp;
        this.productCode = productCode;
    }

    public int getProductCode() {
        return productCode;
    }

    public String getName() {
        return name;
    }

    public double getMsrp() {
        return msrp;
    }
}
