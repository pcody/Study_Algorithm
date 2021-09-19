package JavaCompleted;

import java.util.Scanner;

public class _0919_fourOperation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] temp = str.split(" ");
        int a, b;
        a = Integer.parseInt(temp[0]);
        b = Integer.parseInt(temp[1]);

        System.out.println(a + b);
        System.out.println(a - b);
        System.out.println(a * b);
        System.out.println(a / b);
        System.out.println(a % b);
    }
}
