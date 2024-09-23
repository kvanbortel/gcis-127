package unit06;

import java.util.Arrays;

public class MugFactory {
    public static final String SWEN = "SWEN";
    public static final String LINUX = "Linux";
    public static final String GCIS = "GCIS-127";
    public static final String PC_WIZARD = "Computer wizard";
    public static final String NEW_PHRASE = "New phrase!";
    
    public static void printMug(Mug mug) {
        System.out.println("Size: " + mug.getSize());
        System.out.println("Color: " + mug.getColor());
        System.out.println("Fill Level: " + mug.getFillLevel());
        System.out.println("Phrase: " + mug.getPhrase());
        System.out.println("Material: " + mug.getMaterial());
        System.out.println("Price: " + mug.getMaterial().getPrice());
    }

    public static void main(String[] args) {
        Mug mug1 = new Mug(5, "Blue", 2, SWEN, Material.BAMBOO);
        Mug mug2 = new Mug(10, "Pink", 64, LINUX, Material.CERAMIC);
        Mug mug3 = new Mug(15, "Black", 16, GCIS, Material.STAINLESS_STEEL);
        printMug(mug1);
        printMug(mug2);
        printMug(mug3);

        System.out.println(mug1.getFillLevel());
        mug1.fill(128);
        System.out.println(mug1.getFillLevel());

        System.out.println(mug1.drain(1));
        System.out.println(mug1.getFillLevel());


        System.out.println(mug1.getPhrase());
        mug1.setPhrase(NEW_PHRASE);
        System.out.println(mug1.getPhrase());

        System.out.println(mug1);
        System.out.println(mug2);
        System.out.println(mug3);

        Mug mug4 = new Mug(10, "Yellow", 8, PC_WIZARD, Material.CERAMIC);
        System.out.println(mug2 == mug4);
        System.out.println(mug2.equals(mug4));

        System.out.println(Material.CERAMIC.toString());
        System.out.println(Material.STAINLESS_STEEL.toString());
        System.out.println(Material.GLASS.toString());
        System.out.println(Material.BAMBOO.toString());
        System.out.println(Material.PORCELAIN.toString());
        System.out.println(Material.PLASTIC.toString());
        Material glass = Material.GLASS;
        System.out.println(glass);
        Material mat = Material.valueOf("STAINLESS_STEEL");
        System.out.println(mat.name());
        System.out.println(mat);
        Material values[] = Material.values();
        System.out.println(Arrays.toString(values));

    }
}
