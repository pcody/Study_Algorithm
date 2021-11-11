import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Deque;
import java.util.LinkedList;
import java.lang.StringBuilder;

public class _1026_deque_boj10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Deque<String> deque = new LinkedList<>();
        int N = Integer.parseInt(rd.readLine());

        while (N-- > 0) {
            String[] op = rd.readLine().split(" ");

            switch (op[0]) {
            case "push_back":
                deque.addLast(op[1]);
                break;
            case "push_front":
                deque.addFirst(op[1]);
                break;
            case "back":
                if (!deque.isEmpty()) {
                    sb.append(deque.peekLast() + "\n");
                } else {
                    sb.append(-1 + "\n");
                }
                break;
            case "front":
                if (!deque.isEmpty()) {
                    sb.append(deque.peekFirst() + "\n");
                } else {
                    sb.append(-1 + "\n");
                }
                break;
            case "pop_back":
                if (!deque.isEmpty()) {
                    sb.append(deque.pollLast() + "\n");
                } else {
                    sb.append(-1 + "\n");
                }
                break;
            case "pop_front":
                if (!deque.isEmpty()) {
                    sb.append(deque.pollFirst() + "\n");
                } else {
                    sb.append(-1 + "\n");
                }
                break;
            case "size":
                sb.append(deque.size() + "\n");
                break;
            case "empty":
                if (deque.isEmpty()) {
                    sb.append(1 + "\n");
                } else {
                    sb.append(0 + "\n");
                }
                break;
            }
        }

        System.out.print(sb);
        rd.close();
    }
}
