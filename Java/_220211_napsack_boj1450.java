import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.stream.Stream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

public class _220211_napsack_boj1450 {
    static int N, C;
    static int[] items;

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(rd.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        items = Stream.of(rd.readLine().split(" ")).mapToInt(s -> Integer.parseInt(s)).toArray();

        int[] left = Arrays.copyOfRange(items, 0, items.length / 2);
        int[] right = Arrays.copyOfRange(items, items.length / 2, items.length);

        System.out.println(solve(left, right));

        rd.close();
    }

    static int solve(int[] left, int[] right) {
        List<Integer> lList = new ArrayList<>();
        List<Integer> rList = new ArrayList<>();

        dfs(left, 0, 0, lList);
        dfs(right, 0, 0, rList);
        rList.sort(Comparator.naturalOrder());

        int answer = 0;
        for (int i = 0; i < lList.size(); i++) {
            answer += binarySearch(rList, C - lList.get(i));
        }
        return answer;
    }

    static int binarySearch(List<Integer> list, int target) {
        int l = 0;
        int r = list.size() - 1;

        while (l <= r) {
            int mid = (l + r) / 2;

            if (list.get(mid) > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return l;
    }

    static void dfs(int[] arr, int idx, int sum, List<Integer> list) {
        if (sum > C) {
            return;
        }

        if (idx == arr.length) {
            list.add(sum);
            return;
        }

        dfs(arr, idx + 1, sum, list);
        dfs(arr, idx + 1, sum + arr[idx], list);
    }
}
