package unit10.midtermpractice.other;

import java.util.Comparator;

public class BenniComparator implements Comparator<BenniBrottsGels> {
    
    @Override
    public int compare(BenniBrottsGels a, BenniBrottsGels b) {
        // if (a.compareTo(b) > 0)
        //     return 1;
        // else if (a.compareTo(b) < 0)
        //     return -1;
        // else
        //     return 0;
        
        Integer aColor = (int)a.getColor().charAt(0);
        Integer bColor = (int)b.getColor().charAt(0);

        Integer aFlavor = (int)a.getFlavor().charAt(0);
        Integer bFlavor = (int)b.getFlavor().charAt(0);

        Integer colorComp = aColor.compareTo(bColor);
        if (colorComp != 0) {
            return colorComp;
        }

        return aFlavor.compareTo(bFlavor);
    }    
}
