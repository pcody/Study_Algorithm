import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.stream.Stream;
import java.util.stream.Collectors;
import java.util.List;
import java.util.Arrays;
import java.lang.StringBuilder;
import java.util.Collections;

public class _1107_numberCard2_boj10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        rd.readLine();
        List<Integer> list = Stream.of(rd.readLine().split(" ")).map(t -> Integer.parseInt(t))
                .collect(Collectors.toList());
        rd.readLine();
        List<Integer> nums = Arrays.stream(rd.readLine().split(" ")).map(t -> Integer.parseInt(t))
                .collect(Collectors.toList());
        Collections.sort(list);
        // System.out.println(list);
        StringBuilder sb = new StringBuilder();
        for (Integer num : nums) {
            int upLimit = findUpLimit(list, num);
            int lowLimit = findLowLimit(list, num);
            // System.out.println("상한:" + upLimit + " 하한:" + lowLimit);
            sb.append((upLimit - lowLimit - 1) + " ");
        }

        System.out.println(sb);
        rd.close();
    }

    public static int findUpLimit(List<Integer> list, int target) {
        int left = 0;
        int right = list.size() - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (target < list.get(mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        int ret = left;
        return ret;
    }

    public static int findLowLimit(List<Integer> list, int target) {
        int left = 0;
        int right = list.size() - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (list.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        int ret = right;
        return ret;
    }
}