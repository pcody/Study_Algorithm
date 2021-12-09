import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.lang.StringBuilder;

public class _1112_panBalance_boj2629 {
    static int[] weight = new int[31];
    static boolean[][] dp = new boolean[31][40001];
    static int marble;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(rd.readLine());
        st = new StringTokenizer(rd.readLine());
        for (int i = 0; i < N; i++) {
            weight[i] = Integer.parseInt(st.nextToken());
        }
        solve(0, 0);

        int M = Integer.parseInt(rd.readLine());
        st = new StringTokenizer(rd.readLine());
        for (int i = 1; i <= M; i++) {
            marble = Integer.parseInt(st.nextToken());
            if (dp[N][marble]) {
                sb.append("Y ");
            } else {
                sb.append("N ");
            }
        }

        System.out.println(sb);
        rd.close();
    }

    public static void solve(int idx, int w) {
        if (idx > N || dp[idx][w]) {
            return;
        }

        dp[idx][w] = true;
        solve(idx + 1, w + weight[idx]);
        solve(idx + 1, w);
        solve(idx + 1, Math.abs(w - weight[idx]));
    }
}
// solve(0,0)
// dp[0][0] = true
// solve(1,1)
// solve(1,0)
// solve(1,1)

// solve(2,5)
// solve(2,1)
// solve(2,4)