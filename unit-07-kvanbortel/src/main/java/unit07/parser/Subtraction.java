package unit07.parser;

public class Subtraction implements Expression {
    public Expression left;
    public Expression right;

    public Subtraction(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public double evaluate() {
        return left.evaluate() - right.evaluate();
    }

    public static void main(String[] args) {
        Constant a = new Constant(9);
        Constant b = new Constant(1);
        Subtraction sub = new Subtraction(a, b);
        System.out.println(sub.evaluate());
    }
}
