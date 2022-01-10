import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class _1123_app_boj7579 {
    static int[] memory = new int[101];
    static int[] costs = new int[101];
    static int[][] dp = new int[101][10001];
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(rd.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(rd.readLine());
        for (int i = 1; i <= N; i++) {
            memory[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(rd.readLine());
        for (int i = 1; i <= N; i++) {
            costs[i] = Integer.parseInt(st.nextToken());
        }

        for (int j = 1; j <= N; j++) {
            for (int i = 0; i <= 10000; i++) {
                dp[j][i] = dp[j - 1][i];
                if (i >= costs[j]) {
                    dp[j][i] = Math.max(dp[j][i], memory[j] + dp[j - 1][i - costs[j]]);
                }
            }
        }

        for (int i = 0; i <= 10000; i++) {
            if (dp[N][i] >= M) {
                System.out.println(i);
                break;
            }
        }

        // for (int j = 0; j < 101; j++) {
        // for (int i = 0; i < 10001; i++) {
        // dp[j][i] = -1;
        // }
        // }
        // int cost = 0;
        // while (true) {
        // if (solve(1, cost) >= M) {
        // System.out.print(cost);
        // break;
        // }
        // cost++;
        // }

        rd.close();
    }

    // public static int solve(int idx, int cost) {
    // if (idx > N) {
    // return 0;
    // }

    // if (dp[idx][cost] != -1) {
    // return dp[idx][cost];
    // }

    // dp[idx][cost] = solve(idx + 1, cost);
    // if (costs[idx] <= cost) {
    // dp[idx][cost] = Math.max(dp[idx][cost], memory[idx] + solve(idx + 1, cost -
    // costs[idx]));
    // }
    // return dp[idx][cost];
    // }
}

// idx 앱번호
// 정답: A1~An 비활성화 할때
// M바이트 이상 확보하면서 비용최소
// 메모리는 <= 10000000
// 비용 <= 100
// 비활성화 전부 하면 앱수*최대비용 = 100*100
// dp[101][10001] = 확보한 메모리
