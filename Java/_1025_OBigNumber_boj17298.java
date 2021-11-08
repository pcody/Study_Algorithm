import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.List;
import java.util.Stack;

public class _1025_OBigNumber_boj17298 {
    static String[] answer;
    static Stack<Integer> stack;

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wt = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(rd.readLine());
        List<Integer> arr = Arrays.stream(rd.readLine().split(" ")).map(t -> Integer.parseInt(t))
                .collect(Collectors.toList());
        stack = new Stack<>();
        answer = new String[N];

        for (int i = N - 1; i >= 0; i--) {
            int cur = arr.get(i);
            while (!stack.empty() && cur >= stack.peek()) {
                stack.pop();
            }
            if (stack.empty()) {
                answer[i] = "-1";
            } else {
                answer[i] = String.valueOf(stack.peek());
            }
            stack.push(arr.get(i));
        }

        for (int i = 0; i < N; i++)
            wt.write(answer[i] + " ");

        wt.flush();
        wt.close();
        rd.close();
    }
}