import java.util.Optional;
import java.util.function.Function;

class Friend1014 {
    String name;
    Optional<Company1014> cmp;

    public Friend1014(String n, Optional<Company1014> c) {
        name = n;
        cmp = c;
    }

    public String getName() {
        return name;
    }

    public Optional<Company1014> getCmp() {
        return cmp;
    }
}

class Company1014 {
    String cName;
    Optional<ContInfo1014> cInfo;

    public Company1014(String cn, Optional<ContInfo1014> ci) {
        cName = cn;
        cInfo = ci;
    }

    public String getCName() {
        return cName;
    }

    public Optional<ContInfo1014> getCInfo() {
        return cInfo;
    }
}

class ContInfo1014 {
    Optional<String> phone;
    Optional<String> adrs;

    public ContInfo1014(Optional<String> ph, Optional<String> ad) {
        phone = ph;
        adrs = ad;
    }

    public Optional<String> getPhone() {
        return phone;
    }

    public Optional<String> getAdrs() {
        return adrs;
    }
}

public class _1014_basic_optional {
    public static void main(String[] args) {

        /////////////////////////////////////////////////////////////////////////
        // null 미허용 Optional.of 와 null 허용 Optional.ofNullable
        Optional<String> op1 = Optional.of(new String("aBCd ghDFDFfj"));
        Optional<String> op2 = Optional.ofNullable(null);
        System.out.println(op2);
        // Optional.empty 로 빈 Optional 객체 할당 가능
        op2 = Optional.empty();
        System.out.println(op2);

        /////////////////////////////////////////////////////////////////////////
        // map 메소드
        // map 메소드의 인자를 익명 클래스로 전달
        // Optional<String> op3 = op1.map(new Function<String, String>() {

        // @Override
        // public String apply(String t) {
        // return t.toUpperCase();
        // }

        // });
        // map 메소드의 매개변수를 람다로 전달
        Optional<String> op3 = op1.map(t -> t.toUpperCase());
        // map 의 반환 형은 map 을 호출한 객체와 동일
        Optional<String> op4 = op1.map(t -> t.replace(' ', '_')).map(t -> t.toLowerCase());

        // Optional.ifPresent, Optional.ifPresentOrElse
        // Consumer 를 매개변수로 받으므로 람다, 메소드 참조 형으로 전달
        op1.ifPresent(t -> System.out.println(t)); // aBCd ghDFDFfj
        op2.ifPresent(System.out::println); // 빈 Optional은 출력 안함
        op2.ifPresentOrElse(System.out::println, () -> System.out.println("내용이 없습니다.")); // 비었으므로 Runnable.Run 실행
        op3.ifPresent(System.out::println); // ABCD GHDFDFFJ
        op4.ifPresent(System.out::println); // abcd_ghdfdffj

        /////////////////////////////////////////////////////////////////////////
        // flatMap 메소드
        String op5 = op2.map(t -> t.toString()).orElse("Empty");
        System.out.println(op5); // Empty

        Optional<String> op6 = Optional.of("OpOpOp OpOpOp");
        Optional<String> op7 = op6.map(s -> s.toUpperCase());
        System.out.println(op7.get());
        // flatMap 메소드는 Optional로 감싸서 반환하지 않으므로 Optional로 감싸주어야 함
        // Optional<String> op8 = op6.flatMap(s -> Optional.of(s.toLowerCase()));
        Optional<String> op8 = op6.flatMap(new Function<String, Optional<String>>() {

            @Override
            public Optional<String> apply(String t) {
                return Optional.of(t);
            }

        });
        System.out.println(op8);

        /////////////////////////////////////////////////////////////////////////
        // map, flatMap 비교
        Optional<ContInfo1014> ci = Optional.of(new ContInfo1014(Optional.ofNullable(null), Optional.of("KOREA")));
        String phone = ci.flatMap(c -> c.getPhone()).orElse("There is no phone Number");
        String adr = ci.flatMap(c -> c.getAdrs()).orElse("There is no address");
        System.out.println(phone);
        System.out.println(adr);

        String a = null;
        // map은 Optional로 감싸져서 반환되므로 .get()을 불러야함
        a = ci.map(c -> c.getAdrs()).get().orElse("");
        System.out.println(a);
        a = ci.flatMap(c -> c.getAdrs()).orElse("");
        System.out.println(a);

        /////////////////////////////////////////////////////////////////////////
        // 예제
        Optional<Friend1014> opF = Optional.of(new Friend1014("KIMS", Optional.of(new Company1014("ABC Co.",
                Optional.of(new ContInfo1014(Optional.ofNullable(null), Optional.of("REPUBLIC OF KOREA")))))));
        showCompanyAddr(opF);
    }

    public static void showCompanyAddr(Optional<Friend1014> f) {
        String addr = f.flatMap(Friend1014::getCmp).flatMap(Company1014::getCInfo).flatMap(ContInfo1014::getAdrs)
                .orElse("There is no address information");
        System.out.println(addr);
    }
}
