package JavaCompleted;

import java.util.Scanner;

public class _0919_AplusB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String a = sc.nextLine();
        String[] b = a.split(" ");
        int answer = 0;
        for (int i = 0; i < b.length; i++) {
            // System.out.println(b[i]);
            answer += Integer.parseInt(b[i]);
        }
        System.out.println(answer);
    }
}
