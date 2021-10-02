import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class _1002_NQueen_boj9663 {
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(rd.readLine());
        int[][] board = new int[N][N];
        List<List<Integer>> position = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            position.add(new ArrayList<>(Arrays.stream(new int[] { -1, -1 }).boxed().collect(Collectors.toList())));
        }
        setQueens(N, board, position, 0);
        System.out.println(answer);
        rd.close();
    }

    static void chkQueens(int N, int[][] board, List<List<Integer>> position, int qN) {
        int[][] vecxy = { { 0, -1 }, { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 } };
        Boolean chk = false; // false : 주변에 공격할 수 있는 퀸이 없음, true가 되면 while 탈출
        for (List<Integer> xy : position) {
            if (chk) {
                break;
            }
            int x = xy.get(0);
            int y = xy.get(1);
            for (int i = 0; i < vecxy.length; i++) {
                if (chk) {
                    break;
                }
                int vecx = vecxy[i][0];
                int vecy = vecxy[i][1];
                int nx = x + vecx;
                int ny = y + vecy;
                while (!chk && (0 <= nx && nx < N) && (0 <= ny && ny < N)) {
                    if (board[ny][nx] == 1) {
                        chk = !chk;
                    }
                    nx += vecx;
                    ny += vecy;
                }
            }
        }
        if (!chk) {
            answer += 1;
        }
    }

    static void setQueens(int N, int[][] board, List<List<Integer>> position, int qN) {
        if (qN >= N) {
            for (List<Integer> xy : position) {
                System.out.print(xy + " ");
                chkQueens(N, board, position, qN);
            }
            System.out.println();
            return;
        }

        for (int j = 0; j < N; j++) {
            for (int i = 0; i < N; i++) {
                if (board[j][i] == 0) {
                    board[j][i] = 1;
                    qN += 1;
                    if (qN > 1) {
                        int preX = position.get(qN - 2).get(0);
                        int preY = position.get(qN - 2).get(1);
                        if ((i > preX && j == preY) || (j > preY)) {
                            position.set(qN - 1,
                                    Arrays.stream(new int[] { i, j }).boxed().collect(Collectors.toList()));
                            setQueens(N, board, position, qN);
                        }
                    } else {
                        position.set(qN - 1, Arrays.stream(new int[] { i, j }).boxed().collect(Collectors.toList()));
                        setQueens(N, board, position, qN);
                    }

                    board[j][i] = 0;
                    qN -= 1;
                }
            }
        }
    }
}