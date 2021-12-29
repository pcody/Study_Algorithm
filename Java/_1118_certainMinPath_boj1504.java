import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.PriorityQueue;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

class EdgeInfo1118 implements Comparable<EdgeInfo1118> {
    public int vertex;
    public int cost;

    public EdgeInfo1118(int vertex, int cost) {
        this.vertex = vertex;
        this.cost = cost;
    }

    @Override
    public int compareTo(EdgeInfo1118 o1) {
        return this.cost - o1.cost;
    }
}

public class _1118_certainMinPath_boj1504 {
    static int N, E;
    static Map<Integer, List<EdgeInfo1118>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(rd.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        graph = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(rd.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new EdgeInfo1118(b, c));
            graph.get(b).add(new EdgeInfo1118(a, c));
        }
        st = new StringTokenizer(rd.readLine());
        int V1 = Integer.parseInt(st.nextToken());
        int V2 = Integer.parseInt(st.nextToken());

        int ans1 = dijkstra(1, V1);
        if (ans1 != Integer.MAX_VALUE) {
            ans1 += dijkstra(V1, V2);
        }
        if (ans1 != Integer.MAX_VALUE) {
            ans1 += dijkstra(V2, N);
        }

        int ans2 = dijkstra(1, V2);
        if (ans2 != Integer.MAX_VALUE) {
            ans2 += dijkstra(V2, V1);
        }
        if (ans2 != Integer.MAX_VALUE) {
            ans2 += dijkstra(V1, N);
        }

        if (ans1 != Integer.MAX_VALUE && ans2 != Integer.MAX_VALUE) {
            System.out.println(Math.min(ans1, ans2));
        } else {
            System.out.println(-1);
        }

        rd.close();
    }

    public static int dijkstra(int start, int end) {
        int[] cost = new int[N + 1];
        Arrays.fill(cost, Integer.MAX_VALUE);

        PriorityQueue<EdgeInfo1118> heapq = new PriorityQueue<>();
        heapq.add(new EdgeInfo1118(start, 0));
        cost[start] = 0;

        while (!heapq.isEmpty()) {
            EdgeInfo1118 temp = heapq.poll();
            int cur = temp.vertex;
            int curCost = temp.cost;

            if (cost[cur] < curCost) {
                continue;
            }

            List<EdgeInfo1118> list = graph.get(cur);
            for (int i = 0; i < list.size(); i++) {
                int next = list.get(i).vertex;
                int nCost = curCost + list.get(i).cost;

                if (nCost < cost[next]) {
                    heapq.add(new EdgeInfo1118(next, nCost));
                    cost[next] = nCost;
                }
            }
        }

        return cost[end];
    }
}
