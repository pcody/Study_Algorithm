package JavaCompleted;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.Map.Entry;

public class _0920_wordStudy_boj1157 {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(rd.readLine());
        String[] strArr = st.nextToken().split("");

        Map<String, Integer> hashMap = new HashMap<String, Integer>();

        // 해시맵에 개수를 +1
        for (int i = 0; i < strArr.length; i++) {
            String temp = strArr[i].toLowerCase();
            if (hashMap.get(temp) == null) {
                hashMap.put(temp, 1);
            } else {
                hashMap.replace(temp, hashMap.get(temp) + 1);
            }
        }

        // Entry를 만들어서 맥스 set(key:value)를 구함
        Entry<String, Integer> maxEntry = null;
        for (Entry<String, Integer> entrySet : hashMap.entrySet()) {
            if (maxEntry == null || entrySet.getValue() > maxEntry.getValue()) {
                maxEntry = entrySet;
            }
        }

        // 해시맵 값으로 list를 만들고 maxEntry와 중복된 값이 있는지 체크
        List<Integer> dupChk = new ArrayList<>(hashMap.values());
        int chk = Collections.frequency(dupChk, maxEntry.getValue());
        if (chk <= 1) {
            // 중복 개수가 1개 이하 -> 대문자로 바꿔서 출력
            System.out.println(maxEntry.getKey().toUpperCase());
        } else {
            // 중복 개수가 1개 초과 -> ? 출력
            System.out.println("?");
        }
    }
}