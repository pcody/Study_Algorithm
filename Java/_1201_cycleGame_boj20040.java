import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class _1201_cycleGame_boj20040 {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(rd.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        int answer = 0;
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(rd.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (answer == 0) {
                int ra = find(parent, a);
                int rb = find(parent, b);

                if (ra == rb) {
                    answer = i;
                } else {
                    union(parent, a, b);
                }
            }
        }

        System.out.println(answer);
        rd.close();
    }

    public static int find(int[] parent, int x) {
        if (parent[x] == x) {
            return x;
        }

        parent[x] = find(parent, parent[x]);
        return parent[x];
    }

    public static void union(int[] parent, int x, int y) {
        x = find(parent, x);
        y = find(parent, y);

        if (x == y) {
            return;
        }

        parent[y] = x;
    }
}
