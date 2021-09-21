import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _0920_sangsoo_boj2908 {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String origStr = rd.readLine();
        String finStr = "";
        for (int i = origStr.length() - 1; i >= 0; i--) {
            finStr += Character.toString(origStr.charAt(i));
        }
        StringTokenizer st = new StringTokenizer(finStr);
        int num1 = Integer.parseInt(st.nextToken());
        int num2 = Integer.parseInt(st.nextToken());

        if (num1 > num2) {
            System.out.println(num1);
        } else {
            System.out.println(num2);
        }
    }
}