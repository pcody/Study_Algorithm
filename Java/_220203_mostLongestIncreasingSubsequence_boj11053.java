import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class _220203_mostLongestIncreasingSubsequence_boj11053 {
    static int N;
    static int[] A = new int[1001];
    static int[] dp = new int[1001];

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(rd.readLine());
        st = new StringTokenizer(rd.readLine());

        for (int i = 1; st.hasMoreTokens(); i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        solve();
        int answer = 0;
        for (int i = 1; i <= N; i++) {
            answer = Math.max(dp[i], answer);
        }
        System.out.println(answer);

        rd.close();
    }

    static void solve() {
        for (int i = 1; i <= N; i++) {
            int temp = 0;
            for (int j = 1; j <= i; j++) {
                if (A[j] < A[i]) {
                    temp = Math.max(dp[j], temp);
                }
            }
            dp[i] = temp + 1;
        }
    }
}
