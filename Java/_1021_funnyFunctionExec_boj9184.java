import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1021_funnyFunctionExec_boj9184 {
    static int[][][] res = new int[21][21][21];

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int a = 1; a <= 20; a++) {
            for (int b = 1; b <= 20; b++) {
                for (int c = 1; c <= 20; c++) {
                    if (a < b && b < c) {
                        int s1 = 0;
                        int s2 = 0;
                        int s3 = 0;
                        if (c - 1 <= 0) {
                            s1 = 1;
                        } else {
                            s1 = res[a][b][c - 1];
                        }
                        if (b - 1 <= 0 || c - 1 <= 0) {
                            s2 = 1;
                        } else {
                            s2 = res[a][b - 1][c - 1];
                        }
                        if (b - 1 <= 0) {
                            s3 = 1;
                        } else {
                            s3 = res[a][b - 1][c];
                        }
                        res[a][b][c] = s1 + s2 - s3;
                        // res[a][b][c - 1] + res[a][b - 1][c - 1] + res[a][b - 1][c]
                    } else {
                        int s1 = 0;
                        int s2 = 0;
                        int s3 = 0;
                        int s4 = 0;
                        if (a - 1 <= 0) {
                            s1 = 1;
                        } else {
                            s1 = res[a - 1][b][c];
                        }
                        if (a - 1 <= 0 || b - 1 <= 0) {
                            s2 = 1;
                        } else {
                            s2 = res[a - 1][b - 1][c];
                        }
                        if (a - 1 <= 0 || c - 1 <= 0) {
                            s3 = 1;
                        } else {
                            s3 = res[a - 1][b][c - 1];
                        }
                        if (a - 1 <= 0 || b - 1 <= 0 || c - 1 <= 0) {
                            s4 = 1;
                        } else {
                            s4 = res[a - 1][b - 1][c - 1];
                        }
                        res[a][b][c] = s1 + s2 + s3 - s4;
                        // res[a - 1][b][c] + res[a - 1][b - 1][c] + res[a - 1][b][c - 1] + res[a - 1][b
                        // - 1][c - 1];
                    }
                }
            }
        }
        while (true) {
            st = new StringTokenizer(rd.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == -1 && b == -1 && c == -1) {
                break;
            }

            sb.append("w(" + a + ", " + b + ", " + c + ") = " + dp(a, b, c) + "\n");

        }
        System.out.println(sb);
        rd.close();
    }

    public static int dp(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            return 1;
        }
        if (a > 20 || b > 20 || c > 20) {
            return dp(20, 20, 20);
        }

        return res[a][b][c];
    }
}