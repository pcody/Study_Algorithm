import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Node220204 implements Comparable<Node220204> {
    int l, r;

    public Node220204(int l, int r) {
        this.l = l;
        this.r = r;
    }

    @Override
    public int compareTo(Node220204 o) {
        return l - o.l;
    }

}

public class _220204_wire_boj2565 {
    static int N;
    static List<Node220204> nodes = new ArrayList<>();
    static int[] dp = new int[100];

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(rd.readLine());
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(rd.readLine());
            nodes.add(new Node220204(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Collections.sort(nodes);
        System.out.println(N - solve());
        rd.close();
    }

    static int solve() {
        int answer = 0;

        for (int i = 0; i < N; i++) {
            int temp = 0;
            for (int j = 0; j <= i; j++) {
                if (nodes.get(j).r < nodes.get(i).r) {
                    temp = Math.max(dp[j], temp);
                }
            }
            dp[i] = temp + 1;
            answer = Math.max(dp[i], answer);
        }
        return answer;
    }
}
