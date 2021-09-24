import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _0924_presidentOfApartment_boj2775 {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(rd.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            int k = Integer.parseInt(rd.readLine());
            int n = Integer.parseInt(rd.readLine());

            int[][] res = new int[k + 1][n + 1];
            for (int i = 1; i < n + 1; i++) {
                res[0][i] = i;
            }

            for (int j = 1; j < k + 1; j++) {
                for (int i = 1; i < n + 1; i++) {
                    res[j][i] = res[j - 1][i] + res[j][i - 1];
                }
            }
            sb.append(res[k][n] + "\n");
        }
        System.out.print(sb);
        rd.close();
    }
}

// 1층 3호
// 0층 1호 1명
// 0층 2호 2명
// 0층 3호 3명