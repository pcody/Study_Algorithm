package JavaCompleted;

import java.util.HashMap;
import java.util.Map;

public class _0920_selfNum_boj4673 {
    public static void main(String[] args) {
        Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        makeHashMap(hashMap);
        fillHashMap(hashMap);
        // System.out.println(makeNum(129));
        for (int i = 1; i <= 10000; i++) {
            int selfNum = hashMap.get(i);
            if (selfNum == 0) {
                System.out.println(i);
            }
        }
    }

    public static void makeHashMap(Map<Integer, Integer> hashMap) {
        for (int i = 1; i <= 10000; i++) {
            hashMap.put(i, 0);
        }
    }

    public static void fillHashMap(Map<Integer, Integer> hashMap) {
        for (int i = 1; i <= 10000; i++) {
            int j = makeNum(i);
            if (hashMap.get(j) == null) {
                continue;
            }
            hashMap.replace(j, hashMap.get(j) + 1);
            while (j <= 10000) {
                j = makeNum(j);
                if (j == 9997) {
                    System.out.println("9997..?");
                }
                if (hashMap.get(j) == null) {
                    break;
                }
                hashMap.replace(j, hashMap.get(j) + 1);
            }
        }
    }

    public static int makeNum(int X) {
        int S = X;
        while (X >= 10) {
            S += X % 10;
            X /= 10;
        }
        S += X;
        return S;
    }
}

// 1 <= a, b < 10
// 10 * a + b + a + b = 11a + 2b = x