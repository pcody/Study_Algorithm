import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _0930_movieDirectorShom_boj1436 {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(rd.readLine());

        String str = "666";
        int n = 0;
        int num = 1;
        while (true) {
            num += 1;
            if (String.valueOf(num).contains(str)) {
                n++;
            }
            if (n == N) {
                break;
            }
        }

        System.out.println(num);
        rd.close();
    }
}