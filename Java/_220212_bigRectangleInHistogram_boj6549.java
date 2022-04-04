import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.StringBuilder;

public class _220212_bigRectangleInHistogram_boj6549 {
    static int n;
    static int[] heights;

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String[] input = rd.readLine().split(" ");
            n = Integer.parseInt(input[0]);

            if (n == 0) {
                break;
            }

            heights = new int[n];
            for (int i = 0; i < n; i++) {
                heights[i] = Integer.parseInt(input[i + 1]);
            }

            sb.append(getArea(0, n - 1) + "\n");
        }

        System.out.print(sb);
        rd.close();
    }

    static long getArea(int lo, int hi) {
        if (lo == hi) {
            return heights[lo];
        }

        int mid = (lo + hi) / 2;

        // 반으로 쪼개서 최대 넓이를 구한다
        long leftArea = getArea(lo, mid);
        long rightArea = getArea(mid + 1, hi);
        long max = Math.max(leftArea, rightArea);

        // 분할하여 구한 최대 넓이가 전체 구간에서 최대라는 보장이 없으므로
        // 중앙에서 부터 최대 넓이를 다시 구한다
        max = Math.max(getMidArea(lo, hi, mid), max);

        return max;
    }

    static long getMidArea(int lo, int hi, int mid) {
        // 중간 부터 각 방향으로 갈 인덱스 변수
        int toLeft = mid;
        int toRight = mid;

        // 높이
        long height = heights[mid];

        // 넓이
        long maxArea = height;

        // 양 끝 벗어나기 전까지 반복
        while (lo < toLeft && toRight < hi) {
            if (heights[toLeft - 1] < heights[toRight + 1]) {
                toRight++;
                height = Math.min(heights[toRight], height);
            } else {
                toLeft--;
                height = Math.min(heights[toLeft], height);
            }
            // 넓이 갱신
            maxArea = Math.max(maxArea, height * (toRight - toLeft + 1));
        }

        while (toRight < hi) {
            toRight++;
            height = Math.min(heights[toRight], height);
            maxArea = Math.max(maxArea, height * (toRight - toLeft + 1));
        }

        while (lo < toLeft) {
            toLeft--;
            height = Math.min(heights[toLeft], height);
            maxArea = Math.max(maxArea, height * (toRight - toLeft + 1));
        }

        return maxArea;
    }
}
