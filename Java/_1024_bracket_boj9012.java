import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;
import java.lang.StringBuilder;

public class _1024_bracket_boj9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(rd.readLine());
        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            String[] brackets = rd.readLine().split("");
            for (int j = 0; j < brackets.length; j++) {
                if (brackets[j].equals(")")) {
                    if (!stack.empty() && stack.peek().equals("(")) {
                        stack.pop();
                    } else {
                        stack.push(brackets[j]);
                    }
                } else {
                    stack.push(brackets[j]);
                }
            }
            if (stack.empty()) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
                stack.clear();
            }
        }

        System.out.print(sb);
        rd.close();
    }
}