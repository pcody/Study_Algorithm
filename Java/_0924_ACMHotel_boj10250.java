import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _0924_ACMHotel_boj10250 {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder answer = new StringBuilder();
        int T = Integer.parseInt(rd.readLine());

        for (int k = 0; k < T; k++) {
            st = new StringTokenizer(rd.readLine());
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            int[][] res = new int[H + 1][W + 1];
            int n = 0;
            int f = 0, r = 0;
            Boolean flag = false;
            for (int i = 1; i < W + 1; i++) {
                if (flag) {
                    break;
                }
                for (int j = 1; j < H + 1; j++) {
                    if (flag) {
                        break;
                    }

                    res[j][i] = 1;
                    n += 1;
                    if (n >= N) {
                        flag = true;
                        f = j;
                        r = i;
                    }
                }
            }
            answer.append(Integer.toString(f));
            if (r < 10) {
                answer.append("0");
            }
            answer.append(Integer.toString(r) + "\n");
        }
        System.out.print(answer);
        rd.close();
    }
}