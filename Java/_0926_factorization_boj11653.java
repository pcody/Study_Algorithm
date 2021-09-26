import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _0926_factorization_boj11653 {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(rd.readLine());
        factorization(N);
        rd.close();
    }

    public static void factorization(int N) {
        if (N == 1) {
            return;
        }
        int divisor;
        for (divisor = 2; divisor <= N; divisor++) {
            if (N % divisor == 0) {
                N /= divisor;
                break;
            }
        }
        System.out.println(divisor);
        factorization(N);
    }
}