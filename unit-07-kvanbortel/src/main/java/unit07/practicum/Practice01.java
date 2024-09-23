/* Author: Kayla Van Bortel */

package unit07.practicum;

public class Practice01 {
    public static String arrayToString(int[] array) {
        String str = "[";
        for (int i = 0; i < array.length - 1; i++) {
            str = str + array[i] + ", ";
        }
        str = str + array[array.length - 1] + "]";
        return str;
    }

   public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        System.out.println(arrayToString(arr));

        Pokemon poke = new Pokemon("Pika", PokeType.GRASS, 11);
        Pokemon poke2 = new Pokemon("Pika", PokeType.GRASS, 11);
        Pokemon poke3 = new Pokemon("Pika", PokeType.FIRE, 11);
        System.out.println(poke.equals(poke2));
        System.out.println(poke.equals(poke3));
        System.out.println(poke.toString());
        poke.levelUp();
        System.out.println(poke.toString());
   }
}
