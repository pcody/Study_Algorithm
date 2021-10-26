import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

public class _1022_inspection_boj2981 {
    static String res = "";

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(rd.readLine());
        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            arr.add(Integer.parseInt(rd.readLine()));
        }
        arr.sort(Comparator.naturalOrder());

        int g = arr.get(1) - arr.get(0);
        for (int i = 2; i < arr.size(); i++) {
            g = gcd(g, arr.get(i) - arr.get(i - 1));
        }

        findAliquot(g);
        System.out.println(res);
        rd.close();
    }

    public static void findAliquot(int a) {
        for (int i = 2; i <= a; i++) {
            if (a % i == 0) {
                res = res + i + " ";
            }
        }
    }

    public static int gcd(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}