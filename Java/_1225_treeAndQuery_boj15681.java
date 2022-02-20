import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;
import java.lang.StringBuilder;

public class _1225_treeAndQuery_boj15681 {
    static int N, R, Q;
    static int dp[];
    static int child[];
    static Map<Integer, List<Integer>> graph;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(rd.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        dp = new int[N + 1];
        child = new int[N + 1];
        graph = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(rd.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        visited = new int[N + 1];
        findChild();
        visited = new int[N + 1];
        getChildren(R);

        for (int i = 0; i < Q; i++) {
            int q = Integer.parseInt(rd.readLine());
            sb.append((dp[q] + 1) + "\n");
        }

        // for (int i = 1; i <= N; i++) {
        // System.out.print(child[i] + " ");
        // }
        // System.out.println();
        // for (int i = 1; i <= N; i++) {
        // System.out.print(dp[i] + " ");
        // }

        System.out.print(sb);
        rd.close();
    }

    public static int getChildren(int node) {
        visited[node] = 1;
        if (graph.get(node).size() == 0) {
            return 1;
        }
        int temp = 0;
        for (int nextNode : graph.get(node)) {
            if (visited[nextNode] == 0) {
                visited[nextNode] = 1;
                temp += getChildren(nextNode);
                temp += 1;
            }
        }
        dp[node] += temp;
        return dp[node];
    }

    public static void findChild() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(R);
        visited[R] = 1;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int next : graph.get(cur)) {
                if (visited[next] == 0) {
                    queue.add(next);
                    visited[next] = 1;
                    child[cur] += 1;
                }
            }
        }
    }
}
