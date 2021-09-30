import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class _0930_sortingNumber_1_boj2750 {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(rd.readLine());

        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            arr.add(Integer.parseInt(rd.readLine()));
        }
        arr.sort(Comparator.naturalOrder());
        for (int i = 0; i < arr.size(); i++) {
            System.out.println(arr.get(i));
        }
        rd.close();
    }
}