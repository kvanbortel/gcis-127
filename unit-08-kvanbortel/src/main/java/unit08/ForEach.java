package unit08;

import unit08.mcf.ArrayList;
import unit08.mcf.List;

public class ForEach {
    
    public static void forArray(String[] sArray) {
        for (String element : sArray) {
            System.out.println(element);
        }
    }

    public static void forList(List<String> sList) {
        for (String element : sList) {
            System.out.println(element);
        }
    }

    public static void main(String[] args) {
        forArray(new String[] {"Hi", "Hey", "Sup?"});
        List<String> sList = new ArrayList<>();
        sList.append("1");
        sList.append("2");
        sList.append("3");
        forList(sList);
    }
}
