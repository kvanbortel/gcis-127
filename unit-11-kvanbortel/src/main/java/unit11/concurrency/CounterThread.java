package unit11.concurrency;

public class CounterThread extends Thread {
    private String name;

    public CounterThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            System.out.println(name + ": " + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread counter = new CounterThread("counter");
        counter.start();
        int count = 0;
        while (counter.isAlive()) {
            Thread.sleep(50);
            count++;
        }

        for (char ch = 'A'; ch <= 'Z'; ch++) {
            System.out.print(ch + " ");
        }

        System.out.println("\nChecked isAlive " + count + " times");

        // counter.start(); // You can't restart a thread
    }
}
