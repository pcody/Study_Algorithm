package JavaCompleted;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _1008_putOperator_boj14888 {
    static int maxRes = Integer.MIN_VALUE;
    static int minRes = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(rd.readLine());
        List<Integer> num = new ArrayList<>();
        st = new StringTokenizer(rd.readLine());
        for (int i = 0; i < N; i++) {
            num.add(Integer.parseInt(st.nextToken()));
        }
        int[] op = new int[4];
        st = new StringTokenizer(rd.readLine());
        for (int i = 0; i < 4; i++) {
            op[i] = Integer.parseInt(st.nextToken());
        }

        // System.out.println(num);
        // System.out.println(Arrays.stream(op).boxed().collect(Collectors.toList()));

        List<Integer> res = new ArrayList<>();
        putOp(num, N - 1, res, op);
        System.out.print(maxRes + "\n" + minRes);
        rd.close();
    }

    public static void cal(List<Integer> num, int N, List<Integer> ret) {
        int s = num.get(0);
        for (int i = 1; i < N; i++) {
            switch (ret.get(i - 1)) {
                case 0:
                    s += num.get(i);
                    break;
                case 1:
                    s -= num.get(i);
                    break;
                case 2:
                    s *= num.get(i);
                    break;
                case 3:
                    s /= num.get(i);
            }
        }
        // System.out.print(s);
        maxRes = Integer.max(maxRes, s);
        minRes = Integer.min(minRes, s);
    }

    public static void putOp(List<Integer> num, int n, List<Integer> ret, int[] op) {

        if (ret.size() >= n) {
            // System.out.print(ret);
            cal(num, n + 1, ret);
            // System.out.println();
        }

        for (int i = 0; i < 4; i++) {
            if (op[i] > 0) {
                op[i] -= 1;
                ret.add(i);
                putOp(num, n, ret, op);
                ret.remove(ret.size() - 1);
                op[i] += 1;
            }
        }
    }
}
