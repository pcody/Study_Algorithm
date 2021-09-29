import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _0929_hanoiTower_boj11729 {
    static int i;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(rd.readLine());

        hanoiTower(K, 1, 2, 3);

        System.out.println(i);
        System.out.print(sb);
        rd.close();
    }

    public static void hanoiTower(int block, int D, int V, int A) {
        if (block <= 0) {
            return;
        }
        hanoiTower(block - 1, D, A, V);
        i++;
        sb.append(D + " " + A + "\n");
        hanoiTower(block - 1, V, D, A);
    }
}