import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _0927_turret_boj1002 {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(rd.readLine());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(rd.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());

            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());

            // 중심 간 거리
            double d = Math.sqrt((Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2)));

            // 바깥
            if (d > r1 + r2) {
                sb.append(0 + "\n");
            }
            // 외접
            else if (d == r1 + r2) {
                sb.append(1 + "\n");
            } else { // d < r1 + r2
                if (x1 != x2 || y1 != y2) {
                    // 내접
                    if (d == Math.abs(r1 - r2)) {
                        sb.append(1 + "\n");
                    }
                    // 내부
                    else if (d < Math.abs(r1 - r2)) {
                        sb.append(0 + "\n");
                    }
                    // 겹침
                    else {
                        sb.append(2 + "\n");
                    }
                } else {
                    // 일치
                    if (r1 == r2) {
                        sb.append(-1 + "\n");
                    }
                    // 내부
                    else {
                        sb.append(0 + "\n");
                    }
                }
            }
        }
        System.out.println(sb);
        rd.close();
    }
}