import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.StringBuilder;
import java.util.LinkedList;
import java.util.Queue;

class KnightPosition1117 {
    public int x;
    public int y;
    public int step;

    public KnightPosition1117(int x, int y, int step) {
        this.x = x;
        this.y = y;
        this.step = step;
    }
}

public class _1117_movementOfKnight_boj7562 {

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(rd.readLine());
        for (int t = 0; t < T; t++) {
            int L = Integer.parseInt(rd.readLine());
            String[] sxy = rd.readLine().split(" ");
            String[] exy = rd.readLine().split(" ");
            int sx = Integer.parseInt(sxy[0]);
            int sy = Integer.parseInt(sxy[1]);
            int ex = Integer.parseInt(exy[0]);
            int ey = Integer.parseInt(exy[1]);

            sb.append(bfs(L, sx, sy, ex, ey) + "\n");
        }

        System.out.print(sb);
        rd.close();
    }

    public static int bfs(int L, int sx, int sy, int ex, int ey) {
        int answer = 0;
        Queue<KnightPosition1117> queue = new LinkedList<>();
        int[][] visited = new int[L][L];
        int[][] vecxy = { { -1, -2 }, { -2, -1 }, { -2, 1 }, { -1, 2 }, { 1, 2 }, { 2, 1 }, { 2, -1 }, { 1, -2 } };
        for (int j = 0; j < L; j++) {
            for (int i = 0; i < L; i++) {
                visited[j][i] = -1;
            }
        }
        queue.add(new KnightPosition1117(sx, sy, 0));

        while (!queue.isEmpty()) {
            KnightPosition1117 cur = queue.poll();

            if (cur.x == ex && cur.y == ey) {
                answer = cur.step;
                break;
            }

            for (int i = 0; i < 8; i++) {
                int nx = cur.x + vecxy[i][0];
                int ny = cur.y + vecxy[i][1];

                if (0 <= nx && nx < L && 0 <= ny && ny < L && visited[ny][nx] == -1) {
                    visited[ny][nx] = 1;
                    queue.add(new KnightPosition1117(nx, ny, cur.step + 1));
                }
            }
        }

        return answer;
    }
}