import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.stream.Stream;

public class _1111_matrixProductOrder_boj11049 {
    static int[][] matrix = new int[501][2];
    static int[][] dp = new int[501][501];

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(rd.readLine());

        for (int i = 1; i <= N; i++) {
            matrix[i] = Stream.of(rd.readLine().split(" ")).mapToInt(t -> Integer.parseInt(t)).toArray();
        }

        for (int j = 0; j < 501; j++) {
            for (int i = 0; i < 501; i++) {
                dp[j][i] = -1;
            }
        }

        System.out.println(solve(1, N));
        rd.close();
    }

    public static int solve(int start, int end) {
        if (start == end - 1) {
            dp[start][end] = matrix[start][0] * matrix[start][1] * matrix[end][1];
        } else if (start == end) {
            return 0;
        }

        if (dp[start][end] == -1) {
            dp[start][end] = Integer.MAX_VALUE;
            for (int i = start; i < end; i++) {
                dp[start][end] = Math.min(dp[start][end],
                        solve(start, i) + solve(i + 1, end) + matrix[start][0] * matrix[i][1] * matrix[end][1]);
            }
        }
        return dp[start][end];
    }
}

// A: 4 * 5
// B: 5 * 2
// C: 2 * 6
// D: 6 * 7
// solve(1, 4);
// dp[1][4] = min(dp[1][4], solve(1,1) + solve(2,4)) A(BCD) -> A((BC)D)
// dp[1][4] = min(dp[1][4], solve(1,2) + solve(3,4)) (AB)(CD)
// dp[1][4] = min(dp[1][4], solve(1,3) + solve(4,4)) (ABC)D

// A: 4 * 5
// B: 5 * 2
// C: 2 * 6
// dp[1][3] = min(dp[1][3], solve(1,1) + solve(2,3)) A(BC) -> 4*5*6 + 5*2*6
// dp[1][3] = min(dp[1][3], solve(1,2) + solve(3,3)) (AB)C -> 4*5*2 + 4*2*6

// 4 * 5 * 6 + 5 * 2 * 6 = 120 + 60 = 180
// 4 * 5 * 2 + 4 * 2 * 6 = 40 + 48 = 88

// (AB)C)D
// A((BC)D)
// (A(BC))D
// (AB)(CD)
// A(B(CD)