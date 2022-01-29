import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

// DP로는 실패! DP설계도 못하겠음 ㅜㅜ
public class _1130_napsack_boj1450 {
    static int N, C;
    static long[] arr;
    static long[] dp;
    // 인덱스, 무게, 가짓수
    // 인덱스까지 사용할시 가능한 가짓수 저장

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(rd.readLine());

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new long[31];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(rd.readLine());
            arr[i] = Long.parseLong(st.nextToken());
        }

        dp = new long[31];
        Arrays.fill(dp, -1);

        solve(0, 0);

        rd.close();
    }

    public static long solve(int idx, long w) {
        if (idx > N) {
            return 0;
        }

        if (dp[idx] != -1) {
            return dp[idx];
        }

        dp[idx] = solve(idx + 1, w);
        if (w + arr[idx] <= C) {
            dp[idx] = solve(idx + 1, w + arr[idx]);
        }

        return dp[idx];
    }
}
