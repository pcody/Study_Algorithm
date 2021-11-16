import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.stream.Stream;

public class _1027_gasStation_boj13305 {
    public static void main(String[] args) throws IOException {
        // BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        // BigInteger N = new BigInteger(rd.readLine());
        // Queue<BigInteger> distances = new LinkedList<>(
        // Stream.of(rd.readLine().split("
        // ")).map(BigInteger::new).collect(Collectors.toList()));
        // Queue<BigInteger> costs = new LinkedList<>(
        // Stream.of(rd.readLine().split(" ")).map(t -> new
        // BigInteger(t)).collect(Collectors.toList()));
        // Stack<BigInteger> stack = new Stack<>();

        // BigInteger answer = distances.peek().multiply(costs.poll());
        // stack.push(distances.poll());
        // while (!distances.isEmpty()) {
        // BigInteger dist = distances.poll();
        // BigInteger c = costs.poll();

        // if (stack.peek().compareTo(c) > 0) {
        // answer = answer.add(dist.multiply(c));
        // stack.push(c);
        // } else {
        // answer = answer.add(dist.multiply(stack.peek()));
        // }
        // }

        // System.out.println(answer);
        // rd.close();

        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(rd.readLine());
        long[] distances = Stream.of(rd.readLine().split(" ")).mapToLong(t -> Long.parseLong(t)).toArray();
        long[] costs = Stream.of(rd.readLine().split(" ")).mapToLong(t -> Long.parseLong(t)).toArray();

        for (int i = 1; i < N; i++) {
            if (costs[i - 1] < costs[i]) {
                costs[i] = costs[i - 1];
            }
        }

        long answer = 0;
        for (int i = 0; i < N - 1; i++) {
            answer += distances[i] * costs[i];
        }

        System.out.println(answer);
        rd.close();
    }
}