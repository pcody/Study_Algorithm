package JavaCompleted;

import java.util.Scanner;

public class _0919_alarmClock {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int H, M;
        H = sc.nextInt();
        M = sc.nextInt();

        if (M >= 45) {
            M -= 45;
        } else {
            if (H > 0) {
                H -= 1;
            } else {
                H = 24 + H - 1;
            }
            M = 60 + M - 45;
        }

        System.out.print(H + " " + M);
        sc.close();
    }
}