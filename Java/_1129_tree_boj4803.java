import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.lang.StringBuilder;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class _1129_tree_boj4803 {
    static Map<Integer, List<Integer>> tree;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = 0;
        while (true) {
            st = new StringTokenizer(rd.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            if (n == 0 && m == 0) {
                break;
            }

            tree = new HashMap<>();
            for (int i = 1; i <= n; i++) {
                tree.put(i, new ArrayList<>());
            }
            visited = new int[n + 1];
            int answer = 0;

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(rd.readLine());

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                tree.get(x).add(y);
                tree.get(y).add(x);
            }

            for (int i = 1; i <= n; i++) {
                if (visited[i] == 0) {
                    visited[i] = 1;
                    if (dfs(-1, i) == true) {
                        answer++;
                    }
                }
            }

            if (answer > 1) {
                sb.append("Case " + ++T + ": A forest of " + answer + " trees.\n");
            } else if (answer == 1) {
                sb.append("Case " + ++T + ": There is one tree.\n");
            } else {
                sb.append("Case " + ++T + ": No trees.\n");
            }
        }

        System.out.print(sb);
        rd.close();
    }

    public static boolean dfs(int parent, int cur) {
        for (int next : tree.get(cur)) {
            if (next == parent) {
                continue;
            }
            if (visited[next] == 1) {
                return false;
            }
            visited[next] = 1;
            if (dfs(cur, next) == false) {
                return false;
            }
        }
        return true;
    }
}
