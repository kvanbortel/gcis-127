package unit11.concurrency;

import java.util.ArrayList;
import java.util.List;

public class ListAdder implements Runnable {
    private final List<Integer> sharedList;
    private final int num;

    public ListAdder(List<Integer> sharedList, int num) {
        this.sharedList = sharedList;
        this.num = num;
    }

    @Override
    public void run() {
        for (int i = 0; i < num; i++) {
            synchronized(sharedList) {
                sharedList.add(i);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int num = 50;
        int t = 100;
        List<Integer> sharedList = new ArrayList<>();
        Thread[] threads = new Thread[t];

        for (int i = 0; i < t; i++) {
            threads[i] = new Thread(new ListAdder(sharedList, num));
            threads[i].start();
        }

        for (int i = 0; i < t; i++) {
            threads[i].join();
        }
        System.out.println(sharedList.size());

    }
    
}
