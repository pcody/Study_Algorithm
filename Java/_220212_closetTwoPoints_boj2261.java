import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

class Point220212 {
    int x, y;

    public Point220212(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class _220212_closetTwoPoints_boj2261 {
    static Point220212[] points;

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(rd.readLine());
        points = new Point220212[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(rd.readLine());
            points[i] = new Point220212(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(points, xComp);

        System.out.println(closet(0, n - 1));

        rd.close();
    }

    static Comparator<Point220212> xComp = new Comparator<Point220212>() {
        @Override
        public int compare(Point220212 o1, Point220212 o2) {
            return o1.x - o2.x;
        }
    };

    static Comparator<Point220212> yComp = new Comparator<Point220212>() {
        @Override
        public int compare(Point220212 o1, Point220212 o2) {
            return o1.y - o2.y;
        }
    };

    static long dist(Point220212 p1, Point220212 p2) {
        long x = (p1.x - p2.x);
        long y = (p1.y - p2.y);
        return x * x + y * y;
    }

    static long brute(int start, int end) {
        long minDist = Long.MAX_VALUE;

        for (int i = start; i < end; i++) {
            for (int j = i + 1; j <= end; j++) {
                minDist = Math.min(dist(points[i], points[j]), minDist);
            }
        }

        return minDist;
    }

    static long closet(int start, int end) {
        if (end - start + 1 < 4) {
            return brute(start, end);
        }

        int mid = (start + end) / 2;

        long left = closet(start, mid);
        long right = closet(mid + 1, end);

        long minDist = Math.min(left, right);
        long band = middleBand(start, mid, end, minDist);
        return Math.min(minDist, band);
    }

    static long middleBand(int start, int mid, int end, long minDist) {

        List<Point220212> list = new ArrayList<>();

        // 후보군 추출 - x거리를 기준으로 minDist보다 작은 거리의 좌표들만
        int midX = points[mid].x;
        long xDist;
        for (int i = start; i <= end; i++) {
            xDist = points[i].x - midX;

            if (xDist * xDist < minDist) {
                list.add(points[i]);
            }
        }

        Collections.sort(list, yComp);

        long yDist;
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                yDist = list.get(i).y - list.get(j).y;
                if (yDist * yDist < minDist) {
                    minDist = Math.min(dist(list.get(i), list.get(j)), minDist);
                } else {
                    // y좌표 기준 정렬했으므로
                    // 큰 것이 나오면 바로 탈출
                    break;
                }
            }
        }

        return minDist;
    }
}
