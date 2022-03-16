import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class _220202_stepUp_boj2579 {
    static int[][] dp = new int[301][2];
    static int[] scores = new int[301];
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(rd.readLine());

        for (int i = 1; i <= N; i++) {
            scores[i] = Integer.parseInt(rd.readLine());
        }

        for (int i = 0; i <= N; i++) {
            for (int j = 0; j < 2; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.print(solve(N, 1));

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
            dp[n][eat] = Math.max(solve(n - 2, 1), solve(n - 2, 0) + scores[n - 1]) + scores[n];
        } else {
            dp[n][eat] = solve(n - 1, 1);
        }

        return dp[n][eat];
    }
}
