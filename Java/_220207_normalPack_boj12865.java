import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class _220207_normalPack_boj12865 {
    static int N, K;
    static int[] weights = new int[101];
    static int[] values = new int[101];
    static int[][] dp = new int[101][100001];

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(rd.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(rd.readLine());
            weights[i] = Integer.parseInt(st.nextToken());
            values[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solve());
        rd.close();
    }

    static int solve() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= K; j++) {
                if (weights[i] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weights[i]] + values[i]);
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[N][K];
    }

    // static int solve(int n, int w) {
    // if (n > N) {
    // return 0;
    // }

    // if (dp[n] != -1) {
    // return dp[n];
    // }

    // dp[n] = solve(n + 1, w);
    // if (w + weights[n] <= K) {
    // dp[n] = Math.max(solve(n + 1, w + weights[n]) + values[n], dp[n]);
    // }

    // return dp[n];
    // }
}
