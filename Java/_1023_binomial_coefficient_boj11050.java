import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class _1023_binomial_coefficient_boj11050 {
    static int[][] res;

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(rd.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        res = new int[N + 1][K + 1];

        System.out.println(bc(N, K));

        rd.close();
    }

    public static int bc(int n, int k) {
        if (n <= 1) {
            return 1;
        }
        if (n == k || k <= 0) {
            return 1;
        }

        if (res[n][k] == 0) {
            res[n][k] = bc(n - 1, k) + bc(n - 1, k - 1);
        }
        return res[n][k];
    }
}