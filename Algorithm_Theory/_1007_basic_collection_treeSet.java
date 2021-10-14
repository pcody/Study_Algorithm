import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

class Person1007_1 implements Comparable<Person1007_1> {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person1007_1(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return name + "(" + age + "세)";
    }

    @Override
    public int compareTo(Person1007_1 o) {
        if (this.age == o.age) {
            return this.name.compareTo(o.name);
        } else {
            return this.age - o.age;
        }
    }

}

class PersonComparator1007 implements Comparator<Person1007_1> {

    @Override
    public int compare(Person1007_1 o1, Person1007_1 o2) {
        if (o1.getAge() == o2.getAge()) {
            return o1.getName().compareTo(o2.getName());
        } else {
            return o1.getAge() - o2.getAge();
        }
    }

}

class StringComparator1007 implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        return o1.length() - o2.length();
    }

}

class IntegerReverseComparator1007 implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        if (o1.equals(o2))
            return 0;
        else {
            return o2 - o1;
        }
    }

}

public class _1007_collection_treeSet {
    public static void main(String[] args) {

        ////////////////////////////////////////////////////////////////
        // 기본
        Set<Integer> tree = new TreeSet<>();
        tree.add(3);
        tree.add(1);
        tree.add(2);
        tree.add(4);
        System.out.println("인스턴스수: " + tree.size());

        for (Integer n : tree) {
            System.out.print(n + "\t");
        }
        System.out.println();

        for (Iterator<Integer> itr = tree.iterator(); itr.hasNext();) {
            System.out.print(itr.next() + "\t");
        }
        System.out.println();

        ////////////////////////////////////////////////////////////////
        // Person형
        Set<Person1007_1> treePerson = new TreeSet<>();
        treePerson.add(new Person1007_1("YOON", 28));
        treePerson.add(new Person1007_1("KIM", 40));
        treePerson.add(new Person1007_1("LEE", 34));
        treePerson.add(new Person1007_1("CHOI", 34));
        treePerson.add(new Person1007_1("KIM", 34));

        for (Person1007_1 p : treePerson) {
            System.out.print(p + "\n");
        }
        System.out.println();

        ////////////////////////////////////////////////////////////////
        // Person형 comparator 정의하여 정렬하기
        Set<Person1007_1> treePerson2 = new TreeSet<>(new PersonComparator1007());
        treePerson2.add(new Person1007_1("JANG", 15));
        treePerson2.add(new Person1007_1("YOON", 25));
        treePerson2.add(new Person1007_1("LEE", 30));
        treePerson2.add(new Person1007_1("YEOM", 25));
        treePerson2.add(new Person1007_1("YOON", 35));
        treePerson2.add(new Person1007_1("CHOI", 25));
        treePerson2.add(new Person1007_1("YOON", 35));

        for (Iterator<Person1007_1> itr = treePerson2.iterator(); itr.hasNext();) {
            System.out.print(itr.next() + "\n");
        }
        System.out.println();

        ////////////////////////////////////////////////////////////////
        // String 길이에 따른 정렬
        TreeSet<String> treeString = new TreeSet<String>(new StringComparator1007());
        treeString.add("Box");
        treeString.add("Rabbit");
        treeString.add("Robot");

        for (String s : treeString) {
            System.out.print(s + '\t');
        }
        System.out.println();

        ////////////////////////////////////////////////////////////////
        // Integer 역순 정렬
        TreeSet<Integer> tree2 = new TreeSet<>(new IntegerReverseComparator1007());
        tree2.add(10);
        tree2.add(20);
        tree2.add(40);
        tree2.add(50);
        for (Integer i : tree2) {
            System.out.print(i + "\t");
        }
        System.out.println();

        ////////////////////////////////////////////////////////////////
        // Set을 이용한 중복 인스턴스 삭제
        List<String> list = new ArrayList<>(Arrays.asList("Box", "Toy", "Box", "Toy"));

        for (String s : list)
            System.out.print(s + "\t");
        System.out.println();

        // Set<String> listSet = new TreeSet<>(list);
        Set<String> listSet = new HashSet<>(list);
        list = new ArrayList<>(listSet);

        for (String s : list)
            System.out.print(s + "\t");
        System.out.println();

    }
}
