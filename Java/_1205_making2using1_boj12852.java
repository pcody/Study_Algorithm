import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class _1205_making2using1_boj12852 {
    static int[] dp = new int[1000001];
    static int[] arr = new int[1000001];
    static int X;

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        X = Integer.parseInt(rd.readLine());

        System.out.println(solve(X));
        int x = X;
        while (true) {
            if (x < 1) {
                break;
            }
            System.out.print(x + " ");
            x = arr[x];
        }
        rd.close();
    }

    public static int solve(int X) {
        dp[1] = 0;
        for (int i = 2; i <= X; i++) {
            dp[i] = dp[i - 1] + 1;
            arr[i] = i - 1;

            if (i % 3 == 0) {
                if (dp[i] > dp[i / 3] + 1) {
                    dp[i] = dp[i / 3] + 1;
                    arr[i] = i / 3;
                }
            }

            if (i % 2 == 0) {
                if (dp[i] > dp[i / 2] + 1) {
                    dp[i] = dp[i / 2] + 1;
                    arr[i] = i / 2;
                }
            }

        }
        return dp[X];
    }
}
