import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class _0921_groupWordChecker_boj1316 {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(rd.readLine());
        int chk = 0;
        for (int i = 0; i < N; i++) {
            String str = rd.readLine();
            Map<String, Boolean> hashMap = new HashMap<String, Boolean>();

            for (int j = 0; j < str.length(); j++) {
                char ch = str.charAt(j);
                String temp = Character.toString(ch);
                if (hashMap.get(temp) == null) {
                    hashMap.put(temp, true);
                } else {
                    if (ch != (str.charAt(j - 1))) {
                        chk += 1;
                        break;
                    }
                }
            }
        }

        System.out.println(N - chk);
        rd.close();
    }
}