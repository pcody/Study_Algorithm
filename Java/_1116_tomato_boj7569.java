import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Queue;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Tomato1116 {
    public int x;
    public int y;
    public int z;
    public int day;

    public Tomato1116(int x, int y, int z, int day) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.day = day;
    }
}

public class _1116_tomato_boj7569 {
    static int zero;
    static int[][][] tomatoes;
    static int[][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(rd.readLine());
        int answer = 0;
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        Queue<Tomato1116> queue = new LinkedList<>();
        int[][] vecxyz = { { -1, 0, 0 }, { 0, 1, 0 }, { 1, 0, 0 }, { 0, -1, 0 }, { 0, 0, 1 }, { 0, 0, -1 } };
        visited = new int[H][N][M];
        tomatoes = new int[H][N][M];

        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                st = new StringTokenizer(rd.readLine());
                for (int m = 0; m < M; m++) {
                    int num = Integer.parseInt(st.nextToken());
                    if (num == 0) {
                        zero++;
                    } else if (num == 1) {
                        queue.add(new Tomato1116(m, n, h, 0));
                    }
                    tomatoes[h][n][m] = num;
                }
            }
        }

        while (!queue.isEmpty()) {
            Tomato1116 cur = queue.poll();

            for (int i = 0; i < 6; i++) {
                int nx = cur.x + vecxyz[i][0];
                int ny = cur.y + vecxyz[i][1];
                int nz = cur.z + vecxyz[i][2];

                if (0 <= nx && nx < M && 0 <= ny && ny < N && 0 <= nz && nz < H) {
                    if (tomatoes[nz][ny][nx] == 0) {
                        tomatoes[nz][ny][nx] = 1;
                        zero--;
                        queue.add(new Tomato1116(nx, ny, nz, cur.day + 1));
                        answer = Math.max(answer, cur.day + 1);
                    }
                }
            }
        }
        System.out.println(zero > 0 ? -1 : answer);
        rd.close();
    }
}
