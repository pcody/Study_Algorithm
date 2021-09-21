package JavaCompleted;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _0920_sumOfNum_boj11720 {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(rd.readLine());
        int S = 0;

        while (N > 0) {
            N -= 1;
            S += Integer.parseInt(Character.toString(rd.read()));
        }
        System.out.println(S);
        rd.close();
    }
}
