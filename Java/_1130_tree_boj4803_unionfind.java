import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.StringBuilder;
import java.util.StringTokenizer;
import java.util.Set;
import java.util.HashSet;

public class _1130_tree_boj4803_unionfind {

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int tc = 0;
        while (true) {
            st = new StringTokenizer(rd.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            if (n == 0 && m == 0) {
                break;
            }

            int[] parent = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                parent[i] = i;
            }
            Set<Integer> cycleRoot = new HashSet<>();

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(rd.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                int rx = find(parent, x);
                int ry = find(parent, y);

                if (rx == ry) {
                    cycleRoot.add(rx);
                } else {
                    if (cycleRoot.contains(rx) || cycleRoot.contains(ry)) {
                        cycleRoot.add(rx);
                        cycleRoot.add(ry);
                    }
                    union(parent, x, y);
                }
            }

            Set<Integer> treeSet = new HashSet<>();
            for (int i = 1; i <= n; i++) {
                int temp = find(parent, i);
                if (!cycleRoot.contains(temp)) {
                    treeSet.add(temp);
                }
            }

            int answer = treeSet.size();
            if (answer == 0) {
                sb.append("Case " + ++tc + ": No trees.\n");
            } else if (answer == 1) {
                sb.append("Case " + ++tc + ": There is one tree.\n");
            } else {
                sb.append("Case " + ++tc + ": A forest of " + answer + " trees.\n");
            }

        }
        System.out.print(sb);
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
