import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.StringBuilder;
import java.util.StringTokenizer;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class _1130_tree_boj4803_re {
    static Map<Integer, List<Integer>> graph;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int tc = 0;
        while (true) {
            st = new StringTokenizer(rd.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            if (n == 0 && m == 0) {
                break;
            }

            graph = new HashMap<>();
            for (int i = 1; i <= n; i++) {
                graph.put(i, new ArrayList<>());
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(rd.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                graph.get(x).add(y);
                graph.get(y).add(x);
            }

            int answer = 0;
            visited = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                if (visited[i] == 0) {
                    visited[i] = 1;
                    if (dfs(0, i)) {
                        answer++;
                    }
                }
            }

            if (answer == 0) {
                sb.append("Case " + ++tc + ": No trees.\n");
            } else if (answer == 1) {
                sb.append("Case " + ++tc + ": There is one tree.\n");
            } else {
                sb.append("Case " + ++tc + ": A forest of " + answer + " trees.\n");
            }
        }

        System.out.print(sb);
        rd.close();
    }

    public static boolean dfs(int parent, int cur) {
        for (int next : graph.get(cur)) {
            if (next == parent) {
                continue;
            }

            if (visited[next] == 0) {
                visited[next] = 1;
                if (!dfs(cur, next)) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }
}
