package unit11.concurrency;

import java.util.Scanner;

public class Counters {
    
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int n = scanner.nextInt();
        scanner.close();

        Thread[] threads = new Thread[n];

        for (int i = 0; i < n; i++) {
            threads[i] = new Thread(new RunnableCounter(String.valueOf("C" + i)));
            threads[i].start();
        }

        for (int i = 0; i < n; i++) {
            threads[i].join();
        }
        System.out.println("Counting all done!");
    }
}
