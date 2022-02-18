import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.lang.StringBuilder;
import java.util.Stack;
import java.util.PriorityQueue;

class Node1214 implements Comparable<Node1214> {
    public int city;
    public int cost;

    public Node1214(int city, int cost) {
        this.city = city;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node1214 o) {
        return cost - o.cost;
    }
}

public class _1214_getMinimumCost2_boj11779 {
    static Map<Integer, List<Node1214>> graph;
    static int[] costs;
    static int[] path;

    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(rd.readLine());
        int m = Integer.parseInt(rd.readLine());

        graph = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }
        costs = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            costs[i] = Integer.MAX_VALUE;
        }
        path = new int[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(rd.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node1214(b, c));
        }

        st = new StringTokenizer(rd.readLine());
        int origin = Integer.parseInt(st.nextToken());
        int destination = Integer.parseInt(st.nextToken());

        dijkstra(origin, destination);

        Stack<Integer> stack = new Stack<>();
        int idx = destination;
        while (idx != origin) {
            stack.push(idx);
            idx = path[idx];
        }
        int cnt = 1;
        sb.append(origin + " ");
        while (!stack.isEmpty()) {
            sb.append(stack.pop() + " ");
            cnt++;
        }

        System.out.println(costs[destination]);
        System.out.println(cnt);
        System.out.print(sb);
        rd.close();
    }

    public static void dijkstra(int origin, int destination) {
        costs[origin] = 0;
        PriorityQueue<Node1214> heapq = new PriorityQueue<>();
        heapq.add(new Node1214(origin, 0));

        while (!heapq.isEmpty()) {
            Node1214 cur = heapq.poll();
            int curCity = cur.city;
            int curCost = cur.cost;

            if (costs[curCity] < curCost) {
                continue;
            }

            for (Node1214 next : graph.get(curCity)) {
                int nextCity = next.city;
                int nextCost = curCost + next.cost;

                if (costs[nextCity] > nextCost) {
                    costs[nextCity] = nextCost;
                    heapq.add(new Node1214(nextCity, nextCost));
                    path[nextCity] = curCity;
                }
            }
        }
    }
}
