import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Map.Entry;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.lang.StringBuilder;
import java.util.PriorityQueue;
import java.util.Arrays;

class VertexInfo1121 implements Comparable<VertexInfo1121> {
    public int vertex;
    public int cost;

    public VertexInfo1121(int vertex, int cost) {
        this.vertex = vertex;
        this.cost = cost;
    }

    @Override
    public int compareTo(VertexInfo1121 o) {
        return cost - o.cost;
    }
}

public class _1121_uncomfirmedArrival_boj9370_re {
    static Map<Integer, Map<Integer, Integer>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(rd.readLine());

        for (int tc = 0; tc < T; tc++) {
            // 교차로개수n, 도로개수m, 목적지개수t
            st = new StringTokenizer(rd.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            // 출발지s, 교차로gh
            st = new StringTokenizer(rd.readLine());
            int s = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            // 양방향 graph 생성
            graph = new HashMap<>();
            for (int i = 1; i <= n; i++) {
                graph.put(i, new HashMap<>());
            }
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(rd.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());

                graph.get(a).put(b, d);
                graph.get(b).put(a, d);
            }

            // 목적지 후보 destination
            List<Integer> destinations = new ArrayList<>();
            for (int i = 0; i < t; i++) {
                destinations.add(Integer.parseInt(rd.readLine()));
            }

            // s -> g -> h -> d == s -> d
            // s -> h -> g -> d == s -> d
            // 이면 answer에 넣는다
            List<Integer> answer = new ArrayList<>();
            for (int i = 0; i < destinations.size(); i++) {
                int destination = destinations.get(i);

                int sToG = dijkstra(n, s, g);
                int sToH = dijkstra(n, s, h);
                int gToH = dijkstra(n, g, h);
                int hToD = dijkstra(n, h, destination);
                int gToD = dijkstra(n, g, destination);
                int sToD = dijkstra(n, s, destination);

                if (sToG + gToH + hToD == sToD || sToH + gToH + gToD == sToD) {
                    answer.add(destination);
                }
            }
            answer.sort(Comparator.naturalOrder());
            for (int i = 0; i < answer.size(); i++) {
                sb.append(answer.get(i) + " ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
        rd.close();
    }

    public static int dijkstra(int n, int start, int end) {
        PriorityQueue<VertexInfo1121> heapq = new PriorityQueue<>();
        int[] cost = new int[n + 1];
        Arrays.fill(cost, Integer.MAX_VALUE);
        heapq.add(new VertexInfo1121(start, 0));
        cost[start] = 0;

        while (!heapq.isEmpty()) {
            VertexInfo1121 cur = heapq.poll();
            int curVertex = cur.vertex;
            int curCost = cur.cost;

            if (cost[curVertex] < curCost) {
                continue;
            }

            for (Entry<Integer, Integer> entry : graph.get(curVertex).entrySet()) {
                int nextVertex = entry.getKey();
                int nextCost = entry.getValue();

                if (curCost + nextCost < cost[nextVertex]) {
                    cost[nextVertex] = curCost + nextCost;
                    heapq.add(new VertexInfo1121(nextVertex, cost[nextVertex]));
                }
            }
        }
        return cost[end];
    }
}
