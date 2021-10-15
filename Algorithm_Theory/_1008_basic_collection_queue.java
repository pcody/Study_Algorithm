import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

interface DIStack<E> {
    public boolean push(E item);

    public E pop();
}

class DCStack<E> implements DIStack<E> {
    private Deque<E> deq;

    public DCStack(Deque<E> d) {
        deq = d;
    }

    public boolean push(E item) {
        return deq.offerFirst(item);
    }

    public E pop() {
        return deq.pollFirst();
    }
}

public class _1008_collection_queue {
    public static void main(String[] args) {

        ////////////////////////////////////////////////////////////
        // 큐
        Queue<String> que = new LinkedList<>();
        que.offer("Box");
        que.offer("Toy");
        que.offer("Robot");

        System.out.println("next: " + que.peek());

        System.out.println(que.poll());
        System.out.println(que.poll());

        System.out.println("next: " + que.peek());
        System.out.println(que.poll());

        ////////////////////////////////////////////////////////////
        // 스택
        // Deque<String> deq = new ArrayDeque<>(); // 배열 기반
        Deque<String> deq = new LinkedList<>(); // 링크드리스트 기반
        deq.offerFirst("1. Box");
        deq.offerFirst("2. Toy");
        deq.offerFirst("3. Robot");

        System.out.println(deq.pollFirst());
        System.out.println(deq.pollFirst());
        System.out.println(deq.pollFirst());

        // 스택 실수 방지를 위한 직접 구현
        DCStack<String> stk = new DCStack<>(new ArrayDeque<>());
        // DCStack<String> stk = new DCStack<>(new LinkedList<>());
        stk.push("1. Box");
        stk.push("2. Toy");
        stk.push("3. Robot");

        System.out.println(stk.pop());
        System.out.println(stk.pop());
        System.out.println(stk.pop());
    }
}
