package unit06;

public class Calculon {
    public static double add(double num1, double num2) {
        return num1 + num2;
    }
    
    public static double subtract(double num1, double num2) {
        return num1 - num2;
    }

    public static double multiply(double num1, double num2) {
        return num1 * num2;
    }

    public static double divide(double num1, double num2) {
        return num1 / num2;
    }
    
    public static void main(String[] args) {
        System.out.println(add(4, 2));
        System.out.println(subtract(4, 2));
        System.out.println(multiply(4, 2));
        System.out.println(divide(4, 2));
    }
}
