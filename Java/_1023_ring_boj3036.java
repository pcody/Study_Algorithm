import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.lang.StringBuilder;

public class _1023_ring_boj3036 {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        Integer.parseInt(rd.readLine());
        StringTokenizer st = new StringTokenizer(rd.readLine());
        int firstR = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

        while (st.hasMoreTokens()) {
            int r = Integer.parseInt(st.nextToken());
            int g = gcd(firstR, r);
            sb.append(firstR / g + "/" + r / g + "\n");
        }

        System.out.println(sb);

        rd.close();
    }

    public static int gcd(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}