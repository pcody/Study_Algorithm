package JavaCompleted;

import java.util.Scanner;

public class _0919_summation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int S = 0;

        for (int i = 1; i <= n; i++) {
            S += i;
        }

        System.out.println(S);
        sc.close();
    }
}
