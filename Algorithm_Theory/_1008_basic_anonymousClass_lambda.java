import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

interface Drawable {
    void draw();
}

class Picture {
    private String name;

    public Picture(String name) {
        this.name = name;
    }

    public Drawable getDrawer() {
        return new Drawable() {
            public void draw() {
                System.out.println(name + "을(를) 그립니다.");
            }
        };
    }

}

interface Printable1008 {
    void print(String s);
}

interface Calculate1008 {
    void cal(int a, int b);
}

interface Calculate1008_2 {
    int cal(int a, int b);
}

interface Generator1008 {
    int rand();
}

interface Calculate1008_3<T> {
    T cal(T a, T b);
}

public class _1008_anonymousClass_lambda {
    public static void main(String[] args) {

        ///////////////////////////////////////////////////////////
        // 익명클래스
        Picture pic = new Picture("모나리자");
        Drawable brush = pic.getDrawer();
        brush.draw();

        ///////////////////////////////////////////////////////////
        // 람다 이전 코드 스타일
        List<String> list = new ArrayList<>();
        list.add("김밥");
        list.add("밥버거");
        list.add("햄버거");
        list.add("양송이스프");
        System.out.println(list);
        // cmp = (String o1, String o2) -> o1.compareTo(o2);
        Comparator<String> cmp = new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        };

        Collections.sort(list, cmp);
        System.out.println(list);

        ///////////////////////////////////////////////////////////
        // 람다 적용 코드 스타일
        list.add("감자탕");
        list.add(0, "챱스테이크");
        list.add(0, "폭립스테이크");
        Collections.sort(list, (String o1, String o2) -> {
            return o1.compareTo(o2);
        });
        System.out.print(list);

        ///////////////////////////////////////////////////////////
        // 람다 표현방식
        // 매개변수 1개, 반환 X
        Printable1008 p;
        p = (String s) -> {
            System.out.println(s);
        };
        p.print("줄임 없는 표현");
        p = (String s) -> System.out.println(s);
        p.print("중괄호 생략");
        p = (s) -> System.out.println(s);
        p.print("매개변수 형 생략");
        p = s -> System.out.println(s);
        p.print("매개변수 소괄호 생략");

        // 매개변수 2개, 반환 X
        Calculate1008 c;
        c = (a, b) -> System.out.println(a + b);
        c.cal(4, 5);
        c = (a, b) -> System.out.println(a * b);
        c.cal(4, 5);

        // 매개변수 2개, 반환 O
        Calculate1008_2 c2;
        c2 = (a, b) -> {
            return a + b;
        };
        System.out.println(c2.cal(153, 3));
        c2 = (a, b) -> a / b; // return 문 삭제 가능
        System.out.println(c2.cal(153, 3));

        // 매개변수 X
        Generator1008 gen = () -> {
            Random rand = new Random();
            return rand.nextInt(20);
        };
        for (int i = 0; i < 10; i++)
            System.out.println(i + " : " + gen.rand());

        // 제네릭
        Calculate1008_3<Integer> c3 = (a, b) -> a + b;
        System.out.println(c3.cal(10, 5));
        Calculate1008_3<Double> c4 = (a, b) -> a / b;
        System.out.println(c4.cal(10.77, 3.455));

        // 제네릭 + 함수 인자로 람다식 넘기기
        calAndShow((Integer i1, Integer i2) -> i1 + i2, 10, 2);

        // String Sort
        // Collections.sort(list, Comparator.reverseOrder());
        Collections.sort(list, (s1, s2) -> {
            return s1.compareTo(s2);
        });
        System.out.println(list);
    }

    public static <T> void calAndShow(Calculate1008_3<T> op, T n1, T n2) {
        T r = op.cal(n1, n2);
        System.out.println("r: " + r);
    }
}
