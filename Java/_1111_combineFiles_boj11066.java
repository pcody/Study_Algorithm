import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class _1111_combineFiles_boj11066 {
    static int[] volume = new int[501];
    static int[] sum = new int[501];
    static int[][] dp = new int[501][501];

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(rd.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for (int t = 0; t < T; t++) {
            int K = Integer.parseInt(rd.readLine());
            st = new StringTokenizer(rd.readLine());
            for (int i = 1; i <= K; i++) {
                volume[i] = Integer.parseInt(st.nextToken());
                sum[i] = sum[i - 1] + volume[i];
            }

            for (int j = 0; j < 501; j++) {
                for (int i = 0; i < 501; i++) {
                    dp[j][i] = -1;
                }
            }

            sb.append(solve(1, K) + "\n");
        }

        System.out.print(sb);
        rd.close();
    }

    public static int solve(int start, int end) {
        if (start == end - 1) {
            return volume[start] + volume[end];
        } else if (start == end) {
            return 0;
        }
        if (dp[start][end] == -1) {
            dp[start][end] = Integer.MAX_VALUE;
            for (int i = start; i < end; i++) {
                dp[start][end] = Math.min(dp[start][end],
                        solve(start, i) + solve(i + 1, end) + sum[end] - sum[start - 1]);
            }
        }
        return dp[start][end];
    }
}
