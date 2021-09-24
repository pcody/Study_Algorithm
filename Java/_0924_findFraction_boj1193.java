import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _0924_findFraction_boj1193 {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));

        int X = Integer.parseInt(rd.readLine());

        int n = 1;
        while (true) {
            if ((n * n + n) / 2 >= X) {
                break;
            }
            n++;
        }
        int start = n;
        int numerator, denumerator;
        if (start % 2 == 1) {
            numerator = start;
            denumerator = 1;
            for (int i = (n * n - n) / 2 + 1; i < X; i++) {
                numerator -= 1;
                denumerator += 1;
            }
        } else {
            numerator = 1;
            denumerator = start;
            for (int i = (n * n - n) / 2 + 1; i < X; i++) {
                numerator += 1;
                denumerator -= 1;
            }
        }

        System.out.println(numerator + "/" + denumerator);
        rd.close();
    }
}

// 1 2 6 7 15 16
// 3 5 8 14 17
// 4 9 13 18
// 10 12 19
// 11 20
// 21

// 1 2 3 4 5 6 7
// 1 3 6 10 15 21
// Sn = n(n+1)/2