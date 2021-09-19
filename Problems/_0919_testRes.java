package JavaCompleted;

import java.util.Scanner;

public class _0919_testRes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int num = Integer.parseInt(str);

        if (num >= 90) {
            System.out.println("A");
        } else if (num >= 80) {
            System.out.println("B");
        } else if (num >= 70) {
            System.out.println("C");
        } else if (num >= 60) {
            System.out.println("D");
        } else {
            System.out.println("F");
        }
    }
}
