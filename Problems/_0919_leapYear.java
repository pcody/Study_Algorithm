package JavaCompleted;

import java.util.Scanner;

public class _0919_leapYear {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int year = Integer.parseInt(sc.nextLine());
        int isLeap = 0;

        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            isLeap = 1;
        }

        System.out.println(isLeap);
    }
}