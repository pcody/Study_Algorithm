import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class _1113_app_boj7579 {
    static int[] mArr = new int[101];
    static int[] cArr = new int[101];
    static int[][] dp = new int[101][10001];
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(rd.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int j = 0; j < 101; j++) {
            for (int i = 0; i < 10001; i++) {
                dp[j][i] = -1;
            }
        }

        st = new StringTokenizer(rd.readLine());
        for (int i = 1; i <= N; i++) {
            mArr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(rd.readLine());
        for (int i = 1; i <= N; i++) {
            cArr[i] = Integer.parseInt(st.nextToken());
        }

        int cost = 0;
        while (true) {
            if (solve(0, cost) >= M) {
                System.out.println(cost);
                break;
            }
            cost++;
        }

        rd.close();
    }

    public static int solve(int idx, int cost) {
        if (idx > N) {
            return 0;
        }

        if (dp[idx][cost] != -1) {
            return dp[idx][cost];
        }

        dp[idx][cost] = solve(idx + 1, cost);
        if (cArr[idx] <= cost) {
            dp[idx][cost] = Math.max(dp[idx][cost], mArr[idx] + solve(idx + 1, cost - cArr[idx]));
        }

        return dp[idx][cost];
    }
}
