package unit07.parser;

public class Addition implements Expression {
    public Expression left;
    public Expression right;

    public Addition(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public double evaluate() {
        return left.evaluate() + right.evaluate();
    }

    public static void main(String[] args) {
        Constant a = new Constant(9);
        Constant b = new Constant(1);
        Addition add = new Addition(a, b);
        System.out.println(add.evaluate());
    }
}
