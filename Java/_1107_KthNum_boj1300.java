import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class _1107_KthNum_boj1300 {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(rd.readLine());
        int k = Integer.parseInt(rd.readLine());

        int left = 1;
        int right = N * N;
        int answer = 0;
        while (left <= right) {
            int mid = (left + right) / 2;

            // i * j = mid
            int cnt = 0;
            for (int i = 1; i <= N; i++) {
                cnt += Math.min(mid / i, N);
            }

            if (cnt < k) {
                left = mid + 1;
            } else {
                answer = mid;
                right = mid - 1;
            }
        }
        System.out.println(answer);
        rd.close();
    }
}

// N = 5
// n 1 2 3 4
// 1 1 2 3 4
// 2 2 4 6 8
// 3 3 6 9 12
// 4 4 8 12 16
