import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

class Comp1008 implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        return o2 - o1;
    }
}

public class _1008_collection_map {
    public static void main(String[] args) {

        /////////////////////////////////////////////////////////////
        // HashMap
        Map<Integer, String> map = new HashMap<>();
        map.put(45, "Brown");
        map.put(37, "James");
        map.put(23, "Martin");

        System.out.println(map.get(23));
        System.out.println(map.get(37));
        System.out.println(map.get(45));
        System.out.println();

        map.remove(45);
        System.out.println("45 : Brown = " + map.get(45));
        System.out.println();

        map.put(33, "Tom");
        map.put(55, "Maxwell");
        map.put(27, "Harry");

        Set<Integer> ks = map.keySet();
        for (Integer n : ks) {
            System.out.print(n + "\t");
        }
        System.out.println();

        for (Iterator<Integer> itr = ks.iterator(); itr.hasNext();) {
            System.out.print(map.get(itr.next()) + '\t');
        }
        System.out.println();

        /////////////////////////////////////////////////////////////
        // TreeMap
        Map<Integer, String> map2 = new TreeMap<>();
        map2.put(45, "Brown");
        map2.put(37, "James");
        map2.put(23, "Martin");
        map2.put(33, "Tom");
        map2.put(55, "Maxwell");
        map2.put(27, "Harry");

        for (Integer n : map2.keySet()) {
            System.out.println(n + " : " + map2.get(n));
        }
        System.out.println();

        // key 역순 정렬
        Map<Integer, String> map3 = new TreeMap<>(new Comp1008());
        map3.put(45, "Brown");
        map3.put(37, "James");
        map3.put(23, "Martin");
        map3.put(33, "Tom");
        map3.put(55, "Maxwell");
        map3.put(27, "Harry");

        for (Integer n : map3.keySet()) {
            System.out.println(n + " : " + map3.get(n));
        }
        System.out.println();
    }
}
