import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class _1028_matrixProduct_boj2740 {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(rd.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] m1 = new int[N][];
        for (int i = 0; i < N; i++) {
            m1[i] = Arrays.stream(rd.readLine().split(" ")).mapToInt(t -> Integer.parseInt(t)).toArray();
        }

        st = new StringTokenizer(rd.readLine());
        st.nextToken();
        int K = Integer.parseInt(st.nextToken());
        int[][] m2 = new int[M][];
        for (int i = 0; i < M; i++) {
            m2[i] = Arrays.stream(rd.readLine().split(" ")).mapToInt(t -> Integer.parseInt(t)).toArray();
        }

        int[][] m3 = new int[N][K];
        for (int n = 0; n < N; n++) {
            for (int k = 0; k < K; k++) {
                int s = 0;
                for (int m = 0; m < M; m++)
                    s += m1[n][m] * m2[m][k];
                m3[n][k] = s;
            }
        }

        for (int j = 0; j < N; j++) {
            for (int i = 0; i < K; i++) {
                System.out.print(m3[j][i] + " ");
            }
            System.out.println();
        }
        rd.close();
    }
}
