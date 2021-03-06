import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Point1105 implements Comparable<Point1105> {
    public int x;
    public int y;

    public Point1105(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point1105 o1) {
        return this.x - o1.x;
    }
}

public class _1105_closetTwoPoints_boj2261 {
    static Point1105[] positions;

    public static Comparator<Point1105> Ycomp = new Comparator<Point1105>() {

        @Override
        public int compare(Point1105 o1, Point1105 o2) {
            return o1.y - o2.y;
        }

    };

    public static Comparator<Point1105> Xcomp = new Comparator<Point1105>() {

        @Override
        public int compare(Point1105 o1, Point1105 o2) {
            return o1.x - o2.x;
        }

    };

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(rd.readLine());
        positions = new Point1105[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(rd.readLine());
            positions[i] = new Point1105(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(positions, Xcomp);

        System.out.println(closet(0, n - 1));
        rd.close();
    }

    public static int getDistance(Point1105 o1, Point1105 o2) {
        int a = o1.x - o2.x;
        int b = o1.y - o2.y;
        return a * a + b * b;
    }

    public static int brute(int start, int end) {
        int minDistance = Integer.MAX_VALUE;

        for (int j = start; j < end - 1; j++) {
            for (int i = j + 1; i < end; i++) {
                minDistance = Math.min(minDistance, getDistance(positions[j], positions[i]));
            }
        }

        return minDistance;
    }

    public static int closet(int start, int end) {
        // ????????? 3??? ???????????? ?????????????????? ?????? ??????
        if (end - start + 1 < 4) {
            return brute(start, end);
        }

        int mid = (start + end) / 2;

        int left = closet(start, mid);
        int right = closet(mid + 1, end);

        int minDistance = Math.min(left, right);
        int band = middleBand(start, mid, end, minDistance);
        return Math.min(minDistance, band);
    }

    static int middleBand(int start, int mid, int end, int minDistance) {
        int xDistance;

        List<Point1105> list = new ArrayList<Point1105>();

        int midX = positions[mid].x;
        for (int i = start; i <= end; i++) {
            xDistance = positions[i].x - midX;

            // ?????? ????????? ????????? midX ?????? ?????? ??????
            // minDistance ?????? ????????? list??? ?????????
            if (xDistance * xDistance < minDistance) {
                list.add(positions[i]);
            }
        }

        Collections.sort(list, Ycomp);

        int yDistance;
        for (int j = 0; j < list.size() - 1; j++) {
            for (int i = j + 1; i < list.size(); i++) {
                // x?????? ??? ????????? ??? y????????? minDistance ?????? ?????? ??????????????? ?????? ??????
                yDistance = list.get(j).y - list.get(i).y;
                if (yDistance * yDistance < minDistance) {
                    minDistance = Math.min(minDistance, getDistance(list.get(j), list.get(i)));
                } else {
                    // j??? i?????? ???????????? ??? minDistance ????????? ???????????? ??????
                    // ?????? ???????????? y ????????? ???????????????????????? ???????????? ?????????
                    // ?????? j??? ?????????
                    break;
                }
            }
        }
        return minDistance;
    }
}
