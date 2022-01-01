import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Collections;
import java.lang.StringBuilder;

class Roads1118 implements Comparable<Roads1118> {
    public int node;
    public int distance;

    public Roads1118(int node, int distance) {
        this.node = node;
        this.distance = distance;
    }

    @Override
    public int compareTo(Roads1118 o1) {
        return this.distance - o1.distance;
    }
}

public class _1118_uncomfirmedArrival_boj9370 {
    static Map<Integer, List<Integer>> graphMap;
    static int[][] graphArr;
    static List<Integer> destination;

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(rd.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(rd.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(rd.readLine());
            int s = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            destination = new ArrayList<>();
            graphMap = new HashMap<>();
            graphArr = new int[n + 1][n + 1];
            for (int i = 1; i <= n; i++) {
                graphMap.put(i, new ArrayList<>());
            }
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(rd.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());

                graphMap.get(a).add(b);
                graphMap.get(b).add(a);
                graphArr[a][b] = d;
                graphArr[b][a] = d;
            }
            for (int i = 0; i < t; i++) {
                destination.add(Integer.parseInt(rd.readLine()));
            }

            int gDist = dijkstra(n, s, g);
            int hDist = dijkstra(n, s, h);
            List<Integer> answer = new ArrayList<>();
            if (gDist > hDist) {
                for (int i = 0; i < t; i++) {
                    int dest = destination.get(i);
                    if (graphArr[g][dest] != 0) {
                        answer.add(dest);
                    }
                }
            } else {
                for (int i = 0; i < t; i++) {
                    int dest = destination.get(i);
                    if (graphArr[h][dest] != 0) {
                        answer.add(dest);
                    }
                }
            }
            Collections.sort(answer);
            for (int i = 0; i < answer.size(); i++) {
                sb.append(answer.get(i) + " ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
        rd.close();
    }

    public static int dijkstra(int n, int start, int end) {
        int[] cost = new int[n + 1];
        Arrays.fill(cost, Integer.MAX_VALUE);
        PriorityQueue<Roads1118> heapq = new PriorityQueue<>();
        cost[start] = 0;
        heapq.add(new Roads1118(start, 0));

        while (!heapq.isEmpty()) {
            Roads1118 temp = heapq.poll();
            int cur = temp.node;
            int cDist = temp.distance;

            if (cost[cur] < cDist) {
                continue;
            }

            for (int i = 0; i < graphMap.get(cur).size(); i++) {
                int next = graphMap.get(cur).get(i);
                int nDist = graphArr[cur][next];

                if (cDist + nDist < cost[next]) {
                    cost[next] = cDist + nDist;
                    heapq.add(new Roads1118(next, cost[next]));
                }
            }
        }

        return cost[end];
    }
}
