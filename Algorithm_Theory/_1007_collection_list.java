import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class _1007_collection_list {
    public static void main(String[] args) {
        // ArrayList
        List<String> list1 = new ArrayList<>();

        list1.add("Toy");
        List<String> c = new ArrayList<>(Arrays.asList("Box", "Robot"));
        list1.addAll(c);
        list1.addAll(0, c);

        new ArrayList<>(10);
        for (int i = 0; i < list1.size(); i++) {
            System.out.print(list1.get(i) + '\t');
        }
        System.out.println();

        list1.remove(0);

        for (int i = 0; i < list1.size(); i++) {
            System.out.print(list1.get(i) + '\t');
        }
        System.out.println();

        ///////////////////////////////////////////////////////

        // LinkedList
        List<String> list2 = new LinkedList<>();
        list2.add("Toy");
        list2.add("Box");
        list2.add("Robot1");

        for (String s : list2) {
            System.out.print(s + '\t');
        }
        System.out.println();

        list2.remove(0);

        for (int i = 0; i < list2.size(); i++) {
            System.out.print(list2.get(i) + '\t');
        }
        System.out.println();

        list2.addAll(1, c);
        list2.add("Toy");
        Iterator<String> itr = list2.iterator();

        while (itr.hasNext()) {
            String str = itr.next();
            if (str.equals("Box")) {
                itr.remove();
            }
        }

        itr = list2.iterator();

        while (itr.hasNext()) {
            String str = itr.next();
            System.out.print(str + " ");
        }
        System.out.println();

        ///////////////////////////////////////////////////////

        // Iterator
        List<String> list3 = Arrays.asList("Toy", "Box", "Robot", "Box");
        list3 = new ArrayList<>(list3);

        for (Iterator<String> itr2 = list3.iterator(); itr2.hasNext();) {
            System.out.print(itr2.next() + '\t');
        }
        System.out.println();

        for (Iterator<String> itr2 = list3.iterator(); itr2.hasNext();) {
            if (itr2.next().equals("Box")) {
                itr2.remove();
            }
        }

        for (Iterator<String> itr2 = list3.iterator(); itr2.hasNext();) {
            System.out.print(itr2.next() + '\t');
        }
        System.out.println();

        // ArrayList -> LinkedList
        list3.add(0, "Toy");
        list3.add(0, "Box");
        list3.add("Box");
        for (Iterator<String> itr2 = list3.iterator(); itr2.hasNext();) {
            System.out.print(itr2.next() + '\t');
        }
        System.out.println();

        list3 = new LinkedList<>(list3);
        for (Iterator<String> itr2 = list3.iterator(); itr2.hasNext();) {
            System.out.print(itr2.next() + '\t');
        }
        System.out.println();

        ///////////////////////////////////////////////////////

        // primitive 형은 Wrapper Class로 자동 박싱, 언박싱되어 저장, 참조 할 수 있음
        LinkedList<Integer> list4 = new LinkedList<>();
        list4.add(10);
        list4.add(20);
        list4.add(30);

        for (Iterator<Integer> itr3 = list4.iterator(); itr3.hasNext();) {
            System.out.print(itr3.next() + "\t");
        }
        System.out.println();

        ///////////////////////////////////////////////////////

        // 연결리스트(LinkedList)에서는 양방향 반복자를 사용할 수 있음

        ListIterator<String> itr4 = list3.listIterator();
        while (itr4.hasNext()) {
            String str = itr4.next();
            if (str.equals("Toy")) {
                itr4.add("Toy2");
            }
        }
        while (itr4.hasPrevious()) {
            String str = itr4.previous();
            if (str.equals("Robot")) {
                itr4.add("Robot2");
            }
        }
        itr4 = list3.listIterator();
        while (itr4.hasNext()) {
            System.out.print(itr4.next() + "\t");
        }
        System.out.println();
        while (itr4.hasPrevious()) {
            System.out.print(itr4.previous() + '\t');
        }
        System.out.println();
        for (Iterator<String> itr5 = list3.iterator(); itr5.hasNext();) {
            System.out.print(itr5.next() + '\t');
        }
        System.out.println();
    }
}