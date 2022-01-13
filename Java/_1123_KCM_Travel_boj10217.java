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

class TravelInfo1123 implements Comparable<TravelInfo1123> {
    public int city;
    public int cost;
    public int time;

    public TravelInfo1123(int city, int cost, int time) {
        this.city = city;
        this.cost = cost;
        this.time = time;
    }

    @Override
    public int compareTo(TravelInfo1123 o) {
        return time - o.time;
    }
}

public class _1123_KCM_Travel_boj10217 {
    static Map<Integer, List<TravelInfo1123>> graph;
    static int[][] dp = new int[101][10001];

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(rd.readLine());

        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(rd.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            graph = new HashMap<>();
            for (int i = 1; i <= N; i++) {
                graph.put(i, new ArrayList<>());
            }
            for (int j = 0; j <= 100; j++) {
                for (int i = 0; i <= 10000; i++) {
                    dp[j][i] = Integer.MAX_VALUE;
                }
            }
            for (int i = 1; i <= K; i++) {
                st = new StringTokenizer(rd.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());
                graph.get(u).add(new TravelInfo1123(v, c, d));
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
        PriorityQueue<TravelInfo1123> heapq = new PriorityQueue<>();
        heapq.add(new TravelInfo1123(1, 0, 0));
        dp[1][0] = 0;

        while (!heapq.isEmpty()) {
            TravelInfo1123 cur = heapq.poll();
            int curCity = cur.city;
            int curCost = cur.cost;
            int curTime = cur.time;

            if (curCity == N) {
                return true;
            }

            if (dp[curCity][curCost] < curTime) {
                continue;
            }

            List<TravelInfo1123> list = graph.get(curCity);
            for (int i = 0; i < list.size(); i++) {
                int nextCity = list.get(i).city;
                int nextCost = curCost + list.get(i).cost;
                int nextTime = dp[curCity][curCost] + list.get(i).time;

                if (nextCost > M) {
                    continue;
                }

                if (dp[nextCity][nextCost] > nextTime) {
                    for (int j = nextCost; j <= M; j++) {
                        if (dp[nextCity][j] > nextTime) {
                            dp[nextCity][j] = nextTime;
                        } else {
                            break;
                        }
                    }
                    heapq.add(new TravelInfo1123(nextCity, nextCost, nextTime));
                }
            }
        }
        return false;
    }
}
