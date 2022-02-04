import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.lang.StringBuilder;
import java.util.Queue;
import java.util.LinkedList;

public class _1202_sangkeunTravel_boj9372 {
    static Map<Integer, List<Integer>> graph;
    static int[] visited;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(rd.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(rd.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            graph = new HashMap<>();
            for (int i = 1; i <= N; i++) {
                graph.put(i, new ArrayList<>());
            }
            visited = new int[N + 1];

            while (M-- > 0) {
                st = new StringTokenizer(rd.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph.get(a).add(b);
                graph.get(b).add(a);
            }

            answer = 0;
            mst();
            sb.append(answer + "\n");
        }
        System.out.print(sb);
        rd.close();
    }

    public static void mst() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = 1;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int next : graph.get(cur)) {
                if (visited[next] == 0) {
                    visited[next] = 1;
                    queue.add(next);
                    answer++;
                }
            }
        }
    }
}
