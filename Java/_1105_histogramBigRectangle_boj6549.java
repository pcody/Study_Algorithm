import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.lang.StringBuilder;

public class _1105_histogramBigRectangle_boj6549 {
    static long[] histogram;

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while (true) {
            st = new StringTokenizer(rd.readLine());
            int n = Integer.parseInt(st.nextToken());

            if (n == 0) {
                break;
            }

            histogram = new long[n];
            for (int i = 0; i < n; i++) {
                histogram[i] = Long.parseLong(st.nextToken());
            }

            // 투포인터로 구현하였으나 실패하였다. 테스트케이스만 맞음

            long area = getArea(0, n - 1);
            sb.append(area + "\n");
        }
        System.out.print(sb);
        rd.close();
    }

    // 분할 정복 방식으로 구현
    public static long getArea(int lo, int hi) {
        // 막대 폭이 1인 경우 높이 = 넓이 이므로 바로 반환
        if (lo == hi) {
            return histogram[lo];
        }

        // 중간지점
        int mid = (lo + hi) / 2;

        // mid를 기점으로 left side, right side 두 구간으로 나누어 큰 넓이를 저장
        long leftArea = getArea(lo, mid);
        long rightArea = getArea(mid + 1, hi);

        // 양 구간, 중간 구간을 비교하여 최대값 반환
        long max = Math.max(leftArea, rightArea);
        max = Math.max(max, getMidArea(lo, hi, mid));

        return max;
    }

    // 중간지점 영역의 넓이를 구한다
    public static long getMidArea(int lo, int hi, int mid) {
        // 각 방향으로 이동할 변수들
        int toLeft = mid;
        int toRight = mid;

        // 구간에서 최소 막대 높이
        long height = histogram[mid];

        // 구간에서 계산된 넓이, 초기 값은 mid 높이와 같다
        long maxArea = height;

        while (lo < toLeft && toRight < hi) {
            // 양쪽 다음칸 높이 중 높은 값을 선택
            // 갱신되는 height은 기존 height보다 작거나 같아야 한다
            if (histogram[toLeft - 1] < histogram[toRight + 1]) {
                toRight++;
                height = Math.min(height, histogram[toRight]);
            } else {
                toLeft--;
                height = Math.min(height, histogram[toLeft]);
            }

            maxArea = Math.max(maxArea, height * (toRight - toLeft + 1));
        }

        // 양쪽으로 탐색할 구간이 남았으면 마지막까지 탐색
        while (toRight < hi) {
            toRight++;
            height = Math.min(height, histogram[toRight]);
            maxArea = Math.max(maxArea, height * (toRight - toLeft + 1));
        }

        while (toLeft > lo) {
            toLeft--;
            height = Math.min(height, histogram[toLeft]);
            maxArea = Math.max(maxArea, height * (toRight - toLeft + 1));
        }

        return maxArea;
    }
}
