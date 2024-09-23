package unit07.parser;

public class Increment implements Expression {
    private Expression expression;

    public Increment(Expression expression) {
        this.expression = expression;
    }

    @Override
    public double evaluate() {
        return expression.evaluate() + 1;
    }

    public static void main(String[] args) {
        Constant a = new Constant(8);
        Increment inc = new Increment(a);
        System.out.println(inc.evaluate());
    }

}
