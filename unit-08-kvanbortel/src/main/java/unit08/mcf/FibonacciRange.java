/* This program iterates through the Fibonacci sequence
   Author: Kayla Van Bortel */

package unit08.mcf;

import java.util.Iterator;

public class FibonacciRange implements Range {
    private int size;

    public FibonacciRange(int size) {
        this.size = size;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int get(int index) {
        return fibonacci(index);
    }

    @Override
    public Iterator<Integer> iterator() {
        return new RangeIterator(this);
    }

    public static int fibonacci(int n) {
        /** Iterates through the Fibonacci sequence */
        int fn1 = 1;
        int fn2 = 0;

        while (n > 1) {
            int temp = fn1;
            fn1 = fn1 + fn2;
            fn2 = temp;
            n--;
        }

        if (n == 1) {
            return fn1;
        }
        else {
            return fn2;
        }
    }

    @Override
    public String toString() {
        return "FibonacciRange(" + size + ")";
    }

    public static void main(String[] args) {
        FibonacciRange fibrange = new FibonacciRange(45);
        for (int element : fibrange) {
            System.out.println(element);
        }
    }
}
