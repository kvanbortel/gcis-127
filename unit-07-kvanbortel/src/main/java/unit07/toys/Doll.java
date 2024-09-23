package unit07.toys;

import java.util.Random;

public class Doll extends Toy {
    private Color dollHairColor;
    private Color dollEyeColor;
    private String[] sayings;
    public int playCount;

    public Doll(Color dollHairColor, Color dollEyeColor, String[] sayings) {
        super("Doll", 15.99);
        this.dollHairColor = dollHairColor;
        this.dollEyeColor = dollEyeColor;
        this.sayings = sayings;
        this.playCount = 0;
    }

    @Override
    public String toString() {
        return "A Doll with " + dollHairColor + " hair, " + dollEyeColor + " eyes.";
    }

    public void play() {
    /** Says phrase, 10 uses */
        if (playCount < 10) {
            Random random = new Random();
            int rndIndex = random.nextInt(sayings.length);
            System.out.println("You pull a string and the Doll says, \"" + sayings[rndIndex] + "\"");
            playCount++;
            System.out.println("Doll has " + (10 - playCount) + " plays left.");
        }
        else {
            System.out.println("Doll is broken and cannot play.");
        }
    }

    public static void main(String[] args) {
        String[] doll1Sayings = {DollSayings.HAPPY, DollSayings.HOW_YOU, DollSayings.MORNING};
        Doll doll1 = new Doll(Color.BLONDE, Color.BLUE, doll1Sayings);
        doll1.play();
        doll1.play();
        doll1.play();
        String[] doll2Sayings = {DollSayings.PLAY, DollSayings.HOW_YOU, DollSayings.SLEEPY};
        Doll doll2 = new Doll(Color.BLONDE, Color.BLUE, doll2Sayings);
        doll2.play();
        System.err.println(doll1.getProductCode());
        System.err.println(doll2.getProductCode());
    }
}
