import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _0924_snailWantsToUp_boj2869 {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(rd.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        int day;
        int n = (V - A) / (A - B);
        if ((V - A) % (A - B) == 0) {
            day = n + 1;
        } else {
            day = n + 2;
        }

        System.out.println(day);
        rd.close();
    }
}

// V---------

// A-B V-A ------
// A-B A-B
// A-B A-B
// A-B A-B