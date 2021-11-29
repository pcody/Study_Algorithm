import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.PriorityQueue;
import java.lang.StringBuilder;

class Num1107 implements Comparable<Num1107> {
    int num;

    public Num1107(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return String.valueOf(this.num);
    }

    @Override
    public int compareTo(Num1107 o1) {
        return o1.num - this.num;
    }
}

public class _1107_maximumHeap_boj11279 {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(rd.readLine());
        PriorityQueue<Num1107> heapq = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(rd.readLine());
            if (num != 0) {
                heapq.add(new Num1107(num));
            } else {
                if (heapq.isEmpty()) {
                    sb.append(0 + "\n");
                } else {
                    sb.append(heapq.poll() + "\n");
                }
            }
        }
        System.out.print(sb);
        rd.close();
    }
}
