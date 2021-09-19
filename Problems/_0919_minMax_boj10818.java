package JavaCompleted;

import java.util.Scanner;

public class _0919_minMax_boj10818 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        String[] temp = sc.nextLine().split(" ");
        int minNum = 1000000;
        int maxNum = -1000000;

        for (int i = 0; i < temp.length; i++) {
            int a = Integer.parseInt(temp[i]);
            minNum = Math.min(minNum, a);
            maxNum = Math.max(maxNum, a);
        }

        System.out.println(minNum + " " + maxNum);
    }
}
