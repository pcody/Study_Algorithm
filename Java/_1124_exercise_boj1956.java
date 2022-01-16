// import java.io.BufferedReader;
// import java.io.InputStreamReader;
// import java.io.IOException;
// import java.util.StringTokenizer;
// import java.util.Map;
// import java.util.HashMap;
// import java.util.List;
// import java.util.ArrayList;
// import java.util.PriorityQueue;

// class VertexInfo1124 implements Comparable<VertexInfo1124> {
//     int vertex;
//     int cost;

//     public VertexInfo1124(int vertex, int cost) {
//         this.vertex = vertex;
//         this.cost = cost;
//     }

//     @Override
//     public int compareTo(VertexInfo1124 o) {
//         return cost - o.cost;
//     }
// }

// public class _1124_exercise_boj1956 {
//     static Map<Integer, List<VertexInfo1124>> graph;
//     static int[][] cost;

//     public static void main(String[] args) throws IOException {
//         BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
//         StringTokenizer st = new StringTokenizer(rd.readLine());
//         int V = Integer.parseInt(st.nextToken());
//         int E = Integer.parseInt(st.nextToken());

//         graph = new HashMap<>();
//         for (int i = 1; i <= V; i++) {
//             graph.put(i, new ArrayList<>());
//         }
//         for (int i = 0; i < E; i++) {
//             st = new StringTokenizer(rd.readLine());
//             int a = Integer.parseInt(st.nextToken());
//             int b = Integer.parseInt(st.nextToken());
//             int c = Integer.parseInt(st.nextToken());

//             graph.get(a).add(new VertexInfo1124(b, c));
//         }

//         cost = new int[V + 1][V + 1];
//         for (int j = 0; j <= V; j++) {
//             for (int i = 0; i <= V; i++) {
//                 cost[j][i] = Integer.MAX_VALUE;
//             }
//         }

//         for (int i = 1; i <= V; i++) {
//             dijkstra(i);
//         }

//         int answer = Integer.MAX_VALUE;
//         for (int j = 1; j <= V; j++) {
//             for (int i = 1; i <= V; i++) {
//                 if (j == i) {
//                     answer = Math.min(answer, cost[j][i]);
//                 }
//             }
//         }
//         if (answer != Integer.MAX_VALUE) {
//             System.out.println(answer);
//         } else {
//             System.out.println(-1);
//         }

//         rd.close();
//     }

//     public static void dijkstra(int start) {
//         PriorityQueue<VertexInfo1124> queue = new PriorityQueue<>();
//         queue.add(new VertexInfo1124(start, 0));

//         while (!queue.isEmpty()) {
//             VertexInfo1124 cur = queue.poll();
//             int curV = cur.vertex;
//             int curC = cur.cost;

//             if (cost[start][curV] < curC) {
//                 continue;
//             }

//             for (VertexInfo1124 next : graph.get(curV)) {
//                 int nextV = next.vertex;
//                 int nextC = next.cost;

//                 if (cost[start][nextV] > curC + nextC) {
//                     cost[start][nextV] = curC + nextC;
//                     queue.add(new VertexInfo1124(nextV, cost[start][nextV]));
//                 }
//             }
//         }
//     }
// }

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Arrays;

class VertexInfo1124 implements Comparable<VertexInfo1124> {
    int vertex;
    int cost;

    public VertexInfo1124(int vertex, int cost) {
        this.vertex = vertex;
        this.cost = cost;
    }

    @Override
    public int compareTo(VertexInfo1124 o) {
        return cost - o.cost;
    }
}

public class _1124_exercise_boj1956 {
    static Map<Integer, List<VertexInfo1124>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(rd.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        graph = new HashMap<>();
        for (int i = 1; i <= V; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(rd.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new VertexInfo1124(b, c));
        }

        int answer = Integer.MAX_VALUE;
        for (int i = 1; i <= V; i++) {
            answer = Math.min(answer, dijkstra(i, V, E));
        }
        if (answer != Integer.MAX_VALUE) {
            System.out.println(answer);
        } else {
            System.out.println(-1);
        }

        rd.close();
    }

    public static int dijkstra(int start, int V, int E) {
        PriorityQueue<VertexInfo1124> queue = new PriorityQueue<>();
        queue.add(new VertexInfo1124(start, 0));

        int[] cost = new int[V + 1];
        Arrays.fill(cost, Integer.MAX_VALUE);

        while (!queue.isEmpty()) {
            VertexInfo1124 cur = queue.poll();
            int curV = cur.vertex;
            int curC = cur.cost;

            if (cost[curV] < curC) {
                continue;
            }

            for (VertexInfo1124 next : graph.get(curV)) {
                int nextV = next.vertex;
                int nextC = next.cost;

                if (cost[nextV] > curC + nextC) {
                    cost[nextV] = curC + nextC;
                    queue.add(new VertexInfo1124(nextV, cost[nextV]));
                }
            }
        }
        return cost[start];
    }
}
