import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _0930_sortingNumber_3_boj10989 {

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wt = new BufferedWriter(new OutputStreamWriter(System.out));
        long N = Integer.parseInt(rd.readLine());

        // Counting Sort
        // 등장하는 숫자가 몇개 나오는지 저장한 후
        // 나온 수 만큼 순서대로 출력
        // print문도 시간이 오래 걸리므로 버퍼에 일괄 저장해서 마지막에 플러시
        int[] arr = new int[10001];
        for (int i = 0; i < N; i++) {
            arr[Integer.parseInt(rd.readLine())] += 1;
        }

        // Array를 List로 만들어서 정렬하는 코드
        // List<Integer> answerList = new ArrayList<>();
        // Arrays.stream(arr).boxed().collect(Collectors.toList());
        // answerList.sort(Comparator.naturalOrder());

        for (int i = 1; i < 10001; i++) {
            while (arr[i] > 0) {
                arr[i] -= 1;
                wt.write(i + "\n");
            }
        }

        wt.flush();
        wt.close();
        rd.close();
    }
}