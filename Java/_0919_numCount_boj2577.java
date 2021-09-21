package JavaCompleted;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class _0919_numCount_boj2577 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a, b, c;
        a = Integer.parseInt(reader.readLine());
        b = Integer.parseInt(reader.readLine());
        c = Integer.parseInt(reader.readLine());

        Map<Integer, Integer> chk = new HashMap<Integer, Integer>();
        for (int i = 0; i < 10; i++) {
            chk.put(i, 0);
        }
        String str = Integer.toString(a * b * c);
        for (int i = 0; i < str.length(); i++) {
            int key = Integer.parseInt(Character.toString(str.charAt(i)));
            chk.put(key, chk.get(key) + 1);
        }
        for (Entry<Integer, Integer> entrySet : chk.entrySet()) {
            System.out.println(entrySet.getValue());
            // System.out.println(entrySet.getKey() + " : " + entrySet.getValue());
        }
    }
}
