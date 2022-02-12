import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.lang.StringBuilder;

public class _1206_mostLongIncreasingSubSequence4_boj14002 {
    static int N;
    static int[] A = new int[1001];
    static int[] dp = new int[1001];
    static Map<Integer, List<Integer>> lis = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(rd.readLine());
        st = new StringTokenizer(rd.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            lis.put(i, new ArrayList<>());
        }
        Arrays.fill(dp, -1);

        int answer = -1;
        int idx = 0;
        for (int i = 1; i <= N; i++) {
            int temp = solve(i);
            if (answer < temp) {
                answer = temp;
                idx = i;
            }
        }
        sb.append(answer + "\n");
        for (int i : lis.get(idx)) {
            sb.append(i + " ");
        }
        System.out.println(sb);
        rd.close();
    }

    public static int solve(int idx) {
        if (dp[idx] == -1) {
            dp[idx] = 1;
            lis.get(idx).add(A[idx]);

            for (int i = idx - 1; i >= 1; i--) {
                if (A[i] < A[idx]) {
                    int temp = 1 + solve(i);
                    if (dp[idx] < temp) {
                        lis.get(idx).clear();
                        List<Integer> tempList = new ArrayList<>();
                        for (int j : lis.get(i)) {
                            tempList.add(j);
                        }
                        tempList.add(A[idx]);
                        lis.replace(idx, tempList);
                        dp[idx] = temp;
                    }
                }
            }
        }
        return dp[idx];
    }
}

// 7
// 8 9 10 1 2 3 4
// 6
// 답: 4