import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class _1001_sortInside_boj1427 {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(rd.readLine());
        String N = st.nextToken();
        String[] nArr = N.split("");

        // int[] nnArr = {1,2,3,4};
        // List<Integer> nnList = new ArrayList<>(Arrays.asList(nnArr));
        // int 배열 -> Integer 리스트는 primitive type에서 wrapper 클래스 type으로
        // 형변환하지 않기 때문에 List로 변환이 불가능하다

        List<String> nList = new ArrayList<>(Arrays.asList(nArr));
        nList.sort(Comparator.reverseOrder());
        for (String s : nList) {
            System.out.print(s);
        }
        rd.close();
    }
}