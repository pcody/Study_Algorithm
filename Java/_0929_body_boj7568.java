import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _0929_body_boj7568 {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(rd.readLine());

        Map<Integer, List<Integer>> hashMap = new HashMap<>();
        for (int i = 1; i < N + 1; i++) {
            String[] strArr = rd.readLine().split(" ");
            List<Integer> temp = new ArrayList<>();
            temp.add(Integer.parseInt(strArr[0]));
            temp.add(Integer.parseInt(strArr[1]));
            hashMap.put(i, temp);
        }
        int[] answer = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            List<Integer> tempI = hashMap.get(i);
            for (int j = 1; j < N + 1; j++) {
                if (i == j) {
                    continue;
                }
                List<Integer> tempJ = hashMap.get(j);
                if (tempI.get(0) < tempJ.get(0) && tempI.get(1) < tempJ.get(1)) {
                    answer[i] += 1;
                }
            }
        }

        for (int i = 1; i < N + 1; i++) {
            System.out.print((answer[i] + 1) + " ");
        }

        rd.close();
    }
}