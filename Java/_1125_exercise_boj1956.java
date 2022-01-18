import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class _1125_exercise_boj1956 {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(rd.readLine());
        int V, E;
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        int[][] graph = new int[V + 1][V + 1];
        for (int i = 0; i < E; i++) {
            int a, b, c;
            st = new StringTokenizer(rd.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            graph[a][b] = c;
        }

        int[][] cost = new int[V + 1][V + 1];
        for (int j = 0; j <= V; j++) {
            for (int i = 0; i <= V; i++) {
                if (graph[j][i] == 0) {
                    cost[j][i] = 4000000;
                } else {
                    cost[j][i] = graph[j][i];
                }
            }
        }

        for (int k = 1; k <= V; k++) {
            for (int j = 1; j <= V; j++) {
                for (int i = 1; i <= V; i++) {
                    if (cost[j][k] + cost[k][i] < cost[j][i]) {
                        cost[j][i] = cost[j][k] + cost[k][i];
                    }
                }
            }
        }

        int answer = 4000000;
        for (int j = 1; j <= V; j++) {
            for (int i = 1; i <= V; i++) {
                if (j == i) {
                    answer = Math.min(answer, cost[j][i]);
                }
            }
        }

        if (answer < 4000000) {
            System.out.println(answer);
        } else {
            System.out.println(-1);
        }
        rd.close();
    }
}
