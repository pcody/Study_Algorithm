import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.StringBuilder;

public class _220126_fibonacciFunction_boj1003 {
    static long[][] dp = new long[41][3];

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(rd.readLine());
        for (int i = 0; i <= 40; i++) {
            dp[i][2] = -1;
        }

        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(rd.readLine());

            fibonacci(N);
            sb.append(dp[N][0] + " " + dp[N][1] + "\n");
        }

        System.out.print(sb);
        rd.close();
    }

    static long[] fibonacci(int N) {
        if (dp[N][2] != -1) {
            return dp[N];
        }

        if (N == 0 || N == 1) {
            dp[N][2] = 1;
            return dp[N];
        }

        long[] temp1 = fibonacci(N - 1);
        long[] temp2 = fibonacci(N - 2);
        dp[N][0] = temp1[0] + temp2[0];
        dp[N][1] = temp1[1] + temp2[1];
        dp[N][2] = temp1[2] + temp2[2];
        return dp[N];
    }
}
