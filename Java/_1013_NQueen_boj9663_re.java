import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class _1013_NQueen_boj9663_re {
    static int res;
    static int N;
    static int[] queens;

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(rd.readLine());
        queens = new int[N];

        setQueens(0);
        System.out.println(res);
        rd.close();
    }

    public static void setQueens(int row) {
        if (row >= N) {
            res++;
            return;
        }

        for (int i = 0; i < N; i++) {
            queens[row] = i;
            if (isPossible(row)) {
                setQueens(row + 1);
            }
        }
    }

    // queen[row] = col;
    public static Boolean isPossible(int row) {
        for (int i = 0; i < row; i++) {
            if (queens[row] == queens[i] || (Math.abs(queens[row] - queens[i]) == Math.abs(row - i))) {
                return false;
            }
        }
        return true;
    }
}