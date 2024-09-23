package unit07.toys;

public enum Color {
    // Doll hair color
    BROWN,
    BLACK,
    BLONDE,
    // Doll eye color
    GREEN,
    BLUE,
    PURPLE,
    // Action figure hair color
    RED,
    ORANGE,
    GRAY,
    // Action figure eye color
    YELLOW,
    PINK,
    AQUA;

    public static Color[] getDollHairColors() {
        return new Color[] {Color.BROWN, Color.BLACK, Color.BLONDE};
    }

    public static Color[] getDollEyeColors() {
        return new Color[] {Color.GREEN, Color.BLUE, Color.PURPLE};
    }

    public static Color[] getActionFigureHairColors() {
        return new Color[] {Color.RED, Color.ORANGE, Color.GRAY};
    }

    public static Color[] getActionFigureEyeColors() {
        return new Color[] {Color.YELLOW, Color.PINK, Color.AQUA};
    }
}
