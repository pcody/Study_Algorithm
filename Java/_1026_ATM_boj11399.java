import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class _1026_ATM_boj11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(rd.readLine());
        int[] P = Arrays.stream(rd.readLine().split(" ")).mapToInt(t -> Integer.parseInt(t)).toArray();
        // List<Integer> P = Arrays.stream(rd.readLine().split(" ")).map(t ->
        // Integer.parseInt(t)).collect(Collectors.toList());
        // int[] P = Stream.of(rd.readLine().split(" ")).mapToInt(t ->
        // Integer.parseInt(t)).toArray();

        Arrays.sort(P);
        int[] answer = new int[N];
        int s = 0;
        for (int i = 0; i < P.length; i++) {
            s += P[i];
            answer[i] = s;
        }
        System.out.println(Arrays.stream(answer).sum());
        rd.close();
    }
}
