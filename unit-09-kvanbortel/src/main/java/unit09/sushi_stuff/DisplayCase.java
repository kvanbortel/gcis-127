package unit09.sushi_stuff;

import java.util.Map;
import java.util.TreeMap;

public class DisplayCase {
    private Map<Integer, Sushi> items = new TreeMap<>();
    
    public DisplayCase () {
        this.items = DisplayCase.makeCase();
    }

    public static Map<Integer, Sushi> makeCase() {
        //** Uses a map for the display case to give each sushi a number pair */
        Map<Integer, Sushi> items = new TreeMap<>();
        for (int i = 0; i < 25; i++) {
            Sushi sushi = new Sushi(i);
            items.put(sushi.getNumber(), sushi);
        }
        return items;
    }

    public Sushi remove(Integer key) {
        //** Remove sushi from display before it's bagged */
        return items.remove(key);
    }

    @Override
    public String toString() {
        return items.toString();
    }
}
