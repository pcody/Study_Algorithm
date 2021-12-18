import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

class House1116 {
    public int x;
    public int y;
    public int comNum;
    public int num;

    public House1116(int x, int y, int comNum, int num) {
        this.x = x;
        this.y = y;
        this.comNum = comNum;
        this.num = num;
    }
}

public class _1116_numberingOfComplex_boj2667 {
    static int[][] complex;
    static int[][] visited;
    static int comNum;
    static int num;

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(rd.readLine());
        complex = new int[N][];
        visited = new int[N][N];
        Queue<House1116> queue = new LinkedList<>();
        int[][] vecxy = new int[][] { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            complex[i] = Arrays.stream(rd.readLine().split("")).mapToInt(t -> Integer.parseInt(t)).toArray();
        }

        for (int i = 0; i < N; i++) {
            Arrays.fill(visited[i], -1);
        }

        for (int j = 0; j < N; j++) {
            for (int i = 0; i < N; i++) {
                if (visited[j][i] == -1) {
                    visited[j][i] = 1;

                    if (complex[j][i] == 1) {
                        comNum++;
                        num = 1;
                        queue.add(new House1116(i, j, comNum, num));

                        while (!queue.isEmpty()) {
                            House1116 cur = queue.poll();
                            for (int k = 0; k < 4; k++) {
                                int nx = cur.x + vecxy[k][0];
                                int ny = cur.y + vecxy[k][1];
                                if (0 <= nx && nx < N && 0 <= ny && ny < N && visited[ny][nx] == -1
                                        && complex[ny][nx] == 1) {
                                    visited[ny][nx] = 1;
                                    queue.add(new House1116(nx, ny, comNum, num++));
                                }
                            }
                        }
                        answer.add(num);
                    }
                }
            }
        }

        answer.sort(Comparator.naturalOrder());
        System.out.println(comNum);
        for (int i = 0; i < answer.size(); i++) {
            System.out.println(answer.get(i));
        }
        rd.close();
    }
}
