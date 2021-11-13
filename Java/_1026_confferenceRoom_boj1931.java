import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Confference1026 implements Comparable<Confference1026> {
    public int sTime;
    public int eTime;

    public Confference1026(int s, int e) {
        sTime = s;
        eTime = e;
    }

    @Override
    public int compareTo(Confference1026 c) {
        if (eTime != c.eTime) {
            return eTime - c.eTime;
        } else {
            return sTime - c.sTime;
        }
    }

    @Override
    public String toString() {
        return "[sTime=" + sTime + " eTime=" + eTime + "]";
    }
}

public class _1026_confferenceRoom_boj1931 {
    static List<Confference1026> list;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(rd.readLine());
        StringTokenizer st;
        list = new ArrayList<>();

        while (N-- > 0) {
            st = new StringTokenizer(rd.readLine());
            list.add(new Confference1026(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Collections.sort(list);
        // list.stream().forEach(con -> System.out.println(con));

        int prev = list.get(0).eTime;
        answer++;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).sTime >= prev) {
                answer++;
                prev = list.get(i).eTime;
            }
        }
        System.out.println(answer);
        rd.close();
    }
}
