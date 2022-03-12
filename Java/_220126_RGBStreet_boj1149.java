import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class _220126_RGBStreet_boj1149 {
    static int[][] dp = new int[1001][3];
    static int[][] costs = new int[1001][3];

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 1; i <= 1000; i++) {
            for (int j = 0; j < 3; j++) {
                dp[i][j] = -1;
            }
        }
        int N = Integer.parseInt(rd.readLine());
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(rd.readLine());
            costs[i][0] = Integer.parseInt(st.nextToken());
            costs[i][1] = Integer.parseInt(st.nextToken());
            costs[i][2] = Integer.parseInt(st.nextToken());
        }

        System.out.print(Math.min(solve(N, 0), Math.min(solve(N, 1), solve(N, 2))));
        rd.close();
    }

    public static int solve(int N, int idx) {
        if (N == 1) {
            dp[N][0] = costs[N][0];
            dp[N][1] = costs[N][1];
            dp[N][2] = costs[N][2];
            return dp[N][idx];
        }

        if (dp[N][idx] != -1) {
            return dp[N][idx];
        }

        dp[N][idx] = Math.min(solve(N - 1, (idx + 1) % 3) + costs[N][idx],
                solve(N - 1, (idx + 2) % 3) + costs[N][idx]);

        return dp[N][idx];
    }
}
