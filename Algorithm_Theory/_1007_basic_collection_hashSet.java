import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

class Num1007 {
    private int num;

    public Num1007(int n) {
        num = n;
    }

    @Override
    public String toString() {
        return String.valueOf(num);
    }
}

class Num1007_1 {
    private int num;

    public Num1007_1(int n) {
        num = n;
    }

    @Override
    public String toString() {
        return String.valueOf(num);
    }

    @Override
    public int hashCode() {
        return num % 3;
    }

    @Override
    public boolean equals(Object obj) {
        if (num == ((Num1007_1) obj).num) {
            return true;
        } else {
            return false;
        }
    }

}

class Car1007 {
    private String model;
    private String color;

    public Car1007(String m, String c) {
        model = m;
        color = c;
    }

    @Override
    public boolean equals(Object obj) {
        if (model.equals(((Car1007) obj).model) && color.equals(((Car1007) obj).color)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return (model.hashCode() + color.hashCode()) / 2;
    }

    @Override
    public String toString() {
        return model + " : " + color;
    }

}

class Person1007 {
    private String name;
    private int age;

    public Person1007(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        if (name.equals(((Person1007) obj).name) && age == ((Person1007) obj).age)
            return true;
        else
            return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return name + "(" + age + "세)";
    }

}

public class _1007_collection_hashSet {
    public static void main(String[] args) {

        ///////////////////////////////////////////////////////////////////////
        // String Set
        Set<String> set = new HashSet<>();
        set.add("Toy");
        set.add("Box");
        set.add("Robot");
        set.add("Box");
        System.out.println("인스턴스수: " + set.size());

        for (Iterator<String> itr = set.iterator(); itr.hasNext();) {
            System.out.print(itr.next() + '\t');
        }
        System.out.println();

        for (String s : set) {
            System.out.print(s + "\t");
        }
        System.out.println();

        ///////////////////////////////////////////////////////////////////////
        // Num1007 Set
        Set<Num1007> setNum = new HashSet<>();
        setNum.add(new Num1007(1234));
        setNum.add(new Num1007(4567));
        setNum.add(new Num1007(1234));
        // set에서는 hashCode를 기준으로 같은 인스턴스인지 판단하므로
        // hashCode, equals를 오버라이딩 하여 같은 그룹인지, 멤버변수의 값이 같은지를 기준으로
        // 인스턴스를 판별함
        System.out.println("인스턴스수: " + setNum.size());

        for (Iterator<Num1007> itr = setNum.iterator(); itr.hasNext();) {
            System.out.print(itr.next() + "\t");
        }
        System.out.println();

        ///////////////////////////////////////////////////////////////////////
        // Num1007_1 Set
        Set<Num1007_1> setNum2 = new HashSet<>();
        setNum2.add(new Num1007_1(1234));
        setNum2.add(new Num1007_1(4567));
        setNum2.add(new Num1007_1(1234));
        System.out.println("인스턴스수: " + setNum2.size());

        for (Num1007_1 n : setNum2) {
            System.out.print(n.toString() + '\t');
        }
        System.out.println();

        ///////////////////////////////////////////////////////////////////////
        // Car1007 Set
        Set<Car1007> setCar = new HashSet<>();
        setCar.add(new Car1007("BMW", "RED"));
        setCar.add(new Car1007("HYUNDAI", "BLACK"));
        setCar.add(new Car1007("BMW", "RED"));
        setCar.add(new Car1007("MERCEDES", "BLACK"));
        setCar.add(new Car1007("AUDI", "WHITE"));
        System.out.println("인스턴스수: " + setCar.size());

        for (Car1007 c : setCar) {
            System.out.print(c.toString() + '\n');
        }

        ///////////////////////////////////////////////////////////////////////
        // Person1007 Set
        Set<Person1007> setPerson = new HashSet<>();
        setPerson.add(new Person1007("김계란", 40));
        setPerson.add(new Person1007("정지훈", 43));
        setPerson.add(new Person1007("김태희", 41));
        setPerson.add(new Person1007("김계란", 35));
        setPerson.add(new Person1007("김계란", 40));
        System.out.println("인스턴스수: " + setPerson.size());

        for (Person1007 p : setPerson) {
            System.out.println(p.toString());
        }
    }
}
