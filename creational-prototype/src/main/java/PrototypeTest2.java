import java.io.*;

public class PrototypeTest2 {
    public static void main(String[] args) throws CloneNotSupportedException {
        C c = new C();
        D d1 = new D();
        d1.setC(c);

        D d2 = (D) d1.clone();
        System.out.println(d1.getC());
        System.out.println(d2.getC());

    }
}

class C implements Serializable {

}

class D implements Cloneable, Serializable {
    static final long serialVersionUID = 42L;

    private C c;

    public C getC() {
        return c;
    }

    public void setC(C c) {
        this.c = c;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(this);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        try {
            ObjectInputStream ois = new ObjectInputStream(bis);
            return (D) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
