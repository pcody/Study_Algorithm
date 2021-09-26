import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _0926_getPrimeNumber_boj1929 {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(rd.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

        for (int i = M; i <= N; i++) {
            if (isPrimeNum(i)) {
                sb.append(i + "\n");
            }
        }

        System.out.println(sb);
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