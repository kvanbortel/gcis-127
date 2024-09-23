package unit07.toys;

public class Sound {
    public static final String BEEP = "Beep boop!";
    public static final String CLANK = "Clank!";
    public static final String BUZZ = "Buzz!";
    public static final String WHIRR = "Whirr!";

    public static String[] getValues() {
        return new String[] {Sound.BEEP, Sound.CLANK, Sound.BUZZ, Sound.WHIRR};
    }

    public Sound() {}
}
