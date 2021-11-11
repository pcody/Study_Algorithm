import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Deque;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.List;

public class _1026_rotatingQueue_boj1021 {
    static Deque<Integer> deque;
    static int left;
    static int right;

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(rd.readLine());
        int N = Integer.parseInt(st.nextToken());
        Integer.parseInt(st.nextToken());
        Queue<Integer> target = new LinkedList<>(
                Arrays.stream(rd.readLine().split(" ")).map(t -> Integer.parseInt(t)).collect(Collectors.toList()));
        deque = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            deque.add(i);
        }

        while (!target.isEmpty()) {
            int t = target.poll().intValue();
            List<Integer> temp = new LinkedList<>(deque);
            int l = temp.indexOf(t);
            int r = N-- - l;
            if (l > r) {
                while (r-- > 0)
                    rightFunction();
            } else {
                while (l-- > 0)
                    leftFunction();
            }
            deque.pop();
        }
        System.out.println(left + right);
        rd.close();
    }

    static void leftFunction() {
        if (!deque.isEmpty()) {
            left++;
            deque.add(deque.poll());
        }
    }

    static void rightFunction() {
        if (!deque.isEmpty()) {
            right++;
            deque.addFirst(deque.pollLast());
        }
    }
}
