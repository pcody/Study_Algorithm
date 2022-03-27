import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class _220208_KthNumber_boj1300 {
    static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(rd.readLine());
        K = Integer.parseInt(rd.readLine());

        System.out.println(solve());

        rd.close();
    }

    static int solve() {
        int left = 1;
        int right = K;
        int answer = 0;
        while (left <= right) {
            int mid = (left + right) / 2;

            int cnt = 0;
            for (int i = 1; i <= N; i++) {
                cnt += Math.min(N, mid / i);
            }

            if (cnt < K) {
                left = mid + 1;
            } else {
                answer = mid;
                right = mid - 1;
            }
        }

        return answer;
    }
}