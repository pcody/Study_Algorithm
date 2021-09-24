import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class _0924_bigNumberApB_boj10757 {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(rd.readLine());

        List<String> A = new ArrayList<String>(Arrays.asList(st.nextToken().split("")));
        List<String> B = new ArrayList<String>(Arrays.asList(st.nextToken().split("")));
        Collections.reverse(A);
        Collections.reverse(B);

        int l;
        if (A.size() > B.size()) {
            l = A.size();
        } else {
            l = B.size();
        }

        String answer = "";
        int carry = 0;
        for (int i = 0; i < l; i++) {
            int a, b;
            try {
                a = Integer.parseInt(A.get(i));
            } catch (Exception e) {
                a = 0;
            }
            try {
                b = Integer.parseInt(B.get(i));
            } catch (Exception e) {
                b = 0;
            }

            int s = a + b + carry;
            if (s >= 10) {
                carry = 1;
                answer = Integer.toString(s % 10) + answer;
            } else {
                carry = 0;
                answer = Integer.toString(s) + answer;
            }
        }
        if (carry > 0) {
            answer = Integer.toString(carry) + answer;
        }

        System.out.println(answer);
        rd.close();
    }
}