import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.Set;
import java.util.HashSet;
import java.lang.StringBuilder;
import java.util.Collections;

public class _220106_treeIndependeceSet_boj2213 {
    static int[] w;
    static Map<Integer, List<Integer>> graph;
    static Map<Integer, Map<Integer, Set<Integer>>> indepSet;
    static int[] visited;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(rd.readLine());

        // n번째 노드의 가중치
        w = new int[n + 1];
        // n번째 노드를 0포함 / 1비포함 한 경우 최대 독립집합 가중치합
        dp = new int[n + 1][2];
        st = new StringTokenizer(rd.readLine());
        for (int i = 1; i <= n; i++) {
            w[i] = Integer.parseInt(st.nextToken());
            dp[i][0] = w[i];
        }

        graph = new HashMap<>();
        indepSet = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
            indepSet.put(i, new HashMap<>());
            indepSet.get(i).put(0, new HashSet<>());
            indepSet.get(i).put(1, new HashSet<>());
            indepSet.get(i).get(0).add(i);
        }
        for (int i = 1; i <= n - 1; i++) {
            st = new StringTokenizer(rd.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        // 방문 여부 체크
        visited = new int[n + 1];
        solve(1);

        List<Integer> s0 = new ArrayList<>(indepSet.get(1).get(0));
        List<Integer> s1 = new ArrayList<>(indepSet.get(1).get(1));
        s0.sort(Comparator.naturalOrder());
        Collections.sort(s1);

        if (dp[1][0] > dp[1][1]) {
            sb.append(dp[1][0] + "\n");
            for (int i : s0) {
                sb.append(i + " ");
            }
        } else {
            sb.append(dp[1][1] + "\n");
            for (int i : s1) {
                sb.append(i + " ");
            }
        }

        System.out.println(sb);
        rd.close();
    }

    public static void solve(int cur) {
        // dp[cur][1] = dp[parent][0] + w[cur];
        // dp[cur][0] = Math.max(dp[parent][1], dp[parent][0]);
        visited[cur] = 1;

        for (int next : graph.get(cur)) {
            if (visited[next] == 0) {
                solve(next);
                // 서브트리의 루트 포함
                dp[cur][0] += dp[next][1];
                indepSet.get(cur).get(0).addAll(indepSet.get(next).get(1));

                // 서브트리의 루트 노드 비포함
                if (dp[next][1] > dp[next][0]) {
                    dp[cur][1] += dp[next][1];
                    indepSet.get(cur).get(1).addAll(indepSet.get(next).get(1));
                } else {
                    dp[cur][1] += dp[next][0];
                    indepSet.get(cur).get(1).addAll(indepSet.get(next).get(0));
                }
            }
        }
    }
}
