package JavaCompleted;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _0920_repeatString_boj2675 {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wt = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N = Integer.parseInt(rd.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(rd.readLine());
            int num = Integer.parseInt(st.nextToken());
            String[] strArr = st.nextToken().split("");
            for (int j = 0; j < strArr.length; j++) {
                String temp = "";
                for (int k = 0; k < num; k++) {
                    temp += strArr[j];
                }
                wt.write(temp);
            }
            wt.write("\n");
        }
        wt.flush();
        wt.close();
        rd.close();
    }
}
