import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.StringBuilder;
import java.util.Stack;

public class _1024_stackSequence_boj1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(rd.readLine());
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        int maxNum = 0;
        boolean flag = true;
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(rd.readLine());
            if (maxNum < num) {
                for (int j = maxNum + 1; j <= num; j++) {
                    stack.push(j);
                    sb.append("+\n");
                }
                sb.append("-\n");
                stack.pop();
                maxNum = num;
            } else {
                if (stack.peek().equals(num)) {
                    sb.append("-\n");
                    stack.pop();
                } else {
                    flag = false;
                    break;
                }
            }
        }

        if (flag) {
            System.out.println(sb);
        } else {
            System.out.println("NO");
        }
        rd.close();
    }
}