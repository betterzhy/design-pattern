package daynamicproxy;

public class Person implements Movable {

    @Override
    public void move() {
        System.out.println("人在行走");
    }
}
