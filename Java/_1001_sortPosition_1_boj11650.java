import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class _1001_sortPosition_1_boj11650 {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(rd.readLine());
        List<List<Integer>> arr = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String[] str = rd.readLine().split(" ");
            int[] temp = { Integer.parseInt(str[0]), Integer.parseInt(str[1]) };
            arr.add(Arrays.stream(temp).boxed().collect(Collectors.toList()));
        }

        // Comparator1 comp1 = new Comparator1();
        // Comparator2 comp2 = new Comparator2();
        // arr.sort(comp1.thenComparing(comp2));
        arr.sort(new Comparator11650_1().thenComparing(new Comparator11650_2()));

        for (List<Integer> answer : arr) {
            System.out.println(answer.get(0) + " " + answer.get(1));
        }
        rd.close();
    }
}

class Comparator11650_1 implements Comparator<List<Integer>> {

    @Override
    public int compare(List<Integer> o1, List<Integer> o2) {
        if (o1.get(0).equals(o2.get(0)))
            return 0;
        else
            return o1.get(0) > o2.get(0) ? 1 : -1;
    }

}

class Comparator11650_2 implements Comparator<List<Integer>> {

    @Override
    public int compare(List<Integer> o1, List<Integer> o2) {
        if (o1.get(1).equals(o2.get(1)))
            return 0;
        else
            return o1.get(1) > o2.get(1) ? 1 : -1;
    }

}