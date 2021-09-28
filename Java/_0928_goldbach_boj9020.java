import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class _0928_goldbach_boj9020 {
    static int[] primes = new int[10001];

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(rd.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i < 10001; i++) {
            primes[i] = i;
        }
        for (int j = 2; j <= 10000; j++) {
            for (int i = j + j; i < 10001; i += j) {
                if (primes[i] != 0)
                    primes[i] = 0;
            }
        }

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(rd.readLine());
            List<Integer> arr = new ArrayList<>();
            List<List<Integer>> answer = new ArrayList<>();

            // System.out.println(isPrime(n));
            for (int j = 2; j < n; j++) {
                if (isPrime(j)) {
                    arr.add(j);
                }
            }

            for (int a : arr) {
                int b = n - a;
                if (!isPrime(b)) {
                    continue;
                }
                int[] temp = { a, b };
                if (answer.isEmpty()) {
                    answer.add(Arrays.stream(temp).boxed().collect(Collectors.toList()));
                    // List<Integer> temp = new ArrayList<>();
                    // temp.add(a);
                    // temp.add(b);
                    // answer.add(temp);
                } else {
                    int aa = answer.get(0).get(0);
                    int bb = answer.get(0).get(1);
                    if (Math.abs(aa - bb) > Math.abs(a - b)) {
                        answer.clear();
                        answer.add(Arrays.stream(temp).boxed().collect(Collectors.toList()));
                    }
                }
            }
            sb.append(answer.get(0).get(0) + " " + answer.get(0).get(1) + "\n");
        }
        System.out.println(sb);
        rd.close();
    }

    // num을 i = 2 ~ sqrt(num) 까지 나누는 방식의 소수판별 말고
    // 에라토스테네스의 체 개념 사용
    // 시간초과..
    // -> 에라토스테네스의 체를 10000개까지 해놓고 사용하면 더 빠르게 통과
    public static Boolean isPrime1(int num) {
        if (num == 1) {
            return false;
        }
        for (int i = 2; i <= (int) Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static Boolean isPrime(int num) {
        if (primes[num] == 0)
            return false;
        else
            return true;
    }
}