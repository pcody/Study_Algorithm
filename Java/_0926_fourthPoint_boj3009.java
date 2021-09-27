import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.Map.Entry;

public class _0926_fourthPoint_boj3009 {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Map<Integer, Integer> pos = new HashMap<Integer, Integer>();
        Map<Integer, Integer> xPosition = new HashMap<Integer, Integer>();
        Map<Integer, Integer> yPosition = new HashMap<Integer, Integer>();
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(rd.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (pos.containsKey(a)) {
                pos.put(a, pos.get(a) + 1);
            } else {
                pos.put(a, 1);
            }
            if (pos.containsKey(b)) {
                pos.put(b, pos.get(b) + 1);
            } else {
                pos.put(b, 1);
            }
            if (xPosition.containsKey(a)) {
                xPosition.put(a, xPosition.get(a) + 1);
            } else {
                xPosition.put(a, 1);
            }
            if (yPosition.containsKey(b)) {
                yPosition.put(b, yPosition.get(b) + 1);
            } else {
                yPosition.put(b, 1);
            }
        }
        int x = 0, y = 0;
        for (Entry<Integer, Integer> entry : xPosition.entrySet()) {
            if (entry.getValue() == 1) {
                x = entry.getKey();
            }
        }
        for (Entry<Integer, Integer> entry : yPosition.entrySet()) {
            if (entry.getValue() == 1) {
                y = entry.getKey();
            }
        }

        System.out.println(x + " " + y);
        rd.close();
    }
}

// 3,8 6,8
// 3,5 6,5