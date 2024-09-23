package unit09;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class SetsAndMaps {

    public static void addAndPrint(Set<String> set) {
        set.add("aardvark");
        set.add("Zoo");
        set.add("Monkey");
        set.add("zebra");
        set.add("shark");

        for (String s: set) {
            System.out.println(s);
        }
    }

    public static void putAndPrint(Map<String, Integer> map) {
        map.put("aardvark", 1);
        map.put("Zoo", 2);
        map.put("Monkey", 3);
        map.put("zebra", 4);
        map.put("shark", 5);

        for (String key: map.keySet()) {
            System.out.println(key + ": " + map.get(key));
        }
    }

    public static void main(String[] args) {
        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new TreeSet<>();

        addAndPrint(set1);
        System.out.println();
        addAndPrint(set2);

        System.out.println();
        AlphabeticComparator ac = new AlphabeticComparator();
        Set<String> set3 = new TreeSet<>(ac);
        addAndPrint(set3);

        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new TreeMap<>();
        Map<String, Integer> map3 = new TreeMap<>(ac);

        System.out.println();
        putAndPrint(map1);
        System.out.println();
        putAndPrint(map2);
        System.out.println();
        putAndPrint(map3);
    }
}
