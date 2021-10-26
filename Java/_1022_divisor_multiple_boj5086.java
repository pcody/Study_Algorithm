import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.StringBuilder;
import java.util.StringTokenizer;

public class _1022_divisor_multiple_boj5086 {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while (true) {
            st = new StringTokenizer(rd.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (a == 0 && b == 0) {
                break;
            }

            if (b % a == 0) {
                sb.append("factor\n");
            } else if (a % b == 0) {
                sb.append("multiple\n");
            } else {
                sb.append("neither\n");
            }
        }

        System.out.println(sb);

        rd.close();
    }
}
