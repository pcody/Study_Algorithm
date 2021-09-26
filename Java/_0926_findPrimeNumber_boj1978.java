import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _0926_findPrimeNumber_boj1978 {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(rd.readLine());
        int N = Integer.parseInt(st.nextToken());
        int chk = 0;
        st = new StringTokenizer(rd.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (isPrimeNum(num)) {
                chk += 1;
            }
        }

        System.out.println(chk);
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
