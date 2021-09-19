package JavaCompleted;

import java.util.Scanner;

public class _0919_plusCycle_boj1110 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int i = 0;
        Integer a, b;

        if (N < 10) {
            a = 0;
            b = N;
        } else {
            a = N / 10;
            b = N % 10;
        }

        while (true) {
            i += 1;

            int temp = a + b;
            if (temp < 10) {
                a = b;
                b = temp;
                if (N == Integer.parseInt(a.toString() + b.toString())) {
                    break;
                }
            } else {
                a = b;
                b = temp % 10;
                if (N == Integer.parseInt(a.toString() + b.toString())) {
                    break;
                }
            }
        }
        sc.close();
        System.out.println(i);
    }
}

// 55 5+5 = 10
// 50 5+0 = 5
// 05 0+5 = 5
// 55

// 0
// 00 0+0 = 0
// 00
