import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;
import java.util.stream.Collectors;
import java.util.function.*;

class ReportCard1015 {
    private int kor, eng, math;

    public ReportCard1015(int k, int e, int m) {
        kor = k;
        eng = e;
        math = m;
    }

    public int getKor() {
        return kor;
    }

    public int getEng() {
        return eng;
    }

    public int getMath() {
        return math;
    }
}

public class _1015_basic_stream_2 {
    public static void main(String[] args) {

        /////////////////////////////////////////////////////////////////////
        // 생성
        // Arrays.stream(배열)
        // Stream.of(가변인자, 배열, 리스트 등) -> 배열, 리스트를 하나의 요소로 봄
        List<String> list1 = Arrays.asList("abc", "dfd", "sdf");
        Stream.of(list1).forEach(s -> System.out.println(s));
        Stream.of(new int[] { 8, 6, 5, 3, 23, 8, 12, 3, 4 }).forEach(i -> System.out.print(i + " "));
        System.out.println();
        Stream.of(new int[] { 8, 6, 5, 3, 23, 8, 12, 3, 4 }).forEach(new Consumer<>() {

            @Override
            public void accept(int[] t) {
                for (int i = 0; i < t.length; i++) {
                    System.out.print(t[i] + " ");
                }
            }

        });
        System.out.println();
        Stream.of(8, 6, 5, 3, 23, 8, 12, 3, 4).forEach(i -> System.out.print(i + " "));
        System.out.println();
        Stream.of("streamstream어려워", "한 번더").forEach(s -> System.out.print(s + " "));
        Stream.of(Arrays.asList("streamstream어려워", "한 번더")).forEach(s -> System.out.print(s + " "));
        System.out.println();

        // IntStream, DoubleStream, LongStream
        IntStream iStream1 = IntStream.of(1, 2, 3, 4, 5);
        IntStream iStream2 = IntStream.range(5, 20);
        IntStream iStream3 = IntStream.rangeClosed(5, 20);
        showIntStream(iStream1);
        showIntStream(iStream2);
        showIntStream(iStream3);

        // parallel
        Stream<String> stm1 = list1.stream().parallel();
        String str1 = stm1.reduce("", (s1, s2) -> {
            if (s1.length() > s2.length())
                return s1;
            else
                return s2;
        });
        System.out.println(str1);

        // concat
        Stream.concat(list1.stream(), Stream.of("123", "영차", "취뽀기원")).forEach(s -> System.out.print(s + " "));
        System.out.println();

        /////////////////////////////////////////////////////////////////////
        // 중간 연산
        Stream<String> stm2 = Stream.of("Blkack_Pinkjj", "Rekd_Okcekan");
        Stream<String> stm3 = stm2.flatMap(new Function<>() {

            @Override
            public Stream<? extends String> apply(String t) {
                return Arrays.stream(t.split("k"));
            }

        });
        stm3.forEach(s -> System.out.print(s + " "));
        System.out.println();

        // flatMap
        ReportCard1015[] cards = { new ReportCard1015(88, 91, 86), new ReportCard1015(100, 78, 88),
                new ReportCard1015(99, 95, 97) };

        Stream<ReportCard1015> stmRC1 = Arrays.stream(cards);
        IntStream stmInt1 = stmRC1.flatMapToInt(rc -> IntStream.of(rc.getKor(), rc.getEng(), rc.getMath()));
        double avg = stmInt1.average().getAsDouble();
        System.out.println("평균: " + avg);
        Arrays.stream(cards).flatMapToInt(r -> IntStream.of(r.getKor(), r.getEng(), r.getMath())).average()
                .ifPresent(d -> System.out.println(d));

        String[][] nameArray = new String[][] { { "kim", "eunchong" }, { "park", "sangdae" }, { "yang", "jungkee" },
                { "moon", "bora" } };
        Stream<String> stmStr1 = Arrays.stream(nameArray).flatMap(s -> Arrays.stream(s));
        System.out.println(stmStr1);
        stmStr1.forEach(s -> System.out.print(s + " "));
        System.out.println();
        List<String> temp = Arrays.stream(nameArray).flatMap(s -> Arrays.stream(s)).collect(Collectors.toList());
        System.out.println(temp);

        // sort
        Stream.of("Blkack_Pinkjj", "Rekd_Okcekan").flatMap(s -> Arrays.stream(s.split("k"))).sorted()
                .forEach(s -> System.out.print(s + " "));
        System.out.println();

        Stream.of("Blkack_Pinkjj", "Rekd_Okcekan").flatMap(s -> Arrays.stream(s.split("k")))
                .sorted((s1, s2) -> s1.length() - s2.length()).forEach(s -> System.out.print(s + " "));
        System.out.println();

        Stream.of(1, 2, 3, 4, 56, 6, 123, 3, 4, 1, 4, 56, 246, 4, 60).sorted(Comparator.reverseOrder())
                .forEach(n -> System.out.print(n + " "));
        System.out.println();

        Stream.of(1, 2, 3, 4, 56, 6, 123, 3, 4, 1, 4, 56, 246, 4, 60).sorted(Comparator.reverseOrder())
                .forEach(n -> System.out.print(n + " "));

        DoubleStream.of(1.1, 4.6546, 34.34, 45.4577, 98.9, 897.675, 7.88).sorted()
                .forEach(d -> System.out.print(d + " "));
        System.out.println();

        // loopping 스트림을 이루는 모든 데이터를 대상으로 특정 연산을 진행하는 행위를 루핑이라 함
        // 대표적으로 최종 연산인 forEach가 있고 중간 연산으로는 peek이 있음
        // 중간연산은 최종 연산이 실행되지 않으면 파이프라인에 데이터가 흐르지 않으므로 중간 연산 또한 진행되지 않음
        IntStream.of(1, 3, 5).peek(d -> System.out.print(d + " "));
        IntStream.of(1, 3, 5).peek(d -> System.out.print(d + "_")).sum();
        System.out.println();

        /////////////////////////////////////////////////////////////////////
        // 최종 연산
        // sum
        int sum1 = IntStream.of(1, 3, 5, 7, 9).sum();
        System.out.println("sum1: " + sum1);
        // count
        long cnt1 = IntStream.of(1, 3, 5, 7, 9).count();
        System.out.println("cnt1: " + cnt1);
        // average
        IntStream.of(1, 3, 5, 7, 9).average().ifPresent(d -> System.out.println("avg: " + d));
        // min
        IntStream.of(1, 3, 5, 7, 9).min().ifPresent(i -> System.out.println("min: " + i));
        // max
        IntStream.of(1, 3, 5, 7, 9).max().ifPresent(i -> System.out.println("max: " + i));

        // allMatch, anyMatch, noneMatch
        if (IntStream.of(1, 3, 5, 7, 9).allMatch(n -> n % 2 == 1)) {
            System.out.println("1, 3, 5, 7, 9 전부 홀수이다.");
        }
        if (IntStream.of(1, 3, 5, 7, 9).anyMatch(n -> n == 5)) {
            System.out.println("스트림에 5가 있다.");
        }
        if (IntStream.of(1, 3, 5, 7, 9).noneMatch(n -> n % 2 == 0)) {
            System.out.println("1, 3, 5, 7, 9 에 짝수는 없다.");
        }

        boolean b1 = Arrays.stream(cards).mapToDouble(rc -> (rc.getKor() + rc.getEng() + rc.getMath()) / 3)
                .anyMatch(d -> d >= 90.0);
        System.out.println("평균 90 이상이 한 명 이상 존재합니다. - " + b1);
        if (b1 == true) {
            boolean b2 = Arrays.stream(cards).mapToDouble(rc -> (rc.getKor() + rc.getEng() + rc.getMath()) / 3)
                    .allMatch(d -> d >= 90);
            System.out.println("모두 평균 90 이상 입니다. - " + b2);
        }

        // collect
        String[][] strArray = { { "banana", "delicious" }, { "apple", "sweety" }, { "pear", "cool" },
                { "mayonese", "salty" }, { "today", "feelgood" } };
        List<String> list2 = Arrays.stream(strArray).flatMap(arr -> Arrays.stream(arr)).filter(s -> s.length() < 5)
                .collect(ArrayList::new, (c, s) -> c.add(s), (lst1, lst2) -> lst1.addAll(lst2));
        System.out.println(list2);
        List<String> list3 = Arrays.stream(strArray).parallel().flatMap(arr -> Arrays.stream(arr))
                // .collect(Collectors.toList());
                .collect(ArrayList::new, (c, s) -> c.add(s), (lst1, lst2) -> lst1.addAll(lst2));
        System.out.println(list3);
    }

    public static void showIntStream(IntStream iStream) {
        iStream.forEach(i -> System.out.print(i + " "));
        System.out.println();
    }
}
