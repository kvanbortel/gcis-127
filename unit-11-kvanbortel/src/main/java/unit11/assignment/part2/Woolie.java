/*  This program simulates one Woolie crossing a bridge at a same time with different speeds to get to their
    destination.
    Author: Kayla Van Bortel */

package unit11.assignment.part2;

public class Woolie extends Bridge implements Runnable {
    private String name;
    private int speed;
    private String start;
    private String destination;
    private Bridge bridge;

    public Woolie (String name, int speed, String start, String destination, Bridge bridge) {
        this.name = name;
        this.speed = speed;
        this.start = start;
        this.destination = destination;
        this.bridge = bridge;
    }

    @Override
    public void run() {
        /** Only one Woolie can cross the bridge at a time but it can cross at a different speeds and direction */
        // Woolies ask if they can cross the bridge up to twice a second
        while (!bridge.enterBridge()) {
            try {
                Thread.sleep(500);
            } catch(InterruptedException ie) {}
        }

        // The Woolie crosses the bridge
        System.out.println(name + " has arrived at the bridge at " + start + ".");
        System.out.println(name + " is starting to cross.");
        for (int i = 1; i <= speed; i++) {
            try {
                Thread.sleep(1000);
            } catch(InterruptedException ie) {}
            System.out.println("\t" + name + ": " + i + " seconds.");
        }
        System.out.println(name + " arrives at " + destination);
    
        // The Woolie leaves the bridge and it is set to not in use
        bridge.leaveBridge();
    }

    public static void main(String[] args) {
        //** Create four Woolie threads and have them cross the bridge */
        Bridge bridge = new Bridge();
        Thread first = new Thread(new Woolie("Albert", 2, "Courtwald", "Glassdell", bridge));
        Thread second = new Thread(new Woolie("Bobbert", 3, "Glassdell", "Courtwald", bridge));
        Thread third = new Thread(new Woolie("Chadbert", 5, "Glassdell", "Courtwald", bridge));
        Thread fourth = new Thread(new Woolie("Dobbert", 10, "Courtwald", "Glassdell", bridge));
        first.start();
        second.start();
        third.start();
        fourth.start();
    }
}
