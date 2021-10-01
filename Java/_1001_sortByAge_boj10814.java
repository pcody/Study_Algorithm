import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.Map.Entry;

public class _1001_sortByAge_boj10814 {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(rd.readLine());
        Map<Integer, List<String>> hashMap = new HashMap<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(rd.readLine());
            Integer age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();

            if (hashMap.containsKey(age)) {
                hashMap.get(age).add(name);
            } else {
                List<String> nameList = new ArrayList<>();
                nameList.add(name);
                hashMap.put(age, nameList);
            }
        }

        List<Entry<Integer, List<String>>> entries = new LinkedList<>(hashMap.entrySet());
        entries.sort(new Comparator10814());
        for (Entry<Integer, List<String>> en : entries) {
            List<String> strList = en.getValue();
            // strList.sort(Comparator.reverseOrder());
            for (String name : strList) {
                System.out.println(en.getKey() + " " + name);
            }
        }
        rd.close();
    }
}

class Comparator10814 implements Comparator<Entry<Integer, List<String>>> {

    @Override
    public int compare(Entry<Integer, List<String>> o1, Entry<Integer, List<String>> o2) {
        if (o1.getKey().equals(o2.getKey())) {
            return 0;
        } else {
            return o1.getKey() > o2.getKey() ? 1 : -1;
        }
    }

}
