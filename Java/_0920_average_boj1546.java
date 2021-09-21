package JavaCompleted;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class _0920_average_boj1546 {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(rd.readLine());
        int N = Integer.parseInt(st.nextToken());

        List<Double> arr = new ArrayList<Double>();

        st = new StringTokenizer(rd.readLine());
        for (int i = 0; i < N; i++) {
            arr.add(Double.parseDouble(st.nextToken()));
        }

        double maxNum = Collections.max(arr);
        double S = 0;
        for (int i = 0; i < N; i++) {
            double num = arr.get(i);
            arr.set(i, num / maxNum * 100);
            S += arr.get(i);
        }

        System.out.println(S / N);
        rd.close();
    }
}
