import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class _220212_mostLongestIncreasingSubsequence2_boj12015 {
    static int N;
    static int[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(rd.readLine());
        A = Arrays.stream(rd.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int answer = solve();
        System.out.println(answer);
        rd.close();
    }

    static int solve() {
        List<Integer> list = new ArrayList<>();
        list.add(A[0]);

        for (int i = 1; i < N; i++) {
            int idx = binarySearch(list, A[i]);
            if (idx >= list.size()) {
                list.add(A[i]);
            } else {
                list.set(idx, A[i]);
            }
        }

        return list.size();
    }

    static int binarySearch(List<Integer> list, int target) {
        int left = 0;
        int right = list.size() - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (list.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}