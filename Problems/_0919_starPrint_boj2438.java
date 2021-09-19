package JavaCompleted;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _0919_starPrint_boj2438 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        String str = "*";
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(str);
            }
            System.out.println();
        }
    }
}