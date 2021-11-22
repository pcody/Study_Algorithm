import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Iterator;

class Distance1104 implements Comparable<Distance1104> {
    public int dist;
    public int node;

    public Distance1104(int node, int dist) {
        this.node = node;
        this.dist = dist;
    }

    @Override
    public int compareTo(Distance1104 o) {
        return dist - o.dist;
    }
}

public class _1104_degreeOfKinship_boj2644 {
    static Map<Integer, List<Integer>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        graph = new HashMap<>();

        int n = Integer.parseInt(rd.readLine());
        st = new StringTokenizer(rd.readLine());
        int targetP = Integer.parseInt(st.nextToken());
        int targetC = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(rd.readLine());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(rd.readLine());
            int p = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (graph.containsKey(p)) {
                graph.get(p).add(c);
            } else {
                graph.put(p, new ArrayList<>(Arrays.asList(c)));
            }

            if (graph.containsKey(c)) {
                graph.get(c).add(p);
            } else {
                graph.put(c, new ArrayList<>(Arrays.asList(p)));
            }
        }

        Map<Integer, Integer> distances = dikjstra(n, targetP);
        int answer = distances.get(targetC);
        if (answer == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(distances.get(targetC));
        }
        rd.close();
    }

    public static Map<Integer, Integer> dikjstra(int n, int targetP) {
        Map<Integer, Integer> distances = new HashMap<>();
        for (int i = 1; i < n + 1; i++) {
            distances.put(i, Integer.MAX_VALUE);
        }
        distances.replace(targetP, 0);
        PriorityQueue<Distance1104> heapq = new PriorityQueue<>();
        heapq.add(new Distance1104(targetP, 0));

        while (!heapq.isEmpty()) {
            Distance1104 temp = heapq.poll();
            int cost = temp.dist;
            int cur = temp.node;

            if (distances.get(cur) < cost) {
                continue;
            }

            for (Iterator<Integer> itr = graph.get(cur).iterator(); itr.hasNext();) {
                int nCost = cost + 1;
                int next = itr.next();
                if (nCost < distances.get(next)) {
                    distances.replace(next, nCost);
                    heapq.add(new Distance1104(next, nCost));
                }
            }
        }
        return distances;
    }
}
