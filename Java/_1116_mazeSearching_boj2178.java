import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;

class Maze1116 {
    public int x;
    public int y;
    public int step;

    public Maze1116(int x, int y, int step) {
        this.x = x;
        this.y = y;
        this.step = step;
    }
}

public class _1116_mazeSearching_boj2178 {
    static int[][] maze;
    static int[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(rd.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        maze = new int[N][];
        visited = new int[N][M];
        Queue<Maze1116> queue = new LinkedList<>();
        int[][] vecxy = new int[][] { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

        for (int i = 0; i < N; i++) {
            maze[i] = Arrays.stream(rd.readLine().split("")).mapToInt(t -> Integer.parseInt(t)).toArray();
            Arrays.fill(visited[i], -1);
        }

        queue.add(new Maze1116(0, 0, 1));
        visited[0][0] = 1;

        while (!queue.isEmpty()) {
            Maze1116 cur = queue.poll();
            int nStep = cur.step + 1;

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + vecxy[i][0];
                int ny = cur.y + vecxy[i][1];
                if (0 <= nx && nx < M && 0 <= ny && ny < N && visited[ny][nx] == -1 && maze[ny][nx] == 1) {
                    visited[ny][nx] = nStep;
                    queue.add(new Maze1116(nx, ny, nStep));
                }
            }
        }
        System.out.println(visited[N - 1][M - 1]);
        rd.close();
    }
}
