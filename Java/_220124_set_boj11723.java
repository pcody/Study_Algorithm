import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.StringBuilder;

public class _220124_set_boj11723 {
    static boolean[] arr = new boolean[21];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(rd.readLine());

        for (int i = 0; i < M; i++) {
            String[] op = rd.readLine().split(" ");
            int idx = 0;
            switch (op[0]) {
                case "add":
                    idx = Integer.parseInt(op[1]);
                    add(idx);
                    break;
                case "check":
                    idx = Integer.parseInt(op[1]);
                    check(idx);
                    break;
                case "remove":
                    idx = Integer.parseInt(op[1]);
                    remove(idx);
                    break;
                case "toggle":
                    idx = Integer.parseInt(op[1]);
                    toggle(idx);
                    break;
                case "all":
                    all();
                    break;
                case "empty":
                    empty();
                    break;
            }
        }

        System.out.println(sb);
        rd.close();
    }

    public static void add(int idx) {
        arr[idx] = true;
    }

    public static void check(int idx) {
        if (arr[idx]) {
            sb.append(1 + "\n");
        } else {
            sb.append(0 + "\n");
        }
    }

    public static void remove(int idx) {
        arr[idx] = false;
    }

    public static void toggle(int idx) {
        arr[idx] = !arr[idx];
    }

    public static void all() {
        for (int i = 1; i <= 20; i++) {
            arr[i] = true;
        }
    }

    public static void empty() {
        arr = new boolean[21];
    }
}
