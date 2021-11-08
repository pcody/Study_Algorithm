import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.StringBuilder;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.Collections;

public class _1025_printerQueue_boj1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(rd.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(rd.readLine());
            Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            Queue<Integer> queue = new LinkedList<>(
                    Arrays.stream(rd.readLine().split(" ")).map(n -> Integer.parseInt(n)).collect(Collectors.toList()));

            int order = 0;
            while (M != -1) {
                int max = Collections.max(queue);
                int p = queue.poll();
                M--;
                if (p == max) {
                    order++;
                } else {
                    queue.add(p);
                    if (M == -1) {
                        M = queue.size() - 1;
                    }
                }
            }
            sb.append(order + "\n");
        }

        System.out.print(sb);
        rd.close();
    }
}