import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class _220126_padabanSequence_boj9461 {
    static long[] dp = new long[101];

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(rd.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= 100; i++) {
            dp[i] = -1;
        }

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(rd.readLine());
            sb.append(P(N) + "\n");
        }

        System.out.print(sb);
        rd.close();
    }

    public static long P(int N) {
        if (N == 1) {
            dp[N] = 1;
            return dp[N];
        }
        if (N == 2) {
            dp[N] = 1;
            return dp[N];
        }
        if (N == 3) {
            dp[N] = 1;
            return dp[N];
        }

        if (dp[N] != -1) {
            return dp[N];
        }

        dp[N] = P(N - 2) + P(N - 3);
        return dp[N];
    }

}
