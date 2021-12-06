import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class _1111_normalPack_boj12865 {
    static int[] weight = new int[101];
    static int[] value = new int[101];
    static int[][] dp = new int[101][100001];
    static int N, K;

    // dp[num][w] : num번째 물건을 담았을 때 K만큼 담을 때 가치의 최댓값
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(rd.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(rd.readLine());
            weight[i] = Integer.parseInt(st.nextToken());
            value[i] = Integer.parseInt(st.nextToken());
        }

        for (int j = 0; j < 101; j++) {
            for (int i = 0; i < 100001; i++) {
                dp[j][i] = -1;
            }
        }

        System.out.println(solve(1, 0));

        rd.close();
    }

    public static int solve(int num, int w) {
        if (num > N) {
            return 0;
        }

        if (dp[num][w] != -1) {
            return dp[num][w];
        }

        dp[num][w] = 0;
        if (weight[num] + w <= K) {
            dp[num][w] = Math.max(dp[num][w], value[num] + solve(num + 1, w + weight[num]));
        }
        dp[num][w] = Math.max(dp[num][w], solve(num + 1, w));
        return dp[num][w];
    }
}
