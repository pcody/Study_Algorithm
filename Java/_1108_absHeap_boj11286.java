import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

class Num1108 implements Comparable<Num1108> {
    public int num;

    public Num1108(int num) {
        this.num = num;
    }

    @Override
    public int compareTo(Num1108 o1) {
        int a = Math.abs(this.num);
        int b = Math.abs(o1.num);
        if (a != b) {
            return a - b;
        } else {
            return this.num - o1.num;
        }
    }

    @Override
    public String toString() {
        return String.valueOf(this.num);
    }
}

public class _1108_absHeap_boj11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wt = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(rd.readLine());
        PriorityQueue<Num1108> heapq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(rd.readLine());
            if (num == 0) {
                if (heapq.isEmpty()) {
                    wt.write("0\n");
                } else {
                    wt.write(heapq.poll() + "\n");
                }
            } else {
                heapq.add(new Num1108(num));
            }
        }

        wt.flush();
        wt.close();
        rd.close();
    }
}
