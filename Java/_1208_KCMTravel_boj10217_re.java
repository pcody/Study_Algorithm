import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.lang.StringBuilder;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;

class Node1208 implements Comparable<Node1208> {
    public int airport;
    public int cost;
    public int time;

    public Node1208(int airport, int cost, int time) {
        this.airport = airport;
        this.cost = cost;
        this.time = time;
    }

    @Override
    public int compareTo(Node1208 o) {
        return time - o.time;
    }
}

public class _1208_KCMTravel_boj10217_re {
    static Map<Integer, List<Node1208>> graph;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(rd.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(rd.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            graph = new HashMap<>();
            for (int i = 1; i <= N; i++) {
                graph.put(i, new ArrayList<>());
            }
            for (int i = 1; i <= K; i++) {
                st = new StringTokenizer(rd.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());

                graph.get(u).add(new Node1208(v, c, d));
            }

            if (dijkstra(N, M)) {
                sb.append(dp[N][M] + "\n");
            } else {
                sb.append("Poor KCM\n");
            }
        }
        System.out.print(sb);
        rd.close();
    }

    public static boolean dijkstra(int N, int M) {
        dp = new int[N + 1][M + 1];
        for (int j = 1; j <= N; j++) {
            for (int i = 0; i <= M; i++) {
                dp[j][i] = Integer.MAX_VALUE;
            }
        }
        dp[1][0] = 0;
        PriorityQueue<Node1208> heapq = new PriorityQueue<>();
        heapq.add(new Node1208(1, 0, 0));

        while (!heapq.isEmpty()) {
            Node1208 cur = heapq.poll();
            int curAirport = cur.airport;
            int curCost = cur.cost;
            int curTime = cur.time;

            if (curAirport == N) {
                return true;
            }

            if (dp[curAirport][curCost] < curTime) {
                continue;
            }

            for (Node1208 next : graph.get(curAirport)) {
                int nextAirport = next.airport;
                int nextCost = curCost + next.cost;
                int nextTime = curTime + next.time;

                if (M >= nextCost && dp[nextAirport][nextCost] > nextTime) {
                    for (int i = nextCost; i <= M; i++) {
                        if (dp[nextAirport][i] > nextTime) {
                            dp[nextAirport][i] = nextTime;
                        } else {
                            break;
                        }
                    }
                    heapq.add(new Node1208(nextAirport, nextCost, nextTime));
                }
            }
        }
        return false;
    }
}
