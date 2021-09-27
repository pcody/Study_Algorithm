import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _0927_taxiGeometry_boj3053 {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        int R = Integer.parseInt(rd.readLine());

        double S1 = Math.PI * R * R;
        double S2 = Math.pow(R, 2) * 2;

        System.out.printf("%f\n%f", S1, S2);
        rd.close();
    }
}

// |x| + |y| = R
// > 0 > 0 -> x + y = R -> y = -x + R
// > 0 < 0 -> x - y = R -> y = x - R
// < 0 > 0 -> -x + y = R -> y = x + R
// < 0 < 0 -> -x - y = R -> y = -x - R
// R^2 * 2
