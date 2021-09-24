import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _0924_beeHive_boj2292 {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(rd.readLine());

        int n = 1;
        while (true) {
            if (3 * n * n - 3 * n + 1 >= N) {
                break;
            }
            n++;
        }
        System.out.println(n);

        rd.close();
    }
}

// 1 = 1
// 6 = 2 * 6 - 6
// 12 = 3 * 6 - 6
// 18 = 4 * 6 - 6
// 24 = 5 * 6 - 6
// ...
// Sn = 1 + (2+3+4+5+...+n)*6 - (n-1)*6
// = 1 - 6 + 6n(n+1)/2 - 6n + 6
// = 1 + 3n^2-3n
// A1 = 1, n >= 2, An = 6n-6
// Sn = 6*n(n+1)/2-6n = 1 + 3n^2-3n

// 3n^2-3n+1

// 75-15+1 61 n=5
// 108-18+1 91 n=6
