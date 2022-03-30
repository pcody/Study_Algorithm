import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.lang.StringBuilder;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class _220209_tree_boj4803 {
    static Map<Integer, List<Integer>> graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n, m, tc = 1;
        while (true) {
            st = new StringTokenizer(rd.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            if (n == 0 && m == 0) {
                break;
            }

            // graph 생성
            graph = new HashMap<>();
            for (int i = 1; i <= n; i++) {
                graph.put(i, new ArrayList<>());
            }
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(rd.readLine());
                int v1 = Integer.parseInt(st.nextToken());
                int v2 = Integer.parseInt(st.nextToken());

                graph.get(v1).add(v2);
                graph.get(v2).add(v1);
            }

            // visited 생성
            visited = new boolean[n + 1];

            int cnt = 0;
            for (int i = 1; i <= n; i++) {
                if (!visited[i]) {
                    if (solve(-1, i)) {
                        cnt += 1;
                    }
                }
            }

            if (cnt == 0) {
                sb.append("Case " + tc++ + ": No trees.\n");
            } else if (cnt == 1) {
                sb.append("Case " + tc++ + ": There is one tree.\n");
            } else {
                sb.append("Case " + tc++ + ": A forest of " + cnt + " trees.\n");
            }
        }
        System.out.print(sb);

        rd.close();
    }

    static boolean solve(int parent, int cur) {
        visited[cur] = true;
        for (int next : graph.get(cur)) {
            // 부모 노드 X
            if (next != parent) {
                // 방문 O
                if (visited[next]) {
                    return false;
                }
                // 방문 X
                else {
                    if (!solve(cur, next)) {
                        return false;
                    }
                }
            }
            // 부모 노드 O -> 다음 노드 검사
            else {
                continue;
            }
        }
        return true;
    }
}
