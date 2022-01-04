import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.StringBuilder;

class EdgeInfo1121 {
    public int v1;
    public int v2;
    public long cost;

    public EdgeInfo1121(int v1, int v2, long cost) {
        this.v1 = v1;
        this.v2 = v2;
        this.cost = cost;
    }
}

public class _1121_timeMachine_boj11657 {
    static List<EdgeInfo1121> graph;
    static long[] costs;

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(rd.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        costs = new long[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(rd.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            graph.add(new EdgeInfo1121(s, e, c));
        }

        Arrays.fill(costs, Long.MAX_VALUE);
        costs[1] = 0;
        boolean isCycle = bellmanFord(N);

        if (isCycle) {
            sb.append(-1 + "\n");
        } else {
            for (int i = 2; i <= N; i++) {
                if (costs[i] != Long.MAX_VALUE) {
                    sb.append(costs[i] + "\n");
                } else {
                    sb.append(-1 + "\n");
                }
            }
        }

        System.out.print(sb);
        rd.close();
    }

    public static boolean bellmanFord(int N) {
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < graph.size(); j++) {
                EdgeInfo1121 edge = graph.get(j);
                int cur = edge.v1;
                int next = edge.v2;
                long cost = edge.cost;

                if (costs[cur] == Long.MAX_VALUE) {
                    continue;
                }

                if (costs[cur] + cost < costs[next]) {
                    costs[next] = costs[cur] + cost;
                }
            }
        }

        for (int i = 0; i < graph.size(); i++) {
            EdgeInfo1121 edge = graph.get(i);
            int cur = edge.v1;
            int next = edge.v2;
            long cost = edge.cost;

            if (costs[cur] == Long.MAX_VALUE) {
                continue;
            }

            if (costs[cur] + cost < costs[next]) {
                return true;
            }
        }
        return false;
    }
}
