import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class _220204_LCS_boj9251 {
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String[] str1 = rd.readLine().split("");
        String[] str2 = rd.readLine().split("");

        int n1 = str1.length;
        int n2 = str2.length;
        dp = new int[n2 + 1][n1 + 1];

        for (int i = 1; i <= n2; i++) {
            for (int j = 1; j <= n1; j++) {
                if (str1[j - 1].equals(str2[i - 1])) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        System.out.println(dp[n2][n1]);
        rd.close();
    }
}
