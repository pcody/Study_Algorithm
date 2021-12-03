import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class _1109_combineFiles_boj11066 {
    static int[][] dp = new int[501][501];
    static int[] sum = new int[501];
    static int[] cost = new int[501];

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(rd.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for (int t = 0; t < T; t++) {
            int K = Integer.parseInt(rd.readLine());
            st = new StringTokenizer(rd.readLine());
            for (int i = 1; i <= K; i++) {
                cost[i] = Integer.parseInt(st.nextToken());
                sum[i] = sum[i - 1] + cost[i];
            }

            for (int d = 1; d < K; ++d) {
                for (int tx = 1; tx + d <= K; ++tx) {
                    int ty = tx + d;
                    dp[tx][ty] = Integer.MAX_VALUE;

                    for (int mid = tx; mid < ty; ++mid)
                        dp[tx][ty] = Math.min(dp[tx][ty], dp[tx][mid] + dp[mid + 1][ty] + sum[ty] - sum[tx - 1]);
                }
            }

            sb.append(dp[1][K] + "\n");
        }

        System.out.print(sb);
        rd.close();
    }
}
