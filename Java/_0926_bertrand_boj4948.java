import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _0926_bertrand_boj4948 {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            int n = Integer.parseInt(rd.readLine());
            if (n == 0) {
                break;
            }
            int chk = 0;
            for (int i = n + 1; i <= n * 2; i++) {
                if (isPrimeNum(i)) {
                    chk += 1;
                }
            }
            sb.append(chk + "\n");
        }

        System.out.println(sb);
        rd.close();
    }

    public static Boolean isPrimeNum(int n) {
        if (n == 1) {
            return false;
        }
        int sqrN = (int) Math.sqrt(n);
        for (int i = 2; i <= sqrN; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}