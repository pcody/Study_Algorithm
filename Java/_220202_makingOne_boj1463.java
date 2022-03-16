import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class _220202_makingOne_boj1463 {
    static int[] dp = new int[1000001];

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(rd.readLine());

        System.out.println(solve(X));

        rd.close();
    }

    static int solve(int x) {
        dp[1] = 0;
        for (int i = 2; i <= x; i++) {
            dp[i] = dp[i - 1] + 1;
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i / 3] + 1, dp[i]);
            }
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i / 2] + 1, dp[i]);
            }
        }
        return dp[x];
    }
}
