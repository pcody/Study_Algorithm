package JavaCompleted;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _0920_maybeAboveAvg_boj4344 {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(rd.readLine());
        StringBuilder sb = new StringBuilder();
        int C = Integer.parseInt(st.nextToken());

        for (int i = 0; i < C; i++) {
            String str = rd.readLine();
            st = new StringTokenizer(str);
            int n = Integer.parseInt(st.nextToken());
            double s = 0;
            for (int j = 0; j < n; j++) {
                s += Integer.parseInt(st.nextToken());
            }
            double avg = s / n;

            st = new StringTokenizer(str);
            double num = 0.0;
            st.nextToken();
            for (int j = 0; j < n; j++) {
                if (Integer.parseInt(st.nextToken()) > avg) {
                    num += 1;
                }
            }
            double percent = num / n * 100;
            if (i != C - 1) {
                sb.append(String.format("%.3f", percent) + "%\n");
            } else {
                sb.append(String.format("%.3f", percent) + "%");
            }
        }
        System.out.println(sb);
        rd.close();
    }
}
