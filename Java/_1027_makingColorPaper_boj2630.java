import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class _1027_makingColorPaper_boj2630 {
    static int white, blue;

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(rd.readLine());
        int[][] paper = new int[N][];

        for (int i = 0; i < N; i++) {
            paper[i] = Arrays.stream(rd.readLine().split(" ")).mapToInt(t -> Integer.parseInt(t)).toArray();
        }

        dfs(paper);
        System.out.print(white + "\n" + blue);
        rd.close();
    }

    public static void dfs(int[][] paper) {
        int n = paper[0].length;
        switch (isWhiteOrBlue(paper)) {
        case 0:
            white++;
            break;
        case 1:
            blue++;
            break;
        case -1:
            int[][][] subPaper = new int[4][n / 2][];

            for (int i = 0; i < n / 2; i++) {
                subPaper[0][i] = Arrays.copyOfRange(paper[i], 0, n / 2);
                subPaper[1][i] = Arrays.copyOfRange(paper[i], n / 2, n);
            }

            for (int i = 0; i < n / 2; i++) {
                subPaper[2][i] = Arrays.copyOfRange(paper[i + n / 2], 0, n / 2);
                subPaper[3][i] = Arrays.copyOfRange(paper[i + n / 2], n / 2, n);
            }

            for (int i = 0; i < 4; i++) {
                dfs(subPaper[i]);
            }
            break;
        }
    }

    public static int isWhiteOrBlue(int[][] paper) {
        int s = 0;
        int n = paper.length;
        for (int i = 0; i < n; i++) {
            s += Arrays.stream(paper[i]).sum();
        }
        if (s == 0) {
            // white
            return 0;
        } else if (s == n * n) {
            // blue
            return 1;
        } else {
            // need to take apart
            return -1;
        }
    }
}
