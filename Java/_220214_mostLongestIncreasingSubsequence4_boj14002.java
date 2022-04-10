import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Stream;
import java.lang.StringBuilder;
import java.util.Map;

public class _220214_mostLongestIncreasingSubsequence4_boj14002 {
    static int N;
    static int[] A;
    static int[] dp;
    static Map<Integer, List<Integer>> map;

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(rd.readLine());
        A = Stream.of(rd.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        dp = new int[N];
        map = new HashMap<>();

        solve();

        int idx = 0, answer = 0;
        for (int i = 0; i < N; i++) {
            if (answer < dp[i]) {
                answer = dp[i];
                idx = i;
            }
        }
        sb.append(answer + "\n");
        for (int num : map.get(idx)) {
            sb.append(num + " ");
        }
        System.out.println(sb);

        rd.close();
    }

    static void solve() {
        for (int i = 0; i < N; i++) {
            int temp = 0;
            map.put(i, new ArrayList<>());
            for (int j = 0; j <= i; j++) {
                if (A[i] > A[j]) {
                    if (dp[j] > temp) {
                        temp = dp[j];
                        map.replace(i, new ArrayList<>(map.get(j)));
                    }
                }
            }
            dp[i] = temp + 1;
            map.get(i).add(A[i]);
        }
    }
}
