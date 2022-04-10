import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class _220214_threeDice_boj2480 {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(rd.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        if (a == b && a == c) {
            System.out.println(10000 + a * 1000);
        } else if (a == b || a == c || b == c) {
            if (a == b || a == c) {
                System.out.println(1000 + a * 100);
            } else {
                System.out.println(1000 + b * 100);
            }
        } else {
            System.out.println(100 * (a > b ? (a > c ? a : c) : (b > c ? b : c)));
        }
        rd.close();
    }
}
