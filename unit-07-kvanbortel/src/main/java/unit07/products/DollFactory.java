package unit07.products;

import java.util.Random;

import unit07.toys.Color;
import unit07.toys.Doll;
import unit07.toys.DollSayings;

public class DollFactory implements Factory {

    @Override
    public Doll manufacture() {
        /** Manufacture a doll with a random hair and eye color */
        Random random = new Random();
        Color[] hairColors = Color.getDollHairColors();
        Color[] eyeColors = Color.getDollEyeColors();
        int i = random.nextInt(hairColors.length);
        int j = random.nextInt(hairColors.length);
        Doll doll = new Doll(hairColors[i], eyeColors[j], new String[] {DollSayings.HAPPY, DollSayings.HOW_YOU});
        return doll;
    }
}
