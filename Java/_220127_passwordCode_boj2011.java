import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class _220127_passwordCode_boj2011 {
    static int divisor = 1000000;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String[] password = rd.readLine().split("");

        solve(password);

        System.out.println(answer);

        rd.close();
    }

    public static void solve(String[] password) {
        if (password.length == 0 || password.length == 1) {
            answer += 1;
            answer %= divisor;
            return;
        }

        String str = password[0] + password[1];
        if (Integer.valueOf(str) <= 26) {
            if (password.length >= 2) {
                solve(Arrays.copyOfRange(password, 2, password.length));
            }
        }
        solve(Arrays.copyOfRange(password, 1, password.length));
    }
}