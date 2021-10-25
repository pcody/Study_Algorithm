import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1021_sudoku_boj2580 {
    static int[][] sudoku = new int[9][9];
    static boolean[][] col = new boolean[9][10];
    static boolean[][] row = new boolean[9][10];
    static boolean[][] square = new boolean[9][10];

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int j = 0; j < 9; j++) {
            st = new StringTokenizer(rd.readLine());
            for (int i = 0; i < 9; i++) {
                int k = Integer.parseInt(st.nextToken());
                sudoku[j][i] = k;
                col[j][k] = true;
                row[i][k] = true;
                square[xyToBox(j, i)][k] = true;
            }
        }

        try {
            fillSudoku(0);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void fillSudoku(int cnt) throws Exception {
        if (cnt >= 81) {
            for (int j = 0; j < 9; j++) {
                for (int i = 0; i < 9; i++) {
                    System.out.print(sudoku[j][i] + " ");
                }
                System.out.println();
            }
            System.exit(0);
        }

        int y = cnt / 9;
        int x = cnt % 9;

        if (sudoku[y][x] != 0) {
            fillSudoku(cnt + 1);
        } else {
            for (int k = 1; k <= 9; k++) {
                if (!col[y][k] && !row[x][k] && !square[xyToBox(y, x)][k]) {
                    sudoku[y][x] = k;
                    col[y][k] = true;
                    row[x][k] = true;
                    square[xyToBox(y, x)][k] = true;
                    fillSudoku(cnt + 1);
                    sudoku[y][x] = 0;
                    col[y][k] = false;
                    row[x][k] = false;
                    square[xyToBox(y, x)][k] = false;
                }
            }
        }
    }

    public static int xyToBox(int y, int x) {
        return (y / 3) * 3 + (x / 3);
    }
}