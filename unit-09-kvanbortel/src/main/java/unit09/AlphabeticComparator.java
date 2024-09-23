package unit09;

import java.util.Comparator;

public class AlphabeticComparator implements Comparator<String> {
    
    @Override
    public int compare(String a, String b) {
        a = a.toLowerCase();
        b = b.toLowerCase();
        return a.compareTo(b);
    }
}
