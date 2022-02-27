import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

class Point220123 {
    public long x;
    public long y;

    public Point220123(long x, long y) {
        this.x = x;
        this.y = y;
    }
}

public class _220123_intersectOfSegments_boj17387 {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        Point220123 p1, p2, p3, p4;

        int[] temp = Arrays.stream(rd.readLine().split(" ")).mapToInt(s -> Integer.parseInt(s)).toArray();
        p1 = new Point220123(temp[0], temp[1]);
        p2 = new Point220123(temp[2], temp[3]);

        temp = Arrays.stream(rd.readLine().split(" ")).mapToInt(s -> Integer.parseInt(s)).toArray();
        p3 = new Point220123(temp[0], temp[1]);
        p4 = new Point220123(temp[2], temp[3]);

        if (isIntersect(p1, p2, p3, p4)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }

        rd.close();
    }

    public static boolean isIntersect(Point220123 p1, Point220123 p2, Point220123 p3, Point220123 p4) {
        int a = ccw(p1, p2, p3);
        int b = ccw(p1, p2, p4);
        int c = ccw(p3, p4, p1);
        int d = ccw(p3, p4, p2);

        if (a * b <= 0 && c * d <= 0) {
            if (a * b == 0 && c * d == 0) {
                if ((Math.max(p1.x, p2.x) >= Math.min(p3.x, p4.x) &&
                        Math.max(p3.x, p4.x) >= Math.min(p1.x, p2.x))
                        &&
                        (Math.max(p1.y, p2.y) >= Math.min(p3.y, p4.y)
                                && Math.max(p3.y, p4.y) >= Math.min(p1.y, p2.y))) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    public static int ccw(Point220123 p1, Point220123 p2, Point220123 p3) {
        long ax = p2.x - p1.x;
        long ay = p2.y - p1.y;
        long bx = p3.x - p1.x;
        long by = p3.y - p1.y;
        long cal = ax * by - ay * bx;
        if (cal < 0) {
            return -1;
        } else if (cal == 0) {
            return 0;
        } else {
            return 1;
        }
    }
}
