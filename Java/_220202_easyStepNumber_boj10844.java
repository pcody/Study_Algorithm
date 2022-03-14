import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class _220202_easyStepNumber_boj10844 {
    static long[][] dp = new long[101][10];
    static long divisor = 1000000000;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(rd.readLine());

        System.out.println(solve());

        rd.close();
    }

    static long solve() {
        long answer = 0;

        for (int j = 1; j <= 9; j++) {
            dp[1][j] = 1;
        }
        for (int i = 2; i <= N; i++) {
            for (int j = 0; j <= 9; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j + 1] % divisor;
                } else if (j == 9) {
                    dp[i][j] = dp[i - 1][j - 1] % divisor;
                } else {
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % divisor;
                }
            }
        }

        for (int i = 0; i <= 9; i++) {
            answer += dp[N][i];
            answer %= divisor;
        }
        return answer;
    }
}

// 0 1 2 3 4 5 6 7 8 9
// 1 0 1 1 1 1 1 1 1 1 1
// 2 1 1 2 2 2 2 2 2 2 1
// 3
// 4
// 5
// 6

// 9 1 -> 1 2 3 4 5 6 7 8 9 (0: 0, 9: 1)
// 17 2 -> 10 12 21 23 32 34 43 45 54 56 65 67 76 78 87 89 98
