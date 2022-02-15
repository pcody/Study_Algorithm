import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Collections;

class TelephonePole implements Comparable<TelephonePole> {
    public int l;
    public int r;

    public TelephonePole(int l, int r) {
        this.l = l;
        this.r = r;
    }

    @Override
    public int compareTo(TelephonePole o) {
        return l - o.l;
    }

    @Override
    public String toString() {
        return this.l + " " + this.r + "\n";
    }
}

public class _1209_telephonePole_boj2565 {
    static List<TelephonePole> list;
    static int N;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(rd.readLine());
        list = new ArrayList<>();
        dp = new int[N];
        for (int i = 0; i < N; i++) {
            dp[i] = -1;
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(rd.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            list.add(new TelephonePole(l, r));
        }
        Collections.sort(list);

        // 왼쪽 기준 정렬
        // 오른쪽 기준 최장 증가 부분수열 찾기
        // N에서 최대 길이 빼기

        int answer = 0;
        for (int i = 0; i < N; i++) {
            int cnt = 0;
            for (int j = i; j >= 0; j--) {
                if (list.get(j).r < list.get(i).r) {
                    cnt = Math.max(cnt, dp[j]);
                }
            }
            dp[i] = cnt + 1;
            answer = Math.max(answer, dp[i]);
        }

        System.out.println(N - answer);
        rd.close();
    }
}