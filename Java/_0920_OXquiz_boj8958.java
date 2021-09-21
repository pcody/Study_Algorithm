package JavaCompleted;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _0920_OXquiz_boj8958 {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wt = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(rd.readLine());
        int T = Integer.parseInt(st.nextToken());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(rd.readLine());
            String str = st.nextToken();

            int score = 0;
            int S = 0;
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == 'O') {
                    score += 1;
                } else {
                    score = 0;
                }
                S += score;
            }
            wt.write(S + "\n");
        }
        wt.flush();
        wt.close();
        rd.close();
    }
}
