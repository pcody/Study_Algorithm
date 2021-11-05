import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;
import java.lang.StringBuilder;

public class _1024_balancedWorld_boj4949 {
    static Stack<String> stack;

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        while (true) {
            String[] str = rd.readLine().split("");
            if (str[0].equals(".")) {
                break;
            }
            for (int i = 0; i < str.length; i++) {
                if (str[i].equals("(") || str[i].equals(")") || str[i].equals("[") || str[i].equals("]")) {
                    if (str[i].equals("(") || str[i].equals("[")) {
                        stack.push(str[i]);
                    } else {
                        if (stack.empty()) {
                            stack.push(str[i]);
                        } else {
                            if (str[i].equals(")") && stack.peek().equals("(")) {
                                stack.pop();
                            } else if (str[i].equals("]") && stack.peek().equals("[")) {
                                stack.pop();
                            } else {
                                stack.push(str[i]);
                            }
                        }
                    }
                }
            }
            if (stack.empty()) {
                sb.append("yes\n");
            } else {
                sb.append("no\n");
                stack.clear();
            }
        }
        System.out.print(sb);
        rd.close();
    }
}