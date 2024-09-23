package unit07.toys;

public class ActionSayings {
    public static final String WIN = "I must win!";
    public static final String DEFEAT = "I must defeat the enemy!";
    public static final String BEST = "I cannot be beat!";
    public static final String GREATEST = "I am the greatest the world has ever seen!";

    public static String[] getValues() {
        return new String[] {ActionSayings.WIN, ActionSayings.DEFEAT, ActionSayings.BEST, ActionSayings.GREATEST};
    }

    public ActionSayings() {}
}
