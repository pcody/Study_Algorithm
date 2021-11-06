import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.StringBuilder;
import java.util.Stack;

public class _1024_stack_boj10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(rd.readLine());
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            String[] op = rd.readLine().split(" ");
            switch (op[0]) {
            case "push":
                stack.push(op[1]);
                break;
            case "top":
                if (stack.isEmpty()) {
                    sb.append(-1 + "\n");
                } else {
                    sb.append(stack.peek() + "\n");
                }
                break;
            case "size":
                sb.append(stack.size() + "\n");
                break;
            case "empty":
                if (stack.isEmpty()) {
                    sb.append(1 + "\n");
                } else {
                    sb.append(0 + "\n");
                }
                break;
            case "pop":
                if (stack.isEmpty()) {
                    sb.append(-1 + "\n");
                } else {
                    sb.append(stack.pop() + "\n");
                }
                break;
            }
        }
        System.out.print(sb);
        rd.close();
    }
}