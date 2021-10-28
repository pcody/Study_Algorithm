import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Map;
import java.util.HashMap;

public class _1023_fashionKing_boj9375 {
    static Map<String, Integer> hashMap;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        hashMap = new HashMap<String, Integer>();

        int T = Integer.parseInt(rd.readLine());
        for (int j = 0; j < T; j++) {
            int n = Integer.parseInt(rd.readLine());
            answer = 1;

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(rd.readLine());
                st.nextToken();
                String typeName = st.nextToken();
                if (!hashMap.containsKey(typeName)) {
                    hashMap.put(typeName, Integer.valueOf(1));
                } else {
                    hashMap.put(typeName, hashMap.get(typeName) + 1);
                }
            }
            // System.out.println(hashMap);
            hashMap.forEach((key, c) -> answer *= (c + 1));
            answer--;
            sb.append(answer + "\n");
            hashMap.clear();
        }
        System.out.print(sb);
        rd.close();
    }
}