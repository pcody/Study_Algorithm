import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.stream.Stream;

public class _1028_numOfPaper_boj1780 {
    static int zero, one, minusOne;

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(rd.readLine());
        int[][] paper = new int[N][];
        for (int i = 0; i < N; i++) {
            paper[i] = Stream.of(rd.readLine().split(" ")).mapToInt(t -> Integer.parseInt(t)).toArray();
        }

        dfs(paper, 0, 0, N);
        System.out.print(minusOne + "\n" + zero + "\n" + one);
        rd.close();
    }

    public static void dfs(int[][] paper, int x, int y, int n) {
        switch (filledWith(paper, x, y, n)) {
        case -2:
            dfs(paper, x, y, n / 3);
            dfs(paper, x + n / 3, y, n / 3);
            dfs(paper, x + 2 * n / 3, y, n / 3);
            dfs(paper, x, y + n / 3, n / 3);
            dfs(paper, x + n / 3, y + n / 3, n / 3);
            dfs(paper, x + 2 * n / 3, y + n / 3, n / 3);
            dfs(paper, x, y + 2 * n / 3, n / 3);
            dfs(paper, x + n / 3, y + 2 * n / 3, n / 3);
            dfs(paper, x + 2 * n / 3, y + 2 * n / 3, n / 3);
            break;
        case -1:
            minusOne++;
            break;
        case 0:
            zero++;
            break;
        case 1:
            one++;
            break;
        }
    }

    public static int filledWith(int[][] paper, int x, int y, int n) {
        boolean flag = true;
        for (int j = y; j < y + n; j++) {
            if (flag == false)
                break;
            for (int i = x; i < x + n; i++) {
                if (paper[y][x] != paper[j][i]) {
                    flag = false;
                    break;
                }
            }
        }
        if (flag) {
            return paper[y][x];
        } else {
            return -2;
        }
    }
}
