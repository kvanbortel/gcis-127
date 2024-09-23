package unit07.products;

import java.util.Random;

import unit07.toys.Robot;
import unit07.toys.Sound;

public class RobotFactory implements Factory {

    @Override
    public Robot manufacture() {
        /** Manufacture a robot with a random sound */
        Random random = new Random();
        String[] sounds = Sound.getValues();
        int i = random.nextInt(sounds.length);
        Robot robot = new Robot(100, sounds[i]);
        return robot;
    }
}
