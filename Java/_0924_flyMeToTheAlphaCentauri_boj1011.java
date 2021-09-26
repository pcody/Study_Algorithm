import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _0924_flyMeToTheAlphaCentauri_boj1011 {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(rd.readLine());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(rd.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int distance = (y - x);
            int s = 0, n = 0;
            int answer = 0;
            // 거리의 반을 나눠서 n을 키워가며 누적합을 계산
            // 누적합이 거리/2 보다 같거나 커지는 경우 while탈출
            // 클 때는 마지막 n만큼 s를 빼고 n도 1감소
            while (true) {
                n++;
                s += n;
                if (s > distance / 2) {
                    s -= n;
                    n--;
                    break;
                } else if (s == distance / 2) {
                    break;
                }
            }
            // 거리/2와 같은 경우와 다른 경우가 있음.
            // 다른 경우는 s가 거리/2보다 작은 경우밖에 없음
            if (s == distance / 2) {
                // int형 나눗셈은 몫만 계산하므로 거리/2와 같아도 *2를 해서 작은 경우가 있음
                if (s * 2 == distance) {
                    // *2 결과가 거리와 같은 경우는 n * 2번
                    answer = n * 2;
                } else {
                    // s * 2 < distance
                    int carry = 0;
                    // distance - 2 * s를 계산하면 1~n,n~1까지 이동하고 남은 거리
                    // 남은 거리를 n + 1로 나눠서 나머지가 존재하면 carry = 1
                    if ((distance - 2 * s) % (n + 1) > 0) {
                        carry = 1;
                    }
                    // 남은 거리를 n + 1로 나눈 몫과 나머지를 더함
                    // 남은 거리가 n + 1보다 작은 경우 나머지에 대한 1회 이동만 추가됨
                    answer = n * 2 + (distance - 2 * s) / (n + 1) + carry;
                }
            }
            // s < 거리/2의 경우
            else {
                int carry = 0;
                if ((distance - 2 * s) % (n + 1) > 0) {
                    carry = 1;
                }
                answer = n * 2 + (distance - 2 * s) / (n + 1) + carry;
            }
            System.out.println(answer);
        }
        rd.close();
    }
}

// y-x = 3, (y-x)/2 = 1
// n 1 2
// s 1 3
// n = 1, s = 1
// (y-x)/2 > s --> n * 2 + 2
// (y-x)/2 == s
// 2*s < y-x --> n * 2 + 1
// 2*s == y-x --> n * 2

// 마지막 kn을 1 가려면 kn-1을 0, 1, 2 중 가야하는데
// 최대로 이동해야하므로 2
// 처음도 1 이동
// k1 = 1, kn = 1

// 4
// 2 121
// 1 2
// 1 3

// 50
// 25
// 1 2 3 4 5 6 6 5 4 3 2 1
// 1 3 6 10 15 21 27 32 36 39 41 42
