class Plastic {
    @Override
    public String toString() {
        return "I am a Plastic";
    }
}

class Toy extends Plastic {
    @Override
    public String toString() {
        return "I am a Toy";
    }
}

class BoxHandler_g3 {
    public static void outBox(Box_g3<? extends Toy> box) {
        Toy t = box.get();
        System.out.println(t);
        // 여기서는 Box에 담긴 객체를 받아오는 것만 할 수 있음
        // -> Box의 제네릭 타입을 Toy타입을 상속하는 하위 클래스 타입만 허용하면
        // Toy <-- Car : box.set(new Toy())은 box의 제네릭 타입이 Toy의 하위 클래스 형일 수 있으므로 불가능 하다.
    }

    public static void inBox(Box_g3<? super Toy> box, Toy n) {
        box.set(n);
        // Toy t = box.get();
        // 여기서는 Box에 객체를 담는 작업만 할 수 있음
        // -> Box의 제네릭 타입 Toy가 상속하고 있는 상위 클래스 타입만 허용하면
        // Plastic <-- Toy : Toy t = box.get()은 box의 제네릭 타입이 Toy의 상위 클래스 형일 경우 불가능 하다.
    }
}

class Box_g3<T> {
    private T ob;

    public void set(T o) {
        ob = o;
    }

    public T get() {
        return ob;
    }
}

public class _1005_basic_generic_3 {
    public static void main(String[] args) {
        Box_g3<Toy> box = new Box_g3<>();
        BoxHandler_g3.inBox(box, new Toy());
        BoxHandler_g3.outBox(box);
    }
}
