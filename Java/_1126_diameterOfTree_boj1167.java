import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.PriorityQueue;

class Edge1126 implements Comparable<Edge1126> {
    public int v;
    public int d;

    public Edge1126(int v, int d) {
        this.v = v;
        this.d = d;
    }

    @Override
    public int compareTo(Edge1126 o) {
        return d - o.d;
    }
}

public class _1126_diameterOfTree_boj1167 {
    static int V;
    static Map<Integer, List<Edge1126>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        V = Integer.parseInt(rd.readLine());
        graph = new HashMap<>();
        for (int i = 1; i <= V; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int i = 1; i <= V; i++) {
            st = new StringTokenizer(rd.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            while (st.hasMoreTokens()) {
                int v2 = Integer.parseInt(st.nextToken());
                if (v2 == -1) {
                    break;
                }
                int d = Integer.parseInt(st.nextToken());
                graph.get(v1).add(new Edge1126(v2, d));
            }
        }
        int[] distance = new int[V + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        dijkstra(distance, 1);

        int start = 1;
        for (int i = 1; i <= V; i++) {
            if (distance[start] < distance[i]) {
                start = i;
            }
        }

        Arrays.fill(distance, Integer.MAX_VALUE);
        dijkstra(distance, start);

        int answer = 0;
        for (int i = 1; i <= V; i++) {
            answer = Math.max(answer, distance[i]);
        }

        System.out.println(answer);
        rd.close();
    }

    public static void dijkstra(int[] distance, int start) {
        PriorityQueue<Edge1126> heapq = new PriorityQueue<>();
        heapq.add(new Edge1126(start, 0));
        distance[start] = 0;

        while (!heapq.isEmpty()) {
            Edge1126 cur = heapq.poll();
            int curV = cur.v;
            int curD = cur.d;

            if (distance[curV] < curD) {
                continue;
            }

            for (Edge1126 next : graph.get(curV)) {
                int nextV = next.v;
                int nextD = curD + next.d;

                if (distance[nextV] > nextD) {
                    distance[nextV] = nextD;
                    heapq.add(new Edge1126(nextV, nextD));
                }
            }
        }
    }
}
