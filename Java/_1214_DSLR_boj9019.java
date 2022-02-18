import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;
import java.lang.StringBuilder;
import java.util.Map;
import java.util.HashMap;

class Register1214 {
    public int digit;

    public Register1214(int digit) {
        this.digit = digit;
    }

    public int getDigit() {
        return digit;
    }

    public int doubling() {
        return getDigit() * 2 % 10000;
    }

    public int subtract() {
        int temp = getDigit() - 1;
        if (temp < 0) {
            return 9999;
        } else {
            return temp;
        }
    }

    public int left() {
        int temp1 = digit * 10 % 10000;
        int temp2 = digit / 1000;
        return temp1 + temp2;
    }

    public int right() {
        int temp1 = digit % 10 * 1000;
        int temp2 = digit / 10;
        return temp1 + temp2;
    }
}

public class _1214_DSLR_boj9019 {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(rd.readLine());

        while (T-- > 0) {
            st = new StringTokenizer(rd.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            sb.append(solve(A, B) + "\n");
        }

        System.out.print(sb);
        rd.close();
    }

    public static String solve(int input, int output) {
        Queue<Register1214> queue = new LinkedList<>();
        queue.add(new Register1214(input));
        StringBuilder answer = new StringBuilder();
        int[] parent = new int[10001];
        Map<Integer, String> path = new HashMap<>();
        int[] visited = new int[10001];
        visited[input] = 1;

        while (!queue.isEmpty()) {
            Register1214 cur = queue.poll();
            int curDigit = cur.getDigit();

            if (curDigit == output) {
                break;
            }

            int temp;
            temp = cur.doubling();
            if (visited[temp] == 0) {
                visited[temp] = 1;
                queue.add(new Register1214(temp));
                parent[temp] = curDigit;
                path.put(temp, "D");
            }

            temp = cur.subtract();
            if (visited[temp] == 0) {
                visited[temp] = 1;
                queue.add(new Register1214(temp));
                parent[temp] = curDigit;
                path.put(temp, "S");
            }

            temp = cur.left();
            if (visited[temp] == 0) {
                visited[temp] = 1;
                queue.add(new Register1214(temp));
                parent[temp] = curDigit;
                path.put(temp, "L");
            }

            temp = cur.right();
            if (visited[temp] == 0) {
                visited[temp] = 1;
                queue.add(new Register1214(temp));
                parent[temp] = curDigit;
                path.put(temp, "R");
            }
        }

        int idx = output;
        while (idx != input) {
            answer.insert(0, path.get(idx));
            idx = parent[idx];
        }
        return answer.toString();
    }
}