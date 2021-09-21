import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class _0920_dial_boj5622 {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = i + 2;
        }
        Map<String, Integer> hashMap = new HashMap<String, Integer>();
        for (int i = 65; i < 91; i++) {
            int j = (i - 65) / 3 + 1;
            hashMap.put(Integer.toString(i), arr[j]);
        }
        hashMap.replace("83", arr[6]);
        hashMap.replace("86", arr[7]);
        hashMap.replace("89", arr[8]);
        hashMap.replace("90", arr[8]);

        // List<Entry<String, Integer>> entryList = new ArrayList<Entry<String,
        // Integer>>(hashMap.entrySet());
        // Collections.sort(entryList, new Comparator<Entry<String, Integer>>() {
        // public int compare(Entry<String, Integer> obj1, Entry<String, Integer> obj2)
        // {
        // return obj1.getKey().compareTo(obj2.getKey());
        // }
        // });

        // for (Entry<String, Integer> entry : entryList) {
        // System.out.println(entry.getKey() + "," + (char)
        // Integer.parseInt(entry.getKey()) + ":" + entry.getValue());
        // }

        int S = 0;
        while (true) {
            try {
                S += hashMap.get(Integer.toString(rd.read()));
            } catch (Exception e) {
                break;
            }
        }

        System.out.println(S);
        rd.close();
    }
}