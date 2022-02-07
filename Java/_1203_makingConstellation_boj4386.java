import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;

class EdgeInfo1203 implements Comparable<EdgeInfo1203> {
    public int star;
    public double distance;

    public EdgeInfo1203(int star, double distance) {
        this.star = star;
        this.distance = distance;
    }

    @Override
    public int compareTo(EdgeInfo1203 o) {
        if (distance >= o.distance) {
            return 1;
        } else {
            return -1;
        }
    }
}

public class _1203_makingConstellation_boj4386 {
    static double[][] constellation;
    static Map<Integer, List<EdgeInfo1203>> graph;
    static double answer;

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(rd.readLine());
        constellation = new double[n + 1][2];
        graph = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(rd.readLine());
            constellation[i][0] = Double.parseDouble(st.nextToken());
            constellation[i][1] = Double.parseDouble(st.nextToken());
        }

        for (int j = 1; j <= n; j++) {
            for (int i = 1; i <= n; i++) {
                if (j != i) {
                    double x = constellation[j][0] - constellation[i][0];
                    double y = constellation[j][1] - constellation[i][1];
                    graph.get(j).add(new EdgeInfo1203(i, Math.sqrt(x * x + y * y)));
                }
            }
        }
        mst(n);
        System.out.printf("%.2f", answer);
        rd.close();
    }

    public static void mst(int n) {
        PriorityQueue<EdgeInfo1203> heapq = new PriorityQueue<>();
        heapq.add(new EdgeInfo1203(1, 0));
        int[] visited = new int[n + 1];

        while (!heapq.isEmpty()) {
            EdgeInfo1203 cur = heapq.poll();

            if (visited[cur.star] == 0) {
                visited[cur.star] = 1;
                answer += cur.distance;

                for (EdgeInfo1203 next : graph.get(cur.star)) {
                    if (visited[next.star] == 0) {
                        heapq.add(new EdgeInfo1203(next.star, next.distance));
                    }
                }
            }
        }
    }
}
