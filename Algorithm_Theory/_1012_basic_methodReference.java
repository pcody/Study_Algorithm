import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.ToIntBiFunction;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.function.Function;

class Box1014<T, U> {
    private T id;
    private U con;

    public Box1014(T i, U c) {
        id = i;
        con = c;
    }

    public void showIt() {
        System.out.println("ID: " + id + ", " + "Contents: " + con);
    }
}

class IBox1012 {
    private int n;

    public IBox1012(int i) {
        n = i;
    }

    public int larger(IBox1012 b) {
        if (n > b.n) {
            return n;
        } else {
            return b.n;
        }
    }
}

class JustSort {
    public void sort(List<?> lst) {
        Collections.reverse(lst);
    }
}

public class _1012_basic_methodReference {
    public static void main(String[] args) {

        //////////////////////////////////////////////////////////////////////////////////
        // static 메소드 참조
        List<Integer> list1 = new ArrayList<>(Arrays.asList(6, 7, 8, 10, 3, 2, 77, 81));
        System.out.println("생성" + list1);
        // Consumer<List<Integer>> c1 = l -> Collections.reverse(l);
        // Consumer<List<Integer>> c1 = l -> Collections.sort(l,
        // Comparator.reverseOrder());
        Consumer<List<Integer>> c1 = Collections::reverse;
        c1.accept(list1);
        System.out.println("변환" + list1);

        //////////////////////////////////////////////////////////////////////////////////
        // 인스턴스 메소드 참조
        JustSort js = new JustSort();
        // // js = new JustSort();
        // // 인스턴스가 final일 때만 정상 실행됨 -> 이러한 문장은 제한을 두며, 이를 방지하기위해 메소드 참조방식 사용
        List<Integer> list2 = Arrays.asList(77, 88, 99, 10, 13, 56, 21);
        // Consumer<List<Integer>> c2 = l -> js.sort(l);
        Consumer<List<Integer>> c2 = js::sort;
        System.out.println("생성" + list2);
        c2.accept(list2);
        System.out.println("변환" + list2);

        // forEach 메소드
        List<String> list3 = Arrays.asList("horse", "zibra", "monkey", "kangaroo");
        list3.forEach(e -> System.out.print(e + " "));
        System.out.println();
        list3.forEach(System.out::println);

        // 인스턴스 없이 인스턴스 메소드 참조
        IBox1012 ib1 = new IBox1012(10);
        IBox1012 ib2 = new IBox1012(7);

        // ToIntBiFunction<IBox, IBox> bf = (b1, b2) -> b1.larger(b2);
        ToIntBiFunction<IBox1012, IBox1012> bf1 = IBox1012::larger;
        System.out.println("더 큰 수는: " + bf1.applyAsInt(ib1, ib2));

        List<String> list4 = Arrays.asList("python", "C++", "C#", "Java", "Go", "SQL");
        // Collections.sort(list4, (s1, s2) -> s1.compareToIgnoreCase(s2)); // 람다 표현
        // Collections.sort(list4, new Comparator<>() { // 익명클래스 표현

        // @Override
        // public int compare(String o1, String o2) {
        // return o2.compareToIgnoreCase(o1);
        // }

        // });
        Collections.sort(list4, String::compareToIgnoreCase); // 메소드 참조 표현
        System.out.println(list4);

        //////////////////////////////////////////////////////////////////////////////////
        // 생성자 참조
        // Function<char[], String> f1 = ar -> {
        // return new String(ar);
        // };
        // Function<char[], String> f1 = ar -> new String(ar);
        Function<char[], String> f1 = String::new;
        char[] ch = { 'a', 'p', 'p', 'l', 'e' };
        System.out.println(f1.apply(ch));

        //////////////////////////////////////////////////////////////////////////////////
        // 예제
        // BiFunction<Integer, String, Box1014<Integer, String>> bf2 = new
        // BiFunction<>() {

        // @Override
        // public Box1014<Integer, String> apply(Integer t, String u) {
        // return new Box1014<>(t, u);
        // }

        // };
        // BiFunction<Integer, String, Box1014<Integer, String>> bf2 = (t, u) -> {
        // return new Box1014<>(t, u);
        // };
        BiFunction<Integer, String, Box1014<Integer, String>> bf2 = Box1014::new;
        Box1014<Integer, String> b1 = bf2.apply(1, "Mountain");
        Box1014<Integer, String> b2 = bf2.apply(2, "River");
        b1.showIt();
        b2.showIt();
    }
}