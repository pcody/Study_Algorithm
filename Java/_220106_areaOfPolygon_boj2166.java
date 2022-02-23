import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;
import java.math.BigDecimal;

class Position220106 {
    public double x;
    public double y;

    public Position220106(double x, double y) {
        this.x = x;
        this.y = y;
    }
}

public class _220106_areaOfPolygon_boj2166 {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(rd.readLine());
        List<Position220106> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(rd.readLine());
            double x = Integer.parseInt(st.nextToken());
            double y = Integer.parseInt(st.nextToken());
            list.add(new Position220106(x, y));
        }

        double answer = 0.0;
        Position220106 p1 = list.get(0);
        for (int i = 2; i < N; i++) {
            Position220106 p2 = list.get(i - 1);
            Position220106 p3 = list.get(i);
            answer += calArea(p1, p2, p3);
        }
        // 소수점 둘째자리에서 반올림하기 위해 첫째자리를 소수점 위로 올려주고 round
        answer = Math.round(Math.abs(answer) / 2.0 * 10) / 10.0;

        // 매우 큰 수는 지수표현식(E10)으로 나오므로 큰수로 변경
        BigDecimal bAns = new BigDecimal(answer);
        if (!bAns.toString().contains(".")) {
            // 소수점이 없으면 붙여준다
            System.out.println(bAns.toString() + ".0");
        } else {
            System.out.println(bAns);
        }

        rd.close();
    }

    public static double calArea(Position220106 p1, Position220106 p2, Position220106 p3) {
        // 기준점p1, p1p2, p1p3 두 벡터의 외적 = 평행사변형의 넓이
        double a = (p2.x - p1.x) * (p3.y - p1.y);
        double b = (p2.y - p1.y) * (p3.x - p1.x);

        return a - b;
    }
}