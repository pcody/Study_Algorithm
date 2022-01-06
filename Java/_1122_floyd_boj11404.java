import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.lang.StringBuilder;

public class _1122_floyd_boj11404 {
    static int[][] graph;
    static int[][] costs;
    static int MAX_COST = 10000000;

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(rd.readLine());
        int m = Integer.parseInt(rd.readLine());

        // graph 초기화
        graph = new int[n + 1][n + 1];
        for (int j = 1; j <= n; j++) {
            for (int i = 1; i <= n; i++) {
                if (j != i) {
                    graph[j][i] = MAX_COST;
                }
            }
        }

        // graph 가중치 입력
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(rd.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a][b] = Integer.min(graph[a][b], c);
        }

        costs = new int[n + 1][n + 1];
        for (int j = 1; j <= n; j++) {
            for (int i = 1; i <= n; i++) {
                costs[j][i] = graph[j][i];
            }
        }
        for (int k = 1; k <= n; k++) {
            for (int j = 1; j <= n; j++) {
                for (int i = 1; i <= n; i++) {
                    if (costs[j][k] + costs[k][i] < costs[j][i]) {
                        costs[j][i] = costs[j][k] + costs[k][i];
                    }
                }
            }
        }

        for (int j = 1; j <= n; j++) {
            for (int i = 1; i <= n; i++) {
                if (costs[j][i] < MAX_COST) {
                    sb.append(costs[j][i] + " ");
                } else {
                    sb.append("0 ");
                }
            }
            sb.append("\n");
        }
        System.out.print(sb);
        rd.close();
    }
}
