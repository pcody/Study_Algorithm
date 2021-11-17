import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class _1028_binomial_coefficient3_boj11401 {
    static int divisor = 1000000007;
    static long[][] res;

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(rd.readLine());
        long N = Long.parseLong(st.nextToken());
        long K = Long.parseLong(st.nextToken());

        long a = factorial(N);
        long b = factorial(K) * factorial(N - K) % divisor;

        // (N! * (K! * (N - K)!)^-1) % divisor
        System.out.println(a * power(b, divisor - 2) % divisor);
        rd.close();
    }

    // 곱셈에 대한 나머지연산 분배법칙 증명
    // a = ma * p + ra
    // b = mb * p + rb
    // (a*b) = ma*mb*p^2 + (ma*rb+mb*ra)p + ra*rb = (ma*mb*p + ma*rb + mb*ra)p +
    // ra*rb
    // (a*b) % p = (a%p)*(b%p) = ra * rb 와 같다

    // 팩토리얼 값을 구한다
    // 곱셈에 대한 나머지(modulo) 연산은 분배법칙이 성립하므로
    // 큰 수를 대비하여 divisor로 계속 나눠준다
    public static long factorial(long n) {
        long lNum = 1L;

        while (n > 1) {
            lNum = (lNum * n--) % divisor;
        }

        return lNum;
    }

    // 곰셈에 대하여 나머지연산은 분배법칙이 성립하므로
    // N!/(K!(N-K)!) % P 연산은 곱셈 연산으로 고치면
    // (N!%P) * ((K!(N-K)!)^-1%P) 가 되고
    // (K!(N-K)!)^-1 = (K!(N-K)!)^(divisor-2) 가 된다
    // 이제 base = (K!(N-K)!)의 (divisor - 2) 제곱을 구하면 되는데
    // 이를 재귀함수로 만든다
    // exp (divisor - 2) 를 2로 계속 나눈 연산을 재귀적으로 구현하여
    // exp = 1 부터 곱해 최종 divisor 까지 올라오게 함
    public static long power(long base, long exp) {
        if (exp == 1) {
            return base % divisor;
        }

        long temp = power(base, exp / 2);

        if (exp % 2 == 1) {
            return (temp * temp % divisor) * base % divisor;
        }
        return temp * temp % divisor;
    }
}
