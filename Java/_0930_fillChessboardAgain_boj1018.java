import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _0930_fillChessboardAgain_boj1018 {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(rd.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String[][] chessBoard = new String[N][];
        int answer = Integer.MAX_VALUE;

        for (int j = 0; j < N; j++) {
            st = new StringTokenizer(rd.readLine());
            chessBoard[j] = st.nextToken().split("");
        }

        for (int j = 0; j < N - 7; j++) {
            for (int i = 0; i < M - 7; i++) {
                String[][] slicedChessBoard = new String[8][];

                int temp1 = 0;
                for (int k = 0; k < 8; k++) {
                    slicedChessBoard[k] = Arrays.copyOfRange(chessBoard[k + j], i, i + 8);
                }
                if (slicedChessBoard[0][0].equals("B")) {
                    temp1 += 1;
                }
                slicedChessBoard[0][0] = "W";
                temp1 = findChessBoard(slicedChessBoard, temp1);

                int temp2 = 0;
                for (int k = 0; k < 8; k++) {
                    slicedChessBoard[k] = Arrays.copyOfRange(chessBoard[k + j], i, i + 8);
                }
                if (slicedChessBoard[0][0].equals("W")) {
                    temp2 += 1;
                }
                slicedChessBoard[0][0] = "B";
                temp2 = findChessBoard(slicedChessBoard, temp2);

                int temp = Math.min(temp1, temp2);
                answer = Math.min(answer, temp);
            }
        }

        System.out.println(answer);
        rd.close();
    }

    public static int findChessBoard(String[][] slicedChessBoard, int answer) {
        int[][] vecxy = { { 0, -1 }, { -1, 0 }, { 0, 1 }, { 1, 0 } };

        for (int j = 0; j < 8; j++) {
            for (int i = 0; i < 8; i++) {
                for (int k = 0; k < 4; k++) {
                    String cur = slicedChessBoard[j][i];
                    int x = i + vecxy[k][0];
                    int y = j + vecxy[k][1];
                    if ((0 <= x && x < 8) && (0 <= y && y < 8)) {
                        try {
                            if (cur.equals(slicedChessBoard[y][x])) {
                                if (cur.equals("W")) {
                                    slicedChessBoard[y][x] = "B";
                                    answer += 1;
                                } else {
                                    slicedChessBoard[y][x] = "W";
                                    answer += 1;
                                }
                            }
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                    }
                }
            }
        }

        return answer;
    }
}