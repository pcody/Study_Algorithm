import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

class Index1209 {
    public int n;
    public int m;
    public String str;

    public Index1209(int n, int m, String str) {
        this.n = n;
        this.m = m;
        this.str = str;
    }
}

public class _1209_LCS2_boj9252 {
    static String[] arr1;
    static String[] arr2;
    static int dp[][];

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        arr1 = rd.readLine().split("");
        arr2 = rd.readLine().split("");
        int N = arr1.length;
        int M = arr2.length;

        dp = new int[N + 1][M + 1];

        System.out.println(solve(N, M));
        System.out.println(findSubStr(N, M));

        rd.close();
    }

    public static int solve(int N, int M) {
        for (int j = 1; j <= N; j++) {
            for (int i = 1; i <= M; i++) {
                if (arr1[j - 1].equals(arr2[i - 1])) {
                    dp[j][i] = dp[j - 1][i - 1] + 1;
                } else {
                    dp[j][i] = Math.max(dp[j - 1][i], dp[j][i - 1]);
                }
            }
        }
        return dp[N][M];
    }

    public static String findSubStr(int N, int M) {
        Stack<String> stack = new Stack<>();

        while (M > 0 && N > 0) {
            if (M == 0 || N == 0) {
                break;
            }

            if (dp[N - 1][M] < dp[N][M] && dp[N][M - 1] < dp[N][M]) {
                stack.push(arr1[N - 1]);
                N--;
                M--;
            } else if (dp[N - 1][M] == dp[N][M]) {
                N--;
            } else if (dp[N][M - 1] == dp[N][M]) {
                M--;
            }
        }

        String answer = "";
        while (!stack.isEmpty()) {
            answer += stack.pop();
        }
        return answer;
    }
}
