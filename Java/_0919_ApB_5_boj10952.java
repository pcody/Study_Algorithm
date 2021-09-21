package JavaCompleted;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _0919_ApB_5_boj10952 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int s = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());
        while (s != 0) {
            writer.write(s + "\n");
            st = new StringTokenizer(reader.readLine());
            s = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());
        }
        reader.close();
        writer.flush();
        writer.close();
    }
}
