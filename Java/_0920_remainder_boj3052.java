package JavaCompleted;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class _0920_remainder_boj3052 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();

        for (int i = 0; i < 10; i++) {
            st = new StringTokenizer(reader.readLine());
            int num = Integer.parseInt(st.nextToken()) % 42;

            if (hashMap.get(num) == null) {
                hashMap.put(num, 1);
            } else {
                hashMap.put(num, hashMap.get(num) + 1);
            }
        }

        System.out.println(hashMap.size());
        System.out.println(hashMap);
    }
}
