import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;
import java.lang.StringBuilder;

public class _1217_floyd2_boj11780 {
    static int n, m;
    static int[][] graph, costs, route;
    static int MAX_COST = 10000000;
    static List<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(rd.readLine());
        m = Integer.parseInt(rd.readLine());
        graph = new int[n + 1][n + 1];
        costs = new int[n + 1][n + 1];
        route = new int[n + 1][n + 1];

        // graph 초기화
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i != j) {
                    graph[i][j] = MAX_COST;
                }
            }
        }

        // graph 입력
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(rd.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a][b] = Math.min(graph[a][b], c);
        }

        // costs 초기화
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                costs[i][j] = graph[i][j];
            }
        }

        // cost 계산
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (costs[i][k] + costs[k][j] < costs[i][j]) {
                        costs[i][j] = costs[i][k] + costs[k][j];
                        route[i][j] = k;
                    }
                }
            }
        }

        // 출력
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (costs[i][j] == MAX_COST) {
                    sb.append(0 + " ");
                } else {
                    sb.append(costs[i][j] + " ");
                }
            }
            sb.append("\n");
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (costs[i][j] == MAX_COST || costs[i][j] == 0) {
                    sb.append(0 + " ");
                } else {
                    list = new ArrayList<>();
                    setRoute(i, j);
                    sb.append(list.size() + " ");
                    for (int k = 0; k < list.size(); k++) {
                        sb.append(list.get(k) + " ");
                    }
                }
                sb.append("\n");
            }
        }

        System.out.print(sb);
        rd.close();
    }

    public static void setRoute(int s, int e) {
        if (route[s][e] == 0) {
            list.add(s);
            list.add(e);
            return;
        }
        setRoute(s, route[s][e]);
        list.remove(list.size() - 1);
        setRoute(route[s][e], e);
    }
}
