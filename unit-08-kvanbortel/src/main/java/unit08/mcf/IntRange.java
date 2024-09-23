/* This program iterates through an integer range
   Author: Kayla Van Bortel */

package unit08.mcf;

import java.util.Iterator;

public class IntRange implements Range {
    private int start;
    private int stop;
    private int step;


    public IntRange(int start, int stop, int step) {
        this.start = start;
        this.stop = stop;
        this.step = step;
    }

    public IntRange(int start, int stop) {
        this.start = start;
        this.stop = stop;
        this.step = 1;
    }

    public IntRange(int stop) {
        this.start = 0;
        this.stop = stop;
        this.step = 1;
    }

    @Override
    public int size() {
        /** Returns the size of the range */
        return ((stop - start) + 1) / step;
    }

    @Override
    public int get(int index) {
        /** Gets the value given the index */
        int value = start + step * index;
        if (index > size()) {
            throw new IndexOutOfBoundsException("Index out of bounds!");
        }
        return value;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new RangeIterator(this);
    }

    @Override
    public String toString() {
        return start + ", " + stop + ", " + step;
    }

    public static void main(String[] args) {
        for(int i : new IntRange(2, 20, 3)) {
            System.out.println(i);
        }

        for(int i : new IntRange(10)) {
            System.out.println(i);
        }

        for(int i : new IntRange(-3, 5, 1)) {
            System.out.println(i);
        }

        for(int i : new IntRange(0, 6)) {
            System.out.println(i);
        }
    }
}
