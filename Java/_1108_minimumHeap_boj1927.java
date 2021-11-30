import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.PriorityQueue;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class _1108_minimumHeap_boj1927 {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wt = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(rd.readLine());

        PriorityQueue<Integer> heapq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(rd.readLine());
            if (num == 0) {
                if (heapq.isEmpty()) {
                    wt.write("0\n");
                } else {
                    wt.write(heapq.poll() + "\n");
                }
            } else {
                heapq.add(num);
            }
        }

        wt.flush();
        wt.close();
        rd.close();
    }
}
