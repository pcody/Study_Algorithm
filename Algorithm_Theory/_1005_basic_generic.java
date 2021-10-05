class DBox<L, R> {
    private L left;
    private R right;

    public void set(L o, R r) {
        left = o;
        right = r;
    }

    public String toString() {
        return left + " & " + right;
    }
}

class DDBox<T1, T2> {
    private T1 ob1;
    private T2 ob2;

    public void set(T1 t1, T2 t2) {
        ob1 = t1;
        ob2 = t2;
    }

    public String toString() {
        return ob1.toString() + "\n" + ob2.toString();
    }
}

// 제네릭 타입의 클래스 구현해보기
// 박스에 박스 넣기
public class _1005_basic_generic {
    public static void main(String[] args) {
        DBox<String, Integer> box1 = new DBox<>();
        box1.set("Apple", 25);
        DBox<String, Integer> box2 = new DBox<>();
        box2.set("Orange", 33);
        DDBox<DBox<String, Integer>, DBox<String, Integer>> ddbox = new DDBox<>();
        ddbox.set(box1, box2);
        System.out.println(ddbox);
    }
}