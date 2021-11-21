import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class _1029_fibonacciNumber_boj11444 {
    static long divisor = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(rd.readLine());
        System.out.println(fibonacci(n));
        rd.close();
    }

    public static long fibonacci(long n) {
        long[][] A = { { 1, 1 }, { 1, 0 } };
        long[][] ret = pow(A, n);
        return ret[1][0] % divisor;
    }

    public static long[][] pow(long[][] A, long n) {
        if (n == 1) {
            return A;
        }

        long[][] temp = pow(A, n / 2);

        if (n % 2 == 1) {
            return matrixProduct(matrixProduct(temp, temp), A);
        }
        return matrixProduct(temp, temp);
    }

    public static long[][] matrixProduct(long[][] A, long[][] B) {
        long[][] ret = new long[2][2];
        for (int j = 0; j < 2; j++) {
            for (int i = 0; i < 2; i++) {
                for (int k = 0; k < 2; k++) {
                    ret[j][i] += (A[j][k] * B[k][i]) % divisor;
                }
            }
        }
        return ret;
    }
}
