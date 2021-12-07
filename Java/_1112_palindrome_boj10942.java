import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.lang.StringBuilder;

public class _1112_palindrome_boj10942 {
    static int[] arr = new int[2001];
    static int[][] dp = new int[2001][2001];

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(rd.readLine());
        st = new StringTokenizer(rd.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int j = 0; j < 2001; j++) {
            for (int i = 0; i < 2001; i++) {
                dp[j][i] = -1;
            }
        }

        int M = Integer.parseInt(rd.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(rd.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            sb.append(solve(start, end) + "\n");
        }

        System.out.print(sb);
        rd.close();
    }

    public static int solve(int start, int end) {
        if (start == end) {
            dp[start][end] = 1;
            return dp[start][end];
        } else if (start == end - 1) {
            if (arr[start] == arr[end]) {
                dp[start][end] = 1;
                return dp[start][end];
            } else {
                dp[start][end] = 0;
                return dp[start][end];
            }
        }

        if (dp[start][end] == -1) {
            boolean flag = true;
            for (int i = 0; i <= (end - start) / 2; i++) {
                if (arr[start + i] != arr[end - i]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                dp[start][end] = 1;
                dp[end][start] = dp[start][end];
            } else {
                dp[start][end] = 0;
                dp[end][start] = dp[start][end];
            }
        }

        return dp[start][end];
    }
}

// 1 2 1 3 1 2 1
// dp[1][1] dp[1][2] dp[1][3] dp[1][4] dp[1][5] dp[1][6] dp[1][7]
// dp[2][1] dp[2][2] dp[2][3] dp[2][4] dp[2][5] dp[2][6] dp[2][7]
// dp[3][1] dp[3][2] dp[3][3] dp[3][4] dp[3][5] dp[3][6] dp[3][7]
// dp[4][1] dp[4][2] dp[4][3] dp[4][4] dp[4][5] dp[4][6] dp[4][7]
// dp[5][1] dp[5][2] dp[5][3] dp[5][4] dp[5][5] dp[5][6] dp[5][7]
// dp[6][1] dp[6][2] dp[6][3] dp[6][4] dp[6][5] dp[6][6] dp[6][7]
// dp[7][1] dp[7][2] dp[7][3] dp[7][4] dp[7][5] dp[7][6] dp[7][7]