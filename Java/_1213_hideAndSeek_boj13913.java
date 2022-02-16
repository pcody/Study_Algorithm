import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;
import java.lang.StringBuilder;
import java.util.Stack;

class Node1213 {
    public int position;
    public int time;

    public Node1213(int position, int time) {
        this.position = position;
        this.time = time;
    }
}

public class _1213_hideAndSeek_boj13913 {
    static int N, K;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(rd.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        System.out.println(solve());

        Stack<Integer> stack = new Stack<>();
        int idx = K;
        while (idx != N) {
            stack.add(idx);
            idx = parent[idx];
        }
        stack.add(idx);
        while (!stack.isEmpty()) {
            sb.append(stack.pop() + " ");
        }
        System.out.println(sb);

        rd.close();
    }

    public static int solve() {
        int cnt = 0;
        int[] visited = new int[100001];
        for (int i = 0; i < 100001; i++) {
            visited[i] = -1;
        }
        visited[N] = 1;
        parent = new int[100001];
        parent[N] = -1;
        Queue<Node1213> queue = new LinkedList<>();
        queue.add(new Node1213(N, 0));

        while (true) {
            Node1213 cur = queue.poll();
            int curPosition = cur.position;
            int curTime = cur.time;

            if (curPosition == K) {
                cnt = curTime;
                break;
            }

            // -1로 초기화한 visited를 사용하지 않고
            // parent를 바로 사용했을 때
            // parent[0] parent[1] parent[2] 에서 무한루프 발생함..
            if (curPosition - 1 >= 0 && visited[curPosition - 1] == -1) {
                queue.add(new Node1213(curPosition - 1, curTime + 1));
                parent[curPosition - 1] = curPosition;
                visited[curPosition - 1] = 1;
            }

            if (curPosition + 1 <= 100000 && visited[curPosition + 1] == -1) {
                queue.add(new Node1213(curPosition + 1, curTime + 1));
                parent[curPosition + 1] = curPosition;
                visited[curPosition + 1] = 1;
            }

            if (curPosition * 2 <= 100000 && visited[curPosition * 2] == -1) {
                queue.add(new Node1213(curPosition * 2, curTime + 1));
                parent[curPosition * 2] = curPosition;
                visited[curPosition * 2] = 1;
            }
        }

        return cnt;
    }
}
