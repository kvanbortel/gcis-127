package unit07.toys;

public class Robot extends Toy {
    private int chargeLevel;
    private String sound;

    public String getSound() {
        return sound;
    }

    public int getChargeLevel() {
        return chargeLevel;
    }

    public Robot(int chargeLevel, String sound) {
        super("Robot", 59.99);
        this.chargeLevel = chargeLevel;
        this.sound = sound;
    }

    @Override
    public String toString() {
        return "A Robot with " + chargeLevel + "% charge and says, \"" + sound + "\"";
    }

    public void addCharge(int amount) {
    /** Charge is between 0 and 100 */
        chargeLevel += amount;
        if (chargeLevel > 100) {
            chargeLevel = 100;
        }
        if (chargeLevel < 0) {
            chargeLevel = 0;
        }
    }

    public void play() {
    /** Walks in circles and makes sound, -20% charge each time until 0% */
        if (chargeLevel > 0) {
            System.out.println("Robot walks in circles and goes, \"" + getSound() + "\"");
            chargeLevel -= 20;
            System.err.println("Charge is now " + chargeLevel + "%.");
        }
        else {
            System.out.println("Robot battery is dead and cannot play.");
        }
    }

    public static void main(String[] args) {
        Robot robot1 = new Robot(100, Sound.BEEP);
        System.out.println(robot1);
        robot1.play();
        robot1.play();
        robot1.play();
        robot1.play();
        robot1.play();
        robot1.play();
    }
}
