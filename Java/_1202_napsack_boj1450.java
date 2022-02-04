import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class _1202_napsack_boj1450 {
    static int N, C;
    static int[] arr;
    static List<Integer> frontList, backList;

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(rd.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(rd.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        frontList = new ArrayList<>();
        backList = new ArrayList<>();
        makeList(frontList, 0, N / 2, 0);
        makeList(backList, N / 2, N, 0);
        Collections.sort(backList);

        int result = 0;
        for (int i = 0; i < frontList.size(); i++) {
            result += binarySearch(backList, C - frontList.get(i));
        }

        System.out.println(result);

        rd.close();
    }

    public static void makeList(List<Integer> list, int idx, int end, int sum) {
        if (sum > C) {
            return;
        }
        if (idx == end) {
            list.add(sum);
            return;
        }
        makeList(list, idx + 1, end, sum + arr[idx]);
        makeList(list, idx + 1, end, sum);
    }

    public static int binarySearch(List<Integer> list, int target) {
        int left = 0;
        int right = list.size() - 1;

        int answer = -1;
        while (left <= right) {
            int mid = (left + right) / 2;

            if (target < list.get(mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
            answer = left;
        }
        return answer;
    }
}
