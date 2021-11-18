import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.stream.Stream;
import java.lang.StringBuilder;

public class _1028_powerOfMatrix_boj10830 {
    static long divisor = 1000;

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(rd.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        long[][] m1 = new long[N][];
        for (int i = 0; i < N; i++) {
            m1[i] = Stream.of(rd.readLine().split(" ")).mapToLong(t -> Long.parseLong(t)).toArray();
        }

        m1 = powerMatrix(m1, B);

        for (int j = 0; j < N; j++) {
            for (int i = 0; i < N; i++) {
                sb.append(m1[j][i] % 1000 + " ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
        rd.close();
    }

    private static long[][] powerMatrix(long[][] baseMatrix, long exp) {
        if (exp == 1) {
            return baseMatrix;
        }

        long[][] midMatrix = powerMatrix(baseMatrix, exp / 2);

        if (exp % 2 == 1) {
            return calMatrix(calMatrix(midMatrix, midMatrix), baseMatrix);
        }
        return calMatrix(midMatrix, midMatrix);
    }

    private static long[][] calMatrix(long[][] m1, long[][] m2) {
        int n = m1.length;
        long[][] ret = new long[n][n];

        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                for (int k = 0; k < n; k++) {
                    ret[j][i] += (m1[j][k] % divisor) * (m2[k][i] % divisor);
                }
                ret[j][i] %= divisor;
            }
        }

        return ret;
    }
}
