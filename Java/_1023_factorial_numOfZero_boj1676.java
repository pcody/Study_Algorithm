import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1023_factorial_numOfZero_boj1676 {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(rd.readLine());

        int cnt = 0;
        while (N >= 5) {
            cnt += N / 5;
            N /= 5;
        }

        System.out.print(cnt);
        rd.close();
    }
}