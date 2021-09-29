import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _0929_digitGenerator_boj2231 {

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(rd.readLine());
        int[] arr = new int[N + 1];

        for (int i = 1; i < N + 1; i++) {
            int j = i;
            int digit = i;

            while (digit != 0) {
                j += digit % 10;
                digit /= 10;
            }
            if (j < N + 1 && arr[j] == 0) {
                arr[j] = i;
            }
        }

        System.out.println(arr[N]);
        rd.close();
    }
}