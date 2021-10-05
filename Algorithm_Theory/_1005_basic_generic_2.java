class Eatable {
    public String eat() {
        return "You can eat this!";
    }
}

class Apple extends Eatable {
    public String toString() {
        return "I am an apple.";
    }

    @Override
    public String eat() {
        return "It tastes so good!";
    }
}

class Box_g2<T extends Eatable> {
    T ob;

    public void set(T o) {
        ob = o;
    }

    public T get() {
        System.out.println(ob.eat());
        return ob;
    }
}

public class _1005_basic_generic_2 {
    public static void main(String[] args) {
        // Box_g2<Eatable> box = new Box_g2<Apple>(); // Apple과 Eatable이 상속관계여도 생성 불가능

    }
}
