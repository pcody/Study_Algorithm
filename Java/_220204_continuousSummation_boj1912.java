import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class _220204_continuousSummation_boj1912 {
    static int[] dp = new int[100001];
    static int[] arr = new int[100001];
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(rd.readLine());
        st = new StringTokenizer(rd.readLine());

        for (int i = 1; st.hasMoreTokens(); i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solve());
        rd.close();
    }

    static int solve() {
        int answer = -100000000;

        for (int i = 1; i <= n; i++) {
            dp[i] = Math.max(arr[i], dp[i - 1] + arr[i]);
            answer = Math.max(dp[i], answer);
        }

        return answer;
    }
}
