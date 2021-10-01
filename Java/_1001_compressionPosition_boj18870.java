import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class _1001_compressionPosition_boj18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(rd.readLine());

        // 원본 리스트
        List<Integer> origList = Arrays.stream(rd.readLine().split(" ")).map(s -> Integer.parseInt(s))
                .collect(Collectors.toList());
        // 셋으로 변환하여 중복 제거
        Set<Integer> set = new HashSet<>(origList);

        // 셋을 sorting한 리스트 생성
        List<Integer> list = new ArrayList<>(set);
        list.sort(Comparator.naturalOrder());

        // 정렬된 셋으로 순서대로 숫자:인덱스 를 해시맵에 저장
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            if (!hashMap.containsKey(list.get(i))) {
                hashMap.put(list.get(i), i);
            }
        }
        for (Integer num : origList) {
            sb.append(hashMap.get(num) + " ");
        }

        System.out.println(sb);
        rd.close();
    }
}