import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Point220107 {
    public long x;
    public long y;

    public Point220107(long x, long y) {
        this.x = x;
        this.y = y;
    }
}

public class _220107_ccw_boj11758 {
    static List<Point220107> list;

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        list = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(rd.readLine());
            Long x = Long.parseLong(st.nextToken());
            Long y = Long.parseLong(st.nextToken());
            list.add(new Point220107(x, y));
        }

        long cp = ccw(list.get(0), list.get(1), list.get(2));
        if (cp == 0) {
            System.out.println(0);
        } else if (cp < 0) {
            System.out.println(-1);
        } else {
            System.out.println(1);
        }

        rd.close();
    }

    public static long ccw(Point220107 p1, Point220107 p2, Point220107 p3) {
        long ax = p2.x - p1.x;
        long ay = p2.y - p1.y;
        long bx = p3.x - p1.x;
        long by = p3.y - p1.y;
        return ax * by - ay * bx;
    }
}
