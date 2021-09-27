import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _0926_goldbach_boj9020 {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wt = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(rd.readLine());
        for (int i = 0; i < T; i++) {
            List<Integer> nums = new ArrayList<Integer>();
            int n = Integer.parseInt(rd.readLine());
            for (int j = 2; j < n; j++) {
                if (isPrimeNum(j)) {
                    nums.add(j);
                }
            }
            List<List<Integer>> npr = nPr(nums);
            String answer = "";
            for (int j = 0; j < npr.size(); j++) {
                List<Integer> temp = npr.get(j);
                int a = temp.get(0);
                int b = temp.get(1);
                if (a + b == n) {
                    if (answer == "") {
                        answer = Integer.toString(a) + " " + Integer.toString(b);
                    } else {
                        StringTokenizer st = new StringTokenizer(answer);
                        int aa = Integer.parseInt(st.nextToken());
                        int bb = Integer.parseInt(st.nextToken());
                        if (Math.abs(a - b) < Math.abs(aa - bb)) {
                            answer = Integer.toString(a) + " " + Integer.toString(b);
                        }
                    }
                }
            }
            wt.write(answer + "\n");
        }

        wt.flush();
        wt.close();
        rd.close();
    }

    public static List<List<Integer>> nPr(List<Integer> nums) {
        int size = nums.size();
        List<List<Integer>> retList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            for (int j = i; j < size; j++) {
                List<Integer> temp = new ArrayList<>();
                temp.add(nums.get(i));
                temp.add(nums.get(j));
                if (!retList.contains(temp)) {
                    retList.add(temp);
                }
            }
        }
        return retList;
    }

    public static Boolean isPrimeNum(int n) {
        if (n == 1) {
            return false;
        }
        int sqrtN = (int) Math.sqrt(n);
        for (int i = 2; i <= sqrtN; i++) {
            if (n % sqrtN == 0) {
                return false;
            }
        }
        return true;
    }
}