package unit07.parser;

public class Decrement implements Expression {
    private Expression expression;

    public Decrement(Expression expression) {
        this.expression = expression;
    }

    @Override
    public double evaluate() {
        return expression.evaluate() - 1;
    }

    public static void main(String[] args) {
        Constant a = new Constant(8);
        Decrement dec = new Decrement(a);
        System.out.println(dec.evaluate());
    }

}
