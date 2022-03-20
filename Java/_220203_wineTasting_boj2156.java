import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class _220203_wineTasting_boj2156 {
    static int[] wines = new int[10001];
    static int[][] dp = new int[10001][2];

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(rd.readLine());
        for (int i = 1; i <= n; i++) {
            wines[i] = Integer.parseInt(rd.readLine());
        }

        for (int i = 0; i <= 10000; i++) {
            dp[i][0] = -1;
            dp[i][1] = -1;
        }
        int answer = Math.max(solve(n, 0), solve(n, 1));

        System.out.println(answer);
        rd.close();
    }

    static int solve(int n, int eat) {
        if (n <= 0) {
            return 0;
        }

        if (dp[n][eat] != -1) {
            return dp[n][eat];
        }

        if (eat == 1) {
            dp[n][eat] = Math.max(solve(n - 2, 0) + wines[n - 1], solve(n - 2, 1)) + wines[n];
        } else {
            dp[n][eat] = Math.max(solve(n - 1, 0), solve(n - 1, 1));
        }
        return dp[n][eat];
    }
}
