import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _1001_sortWord_boj1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(rd.readLine());
        Map<Integer, List<String>> hashMap = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String str = rd.readLine();
            if (hashMap.containsKey(str.length())) {
                if (!hashMap.get(str.length()).contains(str)) {
                    hashMap.get(str.length()).add(str);
                }
            } else {
                List<String> temp = new ArrayList<>();
                temp.add(str);
                hashMap.put(str.length(), temp);
            }
        }

        for (int i = 1; i <= 50; i++) {
            if (hashMap.containsKey(i)) {
                List<String> temp = hashMap.get(i);
                temp.sort(Comparator.naturalOrder());
                for (String s : temp) {
                    System.out.println(s);
                }
            }
        }

        rd.close();
    }
}