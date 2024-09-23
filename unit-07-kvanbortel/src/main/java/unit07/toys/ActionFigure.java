package unit07.toys;

import java.util.Random;

public class ActionFigure extends Toy {
    private Color aFHairColor;
    private Color aFEyeColor;
    private String[] sayings;
    private boolean hasKungFuGrip;
    private int playCount;

    public ActionFigure(Color aFHairColor, Color aFEyeColor, String[] sayings, boolean hasKungFuGrip) {
        super("Action Figure", 12.99);
        this.aFHairColor = aFHairColor;
        this.aFEyeColor = aFEyeColor;
        this.hasKungFuGrip = hasKungFuGrip;
        this.sayings = sayings;
        this.playCount = 0;
    }
    
    @Override
    public String toString() {
        return "An Action Figure with " + aFHairColor + " hair, " + aFEyeColor + " eyes. Has Kung Fu Grip is " + hasKungFuGrip + ".";
    }

    public void play() {
    /** Says phrase, may brandish sword, 10 uses */
        if (playCount < 10) {
            Random random = new Random();
            int rndIndex = random.nextInt(sayings.length);
            System.out.println("The Action Figure says, \"" + sayings[rndIndex] + "\"");
            if (hasKungFuGrip) {
                System.out.println("It also brandishes a sword.");
            }
            playCount++;
            System.out.println("Action Figure has " + (10 - playCount) + " plays left.");
        }
        else {
            System.out.println("Action Figure is broken and cannot play.");
        }
    }

    public static void main(String[] args) {
        String[] action1Sayings = {ActionSayings.BEST, ActionSayings.DEFEAT, ActionSayings.GREATEST};
        ActionFigure action1 = new ActionFigure(Color.ORANGE, Color.PINK, action1Sayings, true);
        action1.play();
        action1.play();
        System.out.println(action1.getProductCode());
    }
}
