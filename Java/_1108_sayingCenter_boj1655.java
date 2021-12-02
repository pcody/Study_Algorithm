import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.StringBuilder;
import java.util.PriorityQueue;

class NumNOrder1108 implements Comparable<NumNOrder1108> {
    int num;

    public NumNOrder1108(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return String.valueOf(num);
    }

    @Override
    public int compareTo(NumNOrder1108 o1) {
        return this.num - o1.num;
    }
}

class NumROrder1108 implements Comparable<NumROrder1108> {
    int num;

    public NumROrder1108(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return String.valueOf(num);
    }

    @Override
    public int compareTo(NumROrder1108 o1) {
        return o1.num - this.num;
    }
}

public class _1108_sayingCenter_boj1655 {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(rd.readLine());
        PriorityQueue<NumNOrder1108> heapqN = new PriorityQueue<>();
        PriorityQueue<NumROrder1108> heapqR = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(rd.readLine());

            if ((i + 1) % 2 == 0) {
                // 짝수 번 째
                if (heapqR.peek().num < num) {
                    heapqN.add(new NumNOrder1108(num));
                } else {
                    heapqN.add(new NumNOrder1108(heapqR.poll().num));
                    heapqR.add(new NumROrder1108(num));
                }
            } else {
                // 홀수 번 째
                if (heapqR.isEmpty()) {
                    heapqR.add(new NumROrder1108(num));
                } else {
                    if (heapqN.peek().num > num) {
                        heapqR.add(new NumROrder1108(num));
                    } else {
                        heapqR.add(new NumROrder1108(heapqN.poll().num));
                        heapqN.add(new NumNOrder1108(num));
                    }
                }
            }
            // ReverseOrder 최대 힙 - 작은 수 들은 전부 최대 힙에 저장
            // NaturalOrder 최소 힙 - 큰 수 들은 전부 최소 힙에 저장
            if ((i + 1) % 2 == 1) {
                // 홀수 개 저장
                sb.append(heapqR.peek().num + "\n");
            } else {
                // 짝수 개 저장
                sb.append(Math.min(heapqR.peek().num, heapqN.peek().num) + "\n");
            }
            System.out.print(heapqN);
            System.out.println(heapqR);
        }
        System.out.print(sb);
        rd.close();
    }
}
