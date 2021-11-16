import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.lang.StringBuilder;

public class _1027_quadTree_boj1992 {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(rd.readLine());
        int[][] image = new int[N][];
        for (int i = 0; i < N; i++) {
            image[i] = Arrays.stream(rd.readLine().split("")).mapToInt(t -> Integer.parseInt(t)).toArray();
        }

        dfs(image, N);
        System.out.print(sb);
        rd.close();
    }

    public static void dfs(int[][] image, int n) {
        if (isPossible(image, n)) {
            sb.append(image[0][0]);
            return;
        }

        sb.append("(");

        int[][][] subImage = new int[4][n / 2][];
        for (int i = 0; i < n / 2; i++) {
            subImage[0][i] = Arrays.copyOfRange(image[i], 0, n / 2);
            subImage[1][i] = Arrays.copyOfRange(image[i], n / 2, n);
            subImage[2][i] = Arrays.copyOfRange(image[i + n / 2], 0, n / 2);
            subImage[3][i] = Arrays.copyOfRange(image[i + n / 2], n / 2, n);
        }

        dfs(subImage[0], n / 2);
        dfs(subImage[1], n / 2);
        dfs(subImage[2], n / 2);
        dfs(subImage[3], n / 2);

        sb.append(")");
    }

    public static boolean isPossible(int[][] image, int n) {
        int s = 0;

        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                s += image[j][i];
            }
        }

        if (s == 0 || s == n * n) {
            return true;
        } else {
            return false;
        }
    }
}