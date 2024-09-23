package unit06;

import java.util.Arrays;

public class Objects {
    public static Object[] funWithObjects(Object object) {
        Object[] objects = new Object[5];

        objects[0] = object.toString();
        objects[1] = "hello";
        objects[2] = 3; // autoboxing
        objects[3] = new Mug(48, "Blue", 12, "Friday the 13th", Material.BAMBOO);
        objects[4] = Class.class;

        return objects;
    }

    public static void main(String[] args) {
        Object[] objects = funWithObjects(new int[5]);
        Object[] objects2 = funWithObjects(new Mug(12, "Yello", 2, "Hi", Material.STAINLESS_STEEL));
        Object[] objects3 = funWithObjects("Hi");
        System.out.println(Arrays.toString(objects));
        System.out.println(Arrays.toString(objects2));
        System.out.println(Arrays.toString(objects3));

        System.out.println(objects[2].getClass());

        String s = "123";
        int x = Integer.valueOf(s); // x = int(s)
        System.out.println(x + 3);

        Integer i = Integer.valueOf(123); // boxing
        System.out.println(i.getClass());

        int z = i.intValue(); // unboxing
        System.out.println(z);
    }
}
