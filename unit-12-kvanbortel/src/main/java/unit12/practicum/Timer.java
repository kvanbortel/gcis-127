//* The lists are different types so it takes different times */

package unit12.practicum;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Timer implements Runnable {
   public static void timing(String name, List<Integer> list, int numberOfValues) {
        double time = System.nanoTime();
        for (int i = 0; i < numberOfValues; i++) {
            list.add(i);
        }
        double elapsed = System.nanoTime() - time;
        System.out.println("Filled " + name + " with " + numberOfValues + "in " + String.format("%,d", elapsed) + " nanoseconds");
   }

   @Override
    public void run() {
        this.timing();
    }

   /**    e. Define a main method with the appropriate signature and use it to 
       create a thread that times an java.util.ArrayList and a second thread 
       that times a java.util.Vector with the same number of values. The 
       threads must run concurrently. Depending on the speed of your processor, 
       you may need to use a somewhat large number of values, e.g. 100,000,000. 
       What do you see? */
    
    public static void main(String[] args) {
        Thread array = new Thread(timing("ArrayList", new ArrayList<>(), 100000000));
        Thread vector = new Thread(timing("Vector", new Vector<>(), 100000000););
        array.start();
        vector.start();
    }


}
