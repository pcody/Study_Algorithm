import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Deque;

public class _1025_queue2_boj18258 {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wt = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(rd.readLine());
        Deque<String> deque = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            String[] op = rd.readLine().split(" ");
            switch (op[0]) {
            case "push":
                deque.add(op[1]);
                break;
            case "front":
                if (deque.isEmpty())
                    wt.write(-1 + "\n");
                else
                    wt.write(deque.peekFirst() + "\n");
                break;
            case "back":
                if (deque.isEmpty())
                    wt.write((-1) + "\n");
                else
                    wt.write(deque.peekLast() + "\n");
                break;
            case "size":
                wt.write(deque.size() + "\n");
                break;
            case "empty":
                if (deque.isEmpty())
                    wt.write(1 + "\n");
                else
                    wt.write(0 + "\n");
                break;
            case "pop":
                if (deque.isEmpty())
                    wt.write(-1 + "\n");
                else
                    wt.write(deque.pollFirst() + "\n");
                break;
            }
        }

        wt.flush();
        wt.close();
        rd.close();
    }
}