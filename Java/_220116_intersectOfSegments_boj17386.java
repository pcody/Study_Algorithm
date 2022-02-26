import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

class Point220116 {
    public long x;
    public long y;

    public Point220116(long x, long y) {
        this.x = x;
        this.y = y;
    }
}

public class _220116_intersectOfSegments_boj17386 {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Point220116 p1, p2, p3, p4;
        st = new StringTokenizer(rd.readLine());
        int[] temp = new int[4];
        for (int i = 0; i < 4; i++) {
            temp[i] = Integer.parseInt(st.nextToken());
        }
        p1 = new Point220116(temp[0], temp[1]);
        p2 = new Point220116(temp[2], temp[3]);

        st = new StringTokenizer(rd.readLine());
        for (int i = 0; i < 4; i++) {
            temp[i] = Integer.parseInt(st.nextToken());
        }
        p3 = new Point220116(temp[0], temp[1]);
        p4 = new Point220116(temp[2], temp[3]);

        if (isIntersects(p1, p2, p3, p4)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }

        rd.close();
    }

    public static boolean isIntersects(Point220116 p1, Point220116 p2, Point220116 p3, Point220116 p4) {

        if (ccw(p1, p2, p3) * ccw(p1, p2, p4) < 0) {
            if (ccw(p3, p4, p1) * ccw(p3, p4, p2) < 0) {
                return true;
            }
        }
        return false;
    }

    public static int ccw(Point220116 p1, Point220116 p2, Point220116 p3) {
        long ax = p2.x - p1.x;
        long ay = p2.y - p1.y;
        long bx = p3.x - p1.x;
        long by = p3.y - p1.y;

        if (ax * by - ay * bx < 0) {
            return -1;
        } else {
            return 1;
        }
    }
}