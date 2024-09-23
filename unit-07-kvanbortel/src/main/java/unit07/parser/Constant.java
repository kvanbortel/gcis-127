package unit07.parser;

public class Constant implements Expression {
    private double value;

    public Constant(double value) {
        this.value = value;
    }

    @Override
    public double evaluate() {
        return value;
    }

    public static void main(String[] args) {
        Constant a = new Constant(6.2);
        System.out.println(a.evaluate());
    }
}
