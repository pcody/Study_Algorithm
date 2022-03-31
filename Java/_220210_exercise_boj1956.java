import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Node220210 implements Comparable<Node220210> {
    public int node;
    public int dist;

    public Node220210(int node, int dist) {
        this.node = node;
        this.dist = dist;
    }

    @Override
    public int compareTo(Node220210 o) {
        return dist - o.dist;
    }
}

public class _220210_exercise_boj1956 {
    static int V, E;
    static Map<Integer, List<Node220210>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(rd.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        // graph 생성
        graph = new HashMap<>();
        for (int i = 1; i <= V; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(rd.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node220210(b, c));
        }

        int answer = Integer.MAX_VALUE;
        for (int i = 1; i <= V; i++) {
            answer = Math.min(solve(i), answer);
        }

        if (answer != Integer.MAX_VALUE) {
            System.out.println(answer);
        } else {
            System.out.println(-1);
        }
        rd.close();
    }

    static int solve(int start) {
        int[] distance = new int[V + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        PriorityQueue<Node220210> heapq = new PriorityQueue<>();
        heapq.add(new Node220210(start, 0));

        while (!heapq.isEmpty()) {
            Node220210 cur = heapq.poll();

            if (distance[cur.node] < cur.dist) {
                continue;
            }

            for (Node220210 next : graph.get(cur.node)) {
                int nextDist = cur.dist + next.dist;

                if (nextDist < distance[next.node]) {
                    distance[next.node] = nextDist;
                    heapq.add(new Node220210(next.node, nextDist));
                }
            }
        }
        return distance[start];
    }
}
