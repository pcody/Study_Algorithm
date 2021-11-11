import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.LinkedList;

public class _1025_card2_boj2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(rd.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = i + 1;
        }

        Queue<Integer> queue = new LinkedList<>(Arrays.stream(arr).boxed().collect(Collectors.toList()));
        int answer = 1;
        while (true) {
            answer = queue.poll();
            if (queue.size() == 0) {
                break;
            }
            queue.add(queue.poll());
        }

        System.out.println(answer);

        rd.close();
    }
}