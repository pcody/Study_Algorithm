import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

class Edge1203 implements Comparable<Edge1203> {
    public int v1;
    public int v2;
    public double distance;

    public Edge1203(int v1, int v2, double distance) {
        this.v1 = v1;
        this.v2 = v2;
        this.distance = distance;
    }

    @Override
    public int compareTo(Edge1203 o) {
        if (distance >= o.distance) {
            return 1;
        } else {
            return -1;
        }
    }
}

public class _1203_communionWithGod_boj1774 {
    static int N, M;
    static List<Edge1203> edges;
    static long[][] godPosition;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(rd.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }
        godPosition = new long[N + 1][2];
        edges = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(rd.readLine());
            godPosition[i][0] = Long.parseLong(st.nextToken());
            godPosition[i][1] = Long.parseLong(st.nextToken());
        }

        for (int j = 1; j <= N; j++) {
            for (int i = 1; i <= N; i++) {
                if (j != i) {
                    long x = godPosition[j][0] - godPosition[i][0];
                    long y = godPosition[j][1] - godPosition[i][1];
                    edges.add(new Edge1203(j, i, Math.sqrt(x * x + y * y)));
                }
            }
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(rd.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a, b);
        }

        Collections.sort(edges);
        System.out.printf("%.2f", (double) Math.round(mst() * 100) / 100);
        rd.close();
    }

    public static double mst() {
        double answer = 0;

        for (int i = 0; i < edges.size(); i++) {
            Edge1203 edge = edges.get(i);
            int rv1 = find(edge.v1);
            int rv2 = find(edge.v2);

            if (rv1 != rv2) {
                union(edge.v1, edge.v2);
                answer += edge.distance;
            }
        }

        return answer;
    }

    public static int find(int x) {
        if (parent[x] == x) {
            return parent[x];
        }
        parent[x] = find(parent[x]);
        return parent[x];
    }

    public static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x == y) {
            return;
        }

        parent[y] = x;
    }
}

// 4 2
// 0 0
// 0 1
// 0 2
// 0 3
// 1 4
// 2 3
// 정답: 1.00
// 출력: 2.00