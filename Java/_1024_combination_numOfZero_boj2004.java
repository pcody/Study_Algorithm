import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class _1024_combination_numOfZero_boj2004 {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(rd.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = n - m;

        int cnt = Math.min(pow2(n) - pow2(m) - pow2(r), pow5(n) - pow5(m) - pow5(r));
        System.out.println(cnt);

        rd.close();
    }

    public static int pow2(int a) {
        int cnt = 0;
        while (a >= 2) {
            cnt += a / 2;
            a /= 2;
        }
        return cnt;
    }

    public static int pow5(int a) {
        int cnt = 0;
        while (a >= 5) {
            cnt += a / 5;
            a /= 5;
        }
        return cnt;
    }
}