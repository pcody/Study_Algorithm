package JavaCompleted;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _0920_findAlphabet_boj10809 {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int ch, idx = 0;
        int[] arr = new int[26];
        for (int i = 97; i <= 'z'; i++) {
            arr[i - 97] = 101;
        }
        while ((ch = rd.read()) >= 97) {
            arr[ch - 97] = Math.min(arr[ch - 97], idx);
            idx += 1;
        }
        for (int i = 97; i <= 'z'; i++) {
            if (arr[i - 97] != 101) {
                sb.append(arr[i - 97] + " ");
            } else {
                sb.append(-1 + " ");
            }

        }
        System.out.println(sb);
        rd.close();
    }
}