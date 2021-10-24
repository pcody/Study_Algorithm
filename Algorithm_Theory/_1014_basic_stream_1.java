import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.ArrayList;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Box1015<T> {
    private T ob;

    public Box1015(T o) {
        ob = o;
    }

    public T get() {
        return ob;
    }
}

class ToyInfo1015 {
    private String model;
    private int price;

    public ToyInfo1015(String m, int p) {
        model = m;
        price = p;
    }

    public int getPrice() {
        return price;
    }

    public String getModel() {
        return model;
    }
}

public class _1014_basic_stream_1 {
    public static void main(String[] args) {

        /////////////////////////////////////////////////////////////////////
        // 생성, 출력(forEach)
        // int
        // int[] arr1 = new int[] { 1, 6, 9, 10, 24, 58 };
        int[] arr1 = { 1, 6, 9, 10, 24, 58 };
        IntStream stm1 = Arrays.stream(arr1);
        IntStream stm2 = stm1.filter(i -> i % 2 == 1);
        int sum1 = stm2.sum();
        System.out.println(sum1);
        Arrays.stream(arr1).boxed();
        int sum2 = Arrays.stream(arr1).filter(i -> i % 2 == 0).sum();
        System.out.println(sum2);
        System.out.println(Arrays.stream(arr1).sum());

        // String
        String[] arr2 = { "alpha", "comma", "zoo", "pig", "monkey", "black", "snow", "pie" };
        Stream<String> stm3 = Arrays.stream(arr2);
        stm3.forEach(s -> System.out.print(s + " "));
        System.out.println();
        Arrays.stream(arr2).forEach(System.out::println);

        // double
        double[] arr3 = { 1.1, 2.2, 3.3, 4.4, 5.5 };
        Arrays.stream(arr3, 2, 5).forEach(d -> System.out.print(d + " "));
        System.out.println();

        // Collection
        List<String> list1 = Arrays.asList("ttt", "fggg", "qwee", "ppfkb");
        // Arrays.stream(list1); // 불가능
        list1.stream().forEach(s -> System.out.print(s + " "));
        System.out.println();

        /////////////////////////////////////////////////////////////////////
        // 중간 연산 filtering, mapping
        Arrays.stream(arr1).filter(n -> n % 2 == 0).forEach(n -> System.out.print(n + " "));
        System.out.println();
        Arrays.stream(arr2).filter(s -> s.length() > 3).forEach(s -> System.out.print(s + " "));
        System.out.println();
        Arrays.stream(arr2).map(i -> i.length()).forEach(i -> System.out.print(i + " "));
        System.out.println();

        List<Box1015<String>> list2 = Arrays.asList(new Box1015<>("Japan"), new Box1015<>("Malaysia"),
                new Box1015<>("SouthAfrica"), new Box1015<>("Russia"), new Box1015<>("Sweden"));
        list2.stream().map(b -> b.get()).forEach(s -> System.out.print(s + " "));
        System.out.println();
        list2.stream().mapToInt(b -> b.get().length()).forEach(i -> System.out.print(i + " "));
        System.out.println();

        List<ToyInfo1015> list3 = new ArrayList<>();
        list3.add(new ToyInfo1015("PrincessDoll", 300));
        list3.add(new ToyInfo1015("ChessBoard", 200));
        list3.add(new ToyInfo1015("Go", 500));
        list3.add(new ToyInfo1015("WaterGun", 350));
        int sum = list3.stream().filter(t -> t.getPrice() < 500).mapToInt(t -> t.getPrice()).sum();
        System.out.println("500 미만의 장난감 가격 총합: " + sum);
        list3.stream().filter(t -> t.getModel().length() > 10).map(t -> t.getModel())
                .forEach(s -> System.out.print(s + " "));
        System.out.println();

        /////////////////////////////////////////////////////////////////////
        // reduction, parallel stream
        List<String> list4 = Arrays.asList(arr2);

        BinaryOperator<String> bo = (s1, s2) -> {
            if (s1.length() > s2.length()) {
                return s1;
            } else {
                return s2;
            }
        };

        // reduction, reduce 의 첫 번째 인자까지 비교 대상이므로 Empty Stream 이 출력됨
        String str = list4.stream().reduce("Empty Stream", bo);
        System.out.println(str);

        // reduction + parallel stream, CPU 의 코어 수를 고려하여 적절하게 병렬로 처리하여 연산의 단계를 줄인다
        str = list4.parallelStream().reduce("", bo);
        System.out.println(str);
    }

}
