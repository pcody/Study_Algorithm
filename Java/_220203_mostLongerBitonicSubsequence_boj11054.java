import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class _220203_mostLongerBitonicSubsequence_boj11054 {
    static int N;
    static int[][] dp = new int[1001][2];
    static int[] A = new int[1001];

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(rd.readLine());
        st = new StringTokenizer(rd.readLine());

        for (int i = 1; st.hasMoreTokens(); i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        // 0: forward, 1: reverse
        System.out.println(solve() - 1);

        rd.close();
    }

    static int solve() {
        for (int i = 1; i <= N; i++) {
            int temp = 0;
            for (int j = 1; j <= i; j++) {
                if (A[j] < A[i]) {
                    temp = Math.max(dp[j][0], temp);
                }
            }
            dp[i][0] = temp + 1;
        }

        for (int i = N; i >= 1; i--) {
            int temp = 0;
            for (int j = N; j >= i; j--) {
                if (A[j] < A[i]) {
                    temp = Math.max(dp[j][1], temp);
                }
            }
            dp[i][1] = temp + 1;
        }

        int answer = 0;
        for (int i = 1; i <= N; i++) {
            answer = Math.max(dp[i][0] + dp[i][1], answer);
        }
        return answer;
    }
}
