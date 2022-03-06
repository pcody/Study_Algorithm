import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class _220124_finding_boj1786 {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));

        String str = rd.readLine();
        String target = rd.readLine();
        List<Integer> answer = kmp(str, target);

        System.out.println(answer.size());
        for (Integer i : answer) {
            System.out.print(i + 1 + " ");
        }
        rd.close();
    }

    public static int[] getPi(String t) {
        int m = t.length(), j = 0;
        int[] pi = new int[m];

        for (int i = 1; i < m; i++) {
            while (j > 0 && t.charAt(i) != t.charAt(j)) {
                j = pi[j - 1];
            }
            if (t.charAt(i) == t.charAt(j)) {
                pi[i] = ++j;
            }
        }

        return pi;
    }

    public static List<Integer> kmp(String s, String t) {
        List<Integer> ans = new ArrayList<>();

        int[] pi = getPi(t);
        int n = s.length(), m = t.length(), j = 0;

        for (int i = 0; i < n; i++) {
            while (j > 0 && s.charAt(i) != t.charAt(j)) {
                j = pi[j - 1];
            }
            if (s.charAt(i) == t.charAt(j)) {
                if (j == m - 1) {
                    ans.add(i - m + 1);
                    j = pi[j];
                } else {
                    j++;
                }
            }
        }

        return ans;
    }
}
