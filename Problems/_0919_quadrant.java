package JavaCompleted;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _0919_quadrant {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> xy = new ArrayList<Integer>();
        int answer = 0;

        while (sc.hasNextLine()) {
            String temp = sc.nextLine();
            xy.add(Integer.parseInt(temp));
        }
        int x = xy.get(0);
        int y = xy.get(1);
        if (x > 0 && y > 0) {
            answer = 1;
        } else if (x < 0 && y > 0) {
            answer = 2;
        } else if (x < 0 && y < 0) {
            answer = 3;
        } else {
            answer = 4;
        }

        System.out.println(answer);
        sc.close();
    }
}
