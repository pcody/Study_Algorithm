package JavaCompleted;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _0919_starPrint2_boj2439 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());

        for (int i = 0; i < N; i++) {
            for (int j = N - i - 1; j > 0; j--) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        reader.close();
    }
}