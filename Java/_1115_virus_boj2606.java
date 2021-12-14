import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.Queue;

public class _1115_virus_boj2606 {
    static int[] visited = new int[101];
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Integer.parseInt(rd.readLine());
        int T = Integer.parseInt(rd.readLine());

        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(rd.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            if (graph.containsKey(s)) {
                graph.get(s).add(e);
            } else {
                graph.put(s, new ArrayList<>(Arrays.asList(e)));
            }

            if (graph.containsKey(e)) {
                graph.get(e).add(s);
            } else {
                graph.put(e, new ArrayList<>(Arrays.asList(s)));
            }
        }

        bfs(graph, 1);
        System.out.println(answer);
        rd.close();
    }

    public static void bfs(Map<Integer, List<Integer>> graph, int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = 1;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (graph.containsKey(cur)) {
                List<Integer> list = graph.get(cur);
                for (int i = 0; i < list.size(); i++) {
                    int next = list.get(i);
                    if (visited[next] == 0) {
                        visited[next] = 1;
                        queue.add(next);
                        answer++;
                    }
                }
            }
        }
    }
}
