package unit10.midtermpractice.other;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BenniBrottsGels implements Comparable<BenniBrottsGels> {
    /*Benni Brotts Many Flavor GelsTM can come in any color/flavor combination, e.g. a red-colored,
    coconut-flavored bean. The natural order of the beans is alphabetical by color. Define a class for
    BenniBrottsGels. Test it by creating several instances, putting them into a list, and sorting them. */
    private String color;
    private String flavor;
    
    public BenniBrottsGels(String color, String flavor) {
        this.color = color;
        this.flavor = flavor;
    }

    public String getColor() {
        return color;
    }

    public String getFlavor() {
        return flavor;
    }

    @Override
    public String toString() {
        return color + " " + flavor;
    }

    @Override
    public int compareTo(BenniBrottsGels b) {
        int aColor = (int)this.getColor().charAt(0);
        int bColor = (int)b.getColor().charAt(0);

        int aFlavor = (int)this.getFlavor().charAt(0);
        int bFlavor = (int)b.getFlavor().charAt(0);

        int colorComp = aColor - bColor;
        if (colorComp != 0) {
            return colorComp;
        }
        else {
            return aFlavor - bFlavor;
        }
    }

    public static void main(String[] args) {
        BenniBrottsGels red = new BenniBrottsGels("Red", "Jelly");
        BenniBrottsGels blue = new BenniBrottsGels("Blue", "Lime");
        BenniBrottsGels orange = new BenniBrottsGels("Orange", "Blueberry");
        BenniBrottsGels orange2 = new BenniBrottsGels("Orange", "Apple");
        BenniBrottsGels orange3 = new BenniBrottsGels("Orange", "Zuccini");

        List<BenniBrottsGels> beans = new ArrayList<>();
        beans.add(red);
        beans.add(blue);
        beans.add(orange);
        beans.add(orange2);
        beans.add(orange3);
        Collections.sort(beans, new BenniComparator());
        System.out.println(beans);
    }
}
