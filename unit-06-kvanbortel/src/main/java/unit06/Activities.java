package unit06;

import java.util.Arrays;

public class Activities {
    public static void evenlyDivisible(int n) {
        if (n % 2 == 0) {
            System.out.println("The number is even");
        }
        else if (n % 3 == 0) {
            System.out.println("The number is divisible by 3");
        }
        else if (n % 5 == 0) {
            System.out.println("The number is divisible by 5");
        }
        else if ((n % 2 != 0) && ((n % 3 != 0) && (n % 5 != 0))) {  // could just have "else"
            System.out.println("Odd but not divisible by 3 or 5");
        }
    }
    
    public static int countWhile(int n) {
        int sum = 0;
        int count = 0;
        while(count <= n) {
            System.out.println(count);
            sum = sum + count;
            count = count + 1;
        }
        return sum;
    }

    public static int countFor(int n) {
        int sum = 0;
        for(int count = 0; count <= n; count++) {
            System.out.println(count);
            sum = sum + count;
        }
        return sum;
    }

    public static int[] squares(int n) {
        int[] numbers = new int[n];
        for(int i = 0; i < numbers.length; i++) {
            numbers[i] = i * i;
        }
        return numbers;
    }

    public static void main(String[] args) {
        int int_num = 3;
        float pi = 3.14f;
        double double_num = 4.5;
        boolean bool = true;
        char c = 'c';

        System.out.println(int_num);
        System.out.println(pi);
        System.out.println(double_num);
        System.out.println(bool);
        System.out.println(c);

        String values = "GCIS" + "-" + 123;
        System.out.println(values);

        evenlyDivisible(2);
        evenlyDivisible(3);
        evenlyDivisible(5);
        evenlyDivisible(7);

        System.out.println((countWhile(5)));
        System.out.println(countFor(5));

        String numbers = Arrays.toString(squares(10));
        System.out.println(numbers);
    }
}
