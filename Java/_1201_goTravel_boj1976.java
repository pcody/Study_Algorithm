import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class _1201_goTravel_boj1976 {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(rd.readLine());
        Integer.parseInt(rd.readLine());
        int[] parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        for (int j = 1; j <= N; j++) {
            st = new StringTokenizer(rd.readLine());
            for (int i = 1; i <= N; i++) {
                int op = Integer.parseInt(st.nextToken());
                if (op == 1) {
                    union(parent, j, i);
                }
            }
        }

        int[] plan = Arrays.stream(rd.readLine().split(" ")).mapToInt(t -> Integer.parseInt(t)).toArray();
        boolean flag = true;
        for (int i = 1; i < plan.length; i++) {
            int rpre = find(parent, plan[i - 1]);
            int rcur = find(parent, plan[i]);

            if (rpre != rcur) {
                flag = !flag;
                break;
            }
        }

        if (flag) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

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
