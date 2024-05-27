import java.util.Locale;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        // Creating nested objects
        C c = new C();
        B b = new B(c);
        A a = new A(b);

        // Facultatif
        // Creating Optional object with value a
        // Optional<A> optionalA = Optional.of(a);

        // Instead of if C is null, B is null and C is null, use Optional
        String value = Optional.of(a).map(A::getB)
                .map(B::getC)
                .map(C::getValue)
                .orElse("default");

        System.out.println("nested class optional chaining test= " + value.toUpperCase());

        // Without nested classes instead of(if values == null) value = c.getValue();
        value = Optional.of(c).map(C::getValue).orElse("default");

        System.out.println("without nested class test= " + value.toUpperCase());
    }

    static class A {
        private B b;

        public A(B b) {
            this.b = b;
        }

        public B getB() {
            return b;
        }
    }

    static class B {
        private C c;

        public B(C c) {
            this.c = c;
        }

        public C getC() {
            return c;
        }
    }

    static class C {
        private String value;

        public C(){}
        public C(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
}