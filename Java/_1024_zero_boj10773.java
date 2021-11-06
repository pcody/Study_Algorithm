import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _1024_zero_boj10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(rd.readLine());
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(rd.readLine());
            if (num != 0) {
                stack.push(num);
            } else {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }
        }

        int answer = 0;
        while (!stack.isEmpty()) {
            answer += stack.pop();
        }

        System.out.println(answer);
        rd.close();
    }
}