import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class _1125_ContinuousSumOfPrimeNum_boj1644 {
    static int N;
    static List<Integer> nums;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(rd.readLine());
        nums = new ArrayList<>();

        findPrimeNum();
        solve();

        System.out.println(answer);
        rd.close();
    }

    static void solve() {
        int left = 0;
        int right = left;
        int limit = nums.size();
        int sum = 0;
        while (left < limit) {
            sum += nums.get(right);
            if (sum == N) {
                answer++;
                left++;
                right = left;
                sum = 0;
            } else if (sum < N) {
                if (right < limit) {
                    if (right < limit - 1) {
                        right++;
                    } else {
                        left++;
                        right = left;
                        sum = 0;
                    }
                } else {
                    break;
                }
            } else { // sum > N
                left++;
                right = left;
                sum = 0;
            }
        }
    }

    static void findPrimeNum() {
        boolean[] arr = new boolean[N + 1];

        for (int i = 2; i <= N; i++) {
            for (int j = 2, num = i * j; num <= N; num = i * ++j) {
                arr[num] = true;
            }
        }

        for (int i = 2; i <= N; i++) {
            if (!arr[i]) {
                nums.add(i);
            }
        }
    }
}
