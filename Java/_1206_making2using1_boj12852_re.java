import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class _1206_making2using1_boj12852_re {
    static int N;
    static int dp[] = new int[1000001];
    static int arr[] = new int[1000001];

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(rd.readLine());
        for (int i = 0; i <= N; i++) {
            dp[i] = -1;
        }
        dp[0] = 0;
        dp[1] = 0;

        int answer = solve(N);
        System.out.println(answer);
        int x = N;
        while (true) {
            if (x < 1) {
                break;
            }
            System.out.print(x + " ");
            x = arr[x];
        }
        rd.close();
    }

    public static int solve(int n) {
        if (dp[n] != -1) {
            return dp[n];
        }

        dp[n] = solve(n - 1) + 1;
        arr[n] = n - 1;

        if (n % 3 == 0) {
            int temp = solve(n / 3) + 1;
            if (dp[n] > temp) {
                dp[n] = temp;
                arr[n] = n / 3;
            }
        }

        if (n % 2 == 0) {
            int temp = solve(n / 2) + 1;
            if (dp[n] > temp) {
                dp[n] = temp;
                arr[n] = n / 2;
            }
        }

        return dp[n];
    }
}
