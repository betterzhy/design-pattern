public class PrototypeTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        A a = new A();

        B b = new B();
        b.setA(a);

        B b2 = b.clone();

        System.out.println(b.getA());
        System.out.println(b2.getA());
    }
}

class A implements Cloneable {
    @Override
    protected A clone() throws CloneNotSupportedException {
        return (A) super.clone();
    }
}

class B implements Cloneable {
    private A a;

    public void setA(A a) {
        this.a = a;
    }

    public A getA() {
        return a;
    }

    @Override
    protected B clone() throws CloneNotSupportedException {
        B copy = (B) super.clone();
        copy.setA(a.clone());
        return copy;
    }
}