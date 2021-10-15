import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

class Car implements Comparable<Car> {
    protected int disp; // 배기량

    public Car(int d) {
        disp = d;
    }

    @Override
    public String toString() {
        return "cc : " + disp;
    }

    @Override
    public int compareTo(Car o) {
        // return disp - o.disp;
        return o.disp - disp;
    }

}

class ECar extends Car {
    private int battery;

    public ECar(int d, int b) {
        super(d);
        battery = b;
    }

    @Override
    public String toString() {
        return "cc : " + disp + ", ba : " + battery;
    }
}

class Comp1008_1 implements Comparator<Car> {

    @Override
    public int compare(Car o1, Car o2) {
        return o1.disp - o2.disp;
    }

}

class StrComp1008_1 implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        return o1.compareTo(o2);
    }

}

class StrComp1008_2 implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        return o1.compareToIgnoreCase(o2);
    }

}

public class _1008_collection_sort_search_copy {
    public static void main(String[] args) {

        //////////////////////////////////////////////////////////////////////
        // String list 정렬
        List<String> list1 = new ArrayList<>(
                Arrays.asList("honey", "SamSmith", "coo", "JohnK", "KanyeWest", "Diva", "Its"));
        for (String s : list1) {
            System.out.print(s + ' ');
        }
        System.out.println();
        Collections.sort(list1);
        for (String s : list1) {
            System.out.print(s + ' ');
        }
        System.out.println();

        //////////////////////////////////////////////////////////////////////
        // 일반 객체 list 정렬 sort(Object<T>, Comparator<? super T>)
        List<Car> list2 = new ArrayList<>();
        list2.add(new Car(3000));
        list2.add(new Car(2500));
        list2.add(new Car(5000));
        list2.add(new Car(4500));
        list2.add(new Car(4000));
        for (Iterator<Car> itr = list2.iterator(); itr.hasNext();) {
            System.out.print(itr.next() + "\t");
        }
        System.out.println();
        Collections.sort(list2); // Car에서 Comparable을 구현하고 있으므로 오버라이딩된 compareTo를 사용하여 정렬됨
        for (Iterator<Car> itr = list2.iterator(); itr.hasNext();) {
            System.out.print(itr.next() + "\t");
        }
        System.out.println();

        // Car를 상속받은 ECar
        List<ECar> list3 = new ArrayList<>();
        list3.add(new ECar(1500, 100));
        list3.add(new ECar(1200, 150));
        list3.add(new ECar(1000, 200));
        list3.add(new ECar(2000, 80));
        for (Iterator<ECar> itr = list3.iterator(); itr.hasNext();) {
            System.out.print(itr.next().toString() + '\t');
        }
        System.out.println();
        Collections.sort(list3);
        for (Iterator<ECar> itr = list3.iterator(); itr.hasNext();) {
            System.out.print(itr.next().toString() + '\t');
        }
        System.out.println();

        // Car를 제네릭 인자로 갖는 Comparator Comp1008_1을 설정 후
        // Car, ECar 객체에 각각 sort 메소드 호출
        Collections.sort(list2, new Comp1008_1());
        Collections.sort(list3, new Comp1008_1());
        for (Iterator<Car> itr = list2.iterator(); itr.hasNext();) {
            System.out.print(itr.next().toString() + '\t');
        }
        System.out.println();
        for (Iterator<ECar> itr = list3.iterator(); itr.hasNext();) {
            System.out.print(itr.next().toString() + '\t');
        }
        System.out.println();

        //////////////////////////////////////////////////////////////////////
        // 탐색

        // 대소문자 구분하여 sorting 되어 있음
        int idx = Collections.binarySearch(list1, "coo");
        System.out.println(list1.get(idx));

        for (String s : list1) {
            System.out.print(s + "\t");
        }
        System.out.println();

        // StrComp1008_1은 대소문자 구분
        idx = Collections.binarySearch(list1, "coo", new StrComp1008_1());
        System.out.println(list1.get(idx));

        // StrComp1008_2는 대소문자 구분 X
        // 대소문자 구분 없이 sorting 후 Search 해야함
        Collections.sort(list1, new StrComp1008_2());
        for (String s : list1) {
            System.out.print(s + "\t");
        }
        System.out.println();
        idx = Collections.binarySearch(list1, "coo", new StrComp1008_2());
        System.out.println(list1.get(idx));

        //////////////////////////////////////////////////////////////////////
        // 복사
        List<String> dest = new ArrayList<>(list1);
        Collections.sort(dest, new StrComp1008_1());
        System.out.println("list1으로 만들고 대소문자 구분 X soritng 후 출력:\n" + dest);
        Collections.copy(dest, list1);
        System.out.println("list1으로 copy하여 출력:\n" + dest);
    }
}
