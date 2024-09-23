package unit07.products;

import java.util.Random;

import unit07.toys.ActionFigure;
import unit07.toys.ActionSayings;
import unit07.toys.Color;

public class ActionFigureFactory implements Factory {

    @Override
    public ActionFigure manufacture() {
        /** Manufacture an action figure with a random hair and eye color and Kung Fu Grip boolean */
        Random random = new Random();
        Color[] hairColors = Color.getActionFigureHairColors();
        Color[] eyeColors = Color.getActionFigureEyeColors();
        int i = random.nextInt(hairColors.length);
        int j = random.nextInt(hairColors.length);
        ActionFigure actionFigure = new ActionFigure(
            hairColors[i], eyeColors[j], new String[] {ActionSayings.BEST, ActionSayings.DEFEAT}, random.nextBoolean()
        );
        return actionFigure;
    }
    
}
