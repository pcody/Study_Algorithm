import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class _220126_01Tile_boj1904 {
    static int divisor = 15746;
    static int[] dp = new int[1000001];

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(rd.readLine());
        Arrays.fill(dp, -1);

        System.out.println(solve(N) % divisor);

        rd.close();
    }

    public static int solve(int N) {
        if (N <= 0) {
            return 0;
        }
        if (N == 1) {
            dp[N] = 1;
            return dp[N];
        }
        if (N == 2) {
            dp[N] = 2;
            return dp[N];
        }

        if (dp[N] != -1) {
            return dp[N] % divisor;
        }

        dp[N] = solve(N - 1) % divisor + solve(N - 2) % divisor;
        return dp[N] % divisor;
    }
}
