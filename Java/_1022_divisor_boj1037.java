import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

public class _1022_divisor_boj1037 {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(rd.readLine());
        int n = Integer.parseInt(st.nextToken());
        List<Integer> arr = new ArrayList<>();

        st = new StringTokenizer(rd.readLine());
        for (int i = 0; i < n; i++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }
        arr.sort(Comparator.naturalOrder());

        System.out.println(arr.get(0) * arr.get(arr.size() - 1));
        rd.close();
    }
}