import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class _0930_statistics_boj2108 {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(rd.readLine());
        int[] arr = new int[N];
        Map<Integer, Integer> hashMap = new HashMap<>();
        double S = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(rd.readLine());
            S += arr[i];
            if (hashMap.containsKey(arr[i])) {
                hashMap.replace(arr[i], hashMap.get(arr[i]) + 1);
            } else {
                hashMap.put(arr[i], 1);
            }
        }
        // 배열을 리스트로 만들고 오름차순 정렬
        List<Integer> list = new ArrayList<Integer>(Arrays.stream(arr).boxed().collect(Collectors.toList()));
        list.sort(Comparator.naturalOrder());

        // 최빈값을 구하기 위해 해시맵의 엔트리셋을 리스트로 만들어 키값 내림차순 정렬
        List<Entry<Integer, Integer>> entries = new LinkedList<>(hashMap.entrySet());
        // entries.sort((o1, o2) -> o1.getValue().compareTo(o2.getValue()));
        entries.sort(new Comparator1());
        List<Integer> freqList = new ArrayList<>();
        for (Entry<Integer, Integer> en : entries) {
            // System.out.println(en.getKey() + ": " + en.getValue());
            if (en.getValue().equals(entries.get(0).getValue())) {
                freqList.add(en.getKey());
            }
        }
        freqList.sort(Comparator.naturalOrder());

        // 산술평균
        System.out.println((int) Math.round(S / N));
        // 중앙값
        System.out.println(list.get(list.size() / 2));
        // 최빈값
        if (freqList.size() != 1) {
            System.out.println(freqList.get(1));
        } else {
            System.out.println(freqList.get(0));
        }
        // 범위
        System.out.println(Collections.max(list) - Collections.min(list));
        rd.close();
    }
}

class Comparator1 implements Comparator<Entry<Integer, Integer>> {

    @Override
    public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
        if (o1.getValue() > o2.getValue()) {
            return -1;
        } else if (o1.getValue() < o2.getValue()) {
            return 1;
        }
        return 0;
    }

}