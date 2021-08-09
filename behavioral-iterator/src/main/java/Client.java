import java.util.ArrayList;

public class Client {
    public static void main(String[] args) {
        A a = new A();
        Iterator<Integer> iterator = a.createIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        B b = new B();
        Iterator<String> iterator2 = b.createIterator();
        while (iterator2.hasNext()) {
            System.out.println(iterator2.next());
        }
    }
}

interface Iterable<E> {
    Iterator<E> createIterator();
}

class A implements Iterable<Integer> {
    private ArrayList<Integer> items = new ArrayList<>();

    public A() {
        items.add(10);
        items.add(11);
        items.add(10);
        items.add(16);
    }

    public Iterator<Integer> createIterator() {
        return new AIterator(items);
    }
}

class B implements Iterable<String> {
    private String[] items = new String[10];

    public B() {
        items[0] = "one";
        items[1] = "two";
        items[2] = "three";
    }

    public Iterator<String> createIterator() {
        return new BIterator(items);
    }
}

interface Iterator<E> {
    boolean hasNext();

    E next();
}

class AIterator implements Iterator<Integer> {
    ArrayList<Integer> items;
    private int position = 0;

    public AIterator(ArrayList<Integer> items) {
        this.items = items;
    }

    @Override
    public boolean hasNext() {
        return position < items.size();
    }

    @Override
    public Integer next() {
        Integer item = items.get(position);
        position += 1;
        return item;
    }
}

class BIterator implements Iterator<String> {
    String[] items;
    private int position = 0;

    public BIterator(String[] items) {
        this.items = items;
    }

    @Override
    public boolean hasNext() {
        return position < items.length && items[position] != null;
    }

    @Override
    public String next() {
        String item = items[position];
        position += 1;
        return item;
    }
}
