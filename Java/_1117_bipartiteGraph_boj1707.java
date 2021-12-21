import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.util.StringTokenizer;

public class _1117_bipartiteGraph_boj1707 {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(rd.readLine());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(rd.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            Map<Integer, List<Integer>> graph = new HashMap<>();
            for (int i = 1; i <= V; i++) {
                graph.put(i, new ArrayList<>());
            }

            for (int e = 0; e < E; e++) {
                st = new StringTokenizer(rd.readLine());
                int v1 = Integer.parseInt(st.nextToken());
                int v2 = Integer.parseInt(st.nextToken());

                graph.get(v1).add(v2);
                graph.get(v2).add(v1);
            }

            int[] visited = new int[V + 1];
            Arrays.fill(visited, -1);
            boolean[] status = new boolean[V + 1];

            visitVertex(graph, visited, status, V);
            if (isBipartited(graph, status, V)) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }

        }
        System.out.print(sb);
        rd.close();
    }

    public static boolean isBipartited(Map<Integer, List<Integer>> graph, boolean[] status, int V) {
        for (int cur = 1; cur <= V; cur++) {
            List<Integer> list = graph.get(cur);
            for (int i = 0; i < list.size(); i++) {
                int next = list.get(i);

                if (status[cur] == status[next]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void visitVertex(Map<Integer, List<Integer>> graph, int[] visited, boolean[] status, int V) {
        Queue<Integer> queue = new LinkedList<>();
        for (int v = 1; v <= V; v++) {
            if (visited[v] == -1) {
                queue.add(v);
                visited[v] = 1;
                status[v] = true;

                while (!queue.isEmpty()) {
                    int cur = queue.poll();

                    List<Integer> list = graph.get(cur);
                    for (int i = 0; i < list.size(); i++) {
                        int next = list.get(i);

                        if (visited[next] == -1) {
                            queue.add(next);
                            visited[next] = 1;
                            status[next] = !status[cur];
                        }
                    }
                }
            }
        }
    }
}

// 1
// 4 3
// 1 3
// 2 4
// 3 4

// 1
// 4 3
// 1 2
// 2 3
// 3 1

// 1
// 4 2
// 1 2
// 3 4

// 1
// 3 1
// 2 3

// 11
// 3 1
// 2 3
// 3 2
// 1 3
// 2 3
// 4 4
// 1 2
// 2 3
// 3 4
// 4 2
// 3 2
// 2 1
// 3 2
// 4 4
// 2 1
// 3 2
// 4 3
// 4 1
// 5 2
// 1 5
// 1 2
// 5 2
// 1 2
// 2 5
// 4 3
// 1 2
// 4 3
// 2 3
// 4 4
// 2 3
// 1 4
// 3 4
// 1 2
// 3 3
// 1 2
// 2 3
// 3 1
// 2 1
// 1 2