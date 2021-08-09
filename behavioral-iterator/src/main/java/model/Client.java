package model;

public class Client {
    public static void main(String[] args) {
        Aggregate<Integer> concreteAggregate = new ConcreteAggregate();
        Iterator<Integer> iterator = concreteAggregate.createIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}

interface Aggregate<E> {
    Iterator<E> createIterator();
}

interface Iterator<E> {
    boolean hasNext();

    E next();
}

class ConcreteAggregate implements Aggregate<Integer> {

    @Override
    public Iterator<Integer> createIterator() {
        return new ConcreteIterator();
    }
}

class ConcreteIterator implements Iterator<Integer> {

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Integer next() {
        return null;
    }
}