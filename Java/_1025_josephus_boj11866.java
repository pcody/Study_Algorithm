import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class _1025_josephus_boj11866 {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(rd.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        int s = queue.size();
        int[] answer = new int[N];
        while (!queue.isEmpty()) {
            for (int i = 1; i < K; i++) {
                queue.add(queue.poll());
            }
            answer[N - s--] = queue.poll();
        }

        System.out.print("<");
        for (int i = 0; i < N; i++) {
            System.out.print(answer[i]);
            if (i != N - 1) {
                System.out.print(", ");
            }
        }
        System.out.print(">");
        rd.close();
    }
}