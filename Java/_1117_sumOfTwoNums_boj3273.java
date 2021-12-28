import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.stream.Stream;
import java.util.Arrays;

public class _1117_sumOfTwoNums_boj3273 {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(rd.readLine());
        int[] arr = Stream.of(rd.readLine().split(" ")).mapToInt(t -> Integer.parseInt(t)).toArray();
        int X = Integer.parseInt(rd.readLine());
        int answer = 0;

        Arrays.sort(arr);
        int front = 0;
        int last = front + 1;

        while (front < N - 1) {
            if (last < N) {
                int temp = arr[front] + arr[last];
                if (temp < X) {
                    last++;
                } else if (temp == X) {
                    answer++;
                    front++;
                    last = front + 1;
                } else {
                    front++;
                    last = front + 1;
                }
            } else {
                front++;
                last = front + 1;
            }
        }

        System.out.println(answer);
        rd.close();
    }
}
