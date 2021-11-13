import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class _1026_coin0_boj11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(rd.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] values = new int[N];
        int coins = 0;
        for (int i = 0; i < N; i++) {
            values[i] = Integer.parseInt(rd.readLine());
        }
        Arrays.sort(values);

        while (K > 0) {
            int c = values[binarySearch(values, K)];
            coins += K / c;
            K %= c;
        }

        System.out.println(coins);
        rd.close();
    }

    // target보다 같거나 작은 수 중 최대값의 인덱스 리턴
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int answer = -1;
        while (left <= right) {
            int mid = (left + right) / 2;

            if (target < arr[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }

            answer = right;
        }
        return answer;
    }
}
