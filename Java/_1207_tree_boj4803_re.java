import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.lang.StringBuilder;
import java.util.HashSet;
import java.util.Set;

public class _1207_tree_boj4803_re {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

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

            Set<Integer> noTree = new HashSet<>();
            for (int i = 1; i <= m; i++) {
                st = new StringTokenizer(rd.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                int ra = find(parent, a);
                int rb = find(parent, b);

                if (ra == rb) {
                    noTree.add(ra);
                    noTree.add(rb);
                } else {
                    if (noTree.contains(ra) || noTree.contains(rb)) {
                        noTree.add(ra);
                        noTree.add(rb);
                    }
                    union(parent, a, b);
                }
            }

            int answer = 0;
            Set<Integer> answerSet = new HashSet<>();
            for (int i = 1; i <= n; i++) {
                int temp = find(parent, i);
                if (!noTree.contains(temp)) {
                    answerSet.add(temp);
                }
            }
            answer = answerSet.size();

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
            return parent[x];
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
