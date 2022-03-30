import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Map;
import java.util.HashMap;
import java.lang.StringBuilder;

class Tickets220209 implements Comparable<Tickets220209> {
    public int node;
    public int cost;
    public int time;

    public Tickets220209(int node, int cost, int time) {
        this.node = node;
        this.cost = cost;
        this.time = time;
    }

    @Override
    public int compareTo(Tickets220209 o) {
        return time - o.time;
    }
}

public class _220209_KCMTravel_b0j10217 {
    static int N, M, K;
    static Map<Integer, List<Tickets220209>> tickets;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(rd.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            st = new StringTokenizer(rd.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            tickets = new HashMap<>();
            for (int i = 1; i <= N; i++) {
                tickets.put(i, new ArrayList<>());
            }

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(rd.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());

                tickets.get(u).add(new Tickets220209(v, c, d));
            }

            if (solve()) {
                sb.append(dp[N][M] + "\n");
            } else {
                sb.append("Poor KCM\n");
            }

        }
        System.out.print(sb);
        rd.close();
    }

    static boolean solve() {
        dp = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        dp[1][0] = 0;

        PriorityQueue<Tickets220209> heapq = new PriorityQueue<>();
        heapq.add(new Tickets220209(1, 0, 0));

        while (!heapq.isEmpty()) {
            Tickets220209 cur = heapq.poll();
            int curNode = cur.node;
            int curCost = cur.cost;
            int curTime = cur.time;

            if (curNode == N) {
                return true;
            }

            if (dp[curNode][curCost] < curTime) {
                continue;
            }

            for (Tickets220209 next : tickets.get(curNode)) {
                int nextNode = next.node;
                int nextCost = curCost + next.cost;
                int nextTime = curTime + next.time;

                if (nextCost > M) {
                    continue;
                }

                if (dp[nextNode][nextCost] > nextTime) {
                    for (int i = nextCost; i <= M; i++) {
                        if (dp[nextNode][i] > nextTime) {
                            dp[nextNode][i] = nextTime;
                        } else {
                            break;
                        }
                    }
                    heapq.add(new Tickets220209(nextNode, nextCost, nextTime));
                }
            }
        }
        return false;
    }
}
