import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _0926_primNumber_boj2581 {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(rd.readLine());
        int N = Integer.parseInt(rd.readLine());
        int S = 0;
        int minPrimeNum = -1;
        Boolean chk = false;
        for (int i = M; i <= N; i++) {
            if (isPrimeNum(i)) {
                S += i;
                if (chk == false) {
                    chk = !chk;
                    minPrimeNum = i;
                }
            }
        }
        if (S != 0) {
            System.out.println(S + "\n" + minPrimeNum);
        } else {
            System.out.println(minPrimeNum);
        }
        rd.close();
    }

    public static Boolean isPrimeNum(int num) {
        if (num == 1) {
            return false;
        }
        int sqrNum = (int) Math.sqrt(num);
        for (int i = 2; i <= sqrNum; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}