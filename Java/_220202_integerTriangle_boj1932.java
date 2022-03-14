import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class _220202_integerTriangle_boj1932 {
    static int[][] nums = new int[501][501];
    static int[][] dp = new int[501][501];
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(rd.readLine());
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(rd.readLine());
            int j = 1;
            while (st.hasMoreTokens()) {
                nums[i][j++] = Integer.parseInt(st.nextToken());
            }
        }

        solve();

        int answer = 0;
        for (int j = 1; j <= n; j++) {
            answer = Math.max(answer, dp[n][j]);
        }
        System.out.println(answer);

        rd.close();
    }

    static void solve() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i][j] += (Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + nums[i][j]);
            }
        }
    }
}
