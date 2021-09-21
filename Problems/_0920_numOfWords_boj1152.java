import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _0920_numOfWords_boj1152 {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(rd.readLine());
        int n = 0;
        while (true) {
            try {
                String temp = st.nextToken();
                n += 1;
            } catch (Exception e) {
                break;
            }
        }
        System.out.println(n);
    }
}
