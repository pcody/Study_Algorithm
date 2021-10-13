import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;
import java.util.function.Consumer;
import java.util.function.DoubleUnaryOperator;
import java.util.function.Function;

class Box<T> {
    private T ob;

    public void set(T o) {
        ob = o;
    }

    public T get() {
        return ob;
    }
}

public class _1008_functionInterface_lambda {
    public static void main(String[] args) {

        ///////////////////////////////////////////////////////////////////////////
        // Predicate<T>
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        show(n -> n % 2 == 0, list1);

        List<Double> list2 = Arrays.asList(1.1, -2.3, 7.9, -4.2);
        show(d -> d > 0.0, list2);

        ///////////////////////////////////////////////////////////////////////////
        // BiPredicate<T, U>
        BiPredicate<String, Integer> conv = (t, u) -> t.length() > u ? true : false;
        if (conv.test("Robot", 3))
            System.out.println("문자열 길이 3 초과");
        else
            System.out.println("문자열 길이 3 이하");

        if (conv.test("Box", 5))
            System.out.println("문자열 길이 5 초과");
        else
            System.out.println("문자열 길이 5 이하");

        ///////////////////////////////////////////////////////////////////////////
        // Supplier<T>
        Supplier<Integer> spr = () -> {
            Random rand = new Random();
            return rand.nextInt(50);
        };

        List<Integer> list3 = makeIntList(spr, 5);
        System.out.println(list3);

        list3 = makeIntList(spr, 10);
        System.out.println(list3);

        ///////////////////////////////////////////////////////////////////////////
        // Consumer<T>
        Consumer<String> c = s -> System.out.println(s);
        c.accept("Pineapple");

        BiConsumer<Box<Integer>, Integer> bic1 = (ob, i) -> {
            ob.set(i);
        };
        Box<Integer> box1 = new Box<>();
        bic1.accept(box1, 10);
        System.out.println(box1.get());

        BiConsumer<Box<Double>, Double> bic2 = (ob, d) -> {
            ob.set(d);
        };
        Box<Double> box2 = new Box<>();
        bic2.accept(box2, 3.14);
        System.out.println(box2.get());

        ///////////////////////////////////////////////////////////////////////////
        // Function<T, R>
        Function<String, Integer> f1 = s -> s.length();
        System.out.println(f1.apply("apple pie"));

        Function<Double, Double> f2 = d -> d * d * Math.PI;
        System.out.println("반지름 4.5인 원의 넓이: " + f2.apply(4.5));

        // ToIntFunction<T>
        ToIntFunction<String> f3 = s -> s.length();
        System.out.println(f3.applyAsInt("mountain"));

        // DoubleUnaryOperatior
        DoubleUnaryOperator f4 = d -> d * d * Math.PI;
        System.out.println("반지름 5.88인 원의 넓이: " + f4.applyAsDouble(5.88));

        ///////////////////////////////////////////////////////////////////////////
        // removeIf
        List<Integer> list4 = new ArrayList<>(Arrays.asList(1, 5, 2, 3, 8, 10, 23));
        List<Double> list5 = new ArrayList<>(Arrays.asList(-1.1, -5.63, 3.82, 5.2, 4.9, 5.38, -8.55));
        Predicate<Number> p = n -> n.doubleValue() < 0.0;
        System.out.println(list4);
        System.out.println(list4.removeIf(p));
        System.out.println(list4);
        System.out.println(list5);
        System.out.println(list5.removeIf(p));
        System.out.println(list5);

    }

    public static List<Integer> makeIntList(Supplier<Integer> s, int n) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++)
            list.add(s.get());

        return list;
    }

    public static <T> void show(Predicate<T> p, List<T> list) {
        for (T i : list) {
            if (p.test(i)) {
                System.out.print(i.toString() + '\t');
            }
        }
        System.out.println();
    }
}
