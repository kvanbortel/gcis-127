/*  This program simulates multiple Woolies crossing a bridge at the same time and taking different amounts of seconds
    to get to their destination.
    Author: Kayla Van Bortel */

package unit11.assignment.part1;

public class Woolie implements Runnable {
    private String name;
    private int speed;
    private String start;
    private String destination;

    public Woolie (String name, int speed, String start, String destination) {
        this.name = name;
        this.speed = speed;
        this.start = start;
        this.destination = destination;
    }

    @Override
    public void run() {
        /** Multiple Woolies can cross the bridge at a time and at different speeds and directions */
        System.out.println(name + " has arrived at the bridge at " + start + ".");
        System.out.println(name + " is starting to cross.");
        for (int i = 1; i <= speed; i++) {
            try {
                Thread.sleep(1000);
            } catch(InterruptedException ie) {}
            System.out.println("\t" + name + ": " + i + " seconds.");
        }
        System.out.println(name + " arrives at " + destination);
    }

    public static void main(String[] args) {
        //** Create four Woolie threads and have them cross the bridge */
        Thread first = new Thread(new Woolie("Albert", 2, "Courtwald", "Glassdell"));
        Thread second = new Thread(new Woolie("Bobbert", 3, "Glassdell", "Courtwald"));
        Thread third = new Thread(new Woolie("Chadbert", 5, "Glassdell", "Courtwald"));
        Thread fourth = new Thread(new Woolie("Dobbert", 10, "Courtwald", "Glassdell"));
        first.start();
        second.start();
        third.start();
        fourth.start();
    }
}
