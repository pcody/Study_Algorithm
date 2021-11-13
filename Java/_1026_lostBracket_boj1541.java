import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;

public class _1026_lostBracket_boj1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String input = rd.readLine();

        System.out.println(calInput(input));
        rd.close();
    }

    public static int calInput(String str) {
        Stack<Integer> stack = new Stack<>();
        Queue<String> operators = new LinkedList<>(Arrays.stream(str.split("1|2|3|4|5|6|7|8|9|0"))
                .filter(t -> t.equals("+") || t.equals("-")).collect(Collectors.toList()));
        Queue<Integer> nums = new LinkedList<>(
                Stream.of(str.split("-|\\+")).map(t -> Integer.parseInt(t)).collect(Collectors.toList()));

        stack.push(nums.poll());
        while (!nums.isEmpty()) {
            String op = operators.poll();
            int n = nums.poll();
            if (op.equals("-")) {
                stack.push(n);
            } else {
                stack.push(stack.pop() + n);
            }
        }
        int s = 0;
        while (stack.size() != 1) {
            s -= stack.pop();
        }
        return stack.pop() + s;
    }
}
// 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14
// - + + + - - + + + - - + - + +
// a b c d e f g h i j k l m n o p
// 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15