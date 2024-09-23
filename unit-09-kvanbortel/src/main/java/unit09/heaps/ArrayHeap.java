package unit09.heaps;

import java.util.Arrays;

public class ArrayHeap implements Heap {
    private int[] array;
    private int size;

    public ArrayHeap () {
        array = new int[3];
        size = 0;
    }

    @Override
    public void add(int value) {
        if (size == array.length) {
            array = Arrays.copyOf(array, size * 2);
        }
        array[size] = value;
        int childIndex = size;
        int parentIndex = (childIndex - 1) / 2;
        while (childIndex > 0 && array[childIndex] < array[parentIndex]) {
            swap(childIndex, parentIndex);
            childIndex = parentIndex;
            parentIndex = (childIndex - 1) / 2;
        }
        size++;
    }

    @Override
    public int remove() {
        int value = array[0];
        swap(0, size - 1);
        array[size - 1] = 0;
        size--;

        int parent = 0;
        while (parent < size) {
            int left = parent * 2 + 1;
            int right = parent * 2 + 2;
            int swap = left;
            if (right < size) {
                if (array [right] < array[left]) {
                    swap = right;
                }
            }
            if (swap < size && array[swap] < array[parent]) {
                swap (swap, parent);
            }
            else {
                parent = size;
            }
        }
        return value;
    }

    @Override
    public int size() {
        return size;
    }

    private void swap(int a, int b) { // TODO: fix this or add
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;

    }

    @Override
    public String toString() {
        return size + ", " + Arrays.toString(array);
    }

    public static void main(String[] args) {
        Heap heap = new ArrayHeap();
        System.out.println(heap);

        heap.add(4);
        heap.add(2);
        heap.add(3);
        heap.add(1);
        

        // heap.add(2);
        // heap.add(1);
        // heap.add(8);
        // heap.add(6);
        // heap.add(3);
        System.out.println(heap);

        System.out.println(heap.remove());
        System.out.println(heap);
        System.out.println(heap.remove());
        System.out.println(heap);
        System.out.println(heap.remove());
        System.out.println(heap);
    }
}
