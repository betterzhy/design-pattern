public class Client {
    public static void main(String[] args) {
        Component camera = new ConcreteWrapper1(new ConcreteComponent());
        camera.operation();
        System.out.println();
        Component camera2 = new ConcreteWrapper2(new ConcreteComponent());
        camera2.operation();
        System.out.println();
        Component camera3 = new ConcreteWrapper2(new ConcreteWrapper1(new ConcreteComponent()));
        camera3.operation();
    }
}


interface Component {
    void operation();
}

class ConcreteComponent implements Component {
    @Override
    public void operation() {
        System.out.println("基础功能");
    }
}

abstract class Wrapper implements Component {
    Component component;

    public Wrapper(Component component) {
        this.component = component;
    }

    @Override
    public abstract void operation();
}

class ConcreteWrapper1 extends Wrapper {
    public ConcreteWrapper1(Component component) {
        super(component);
    }

    @Override
    public void operation() {
        this.component.operation();
        System.out.println("增强功能1");
    }
}

class ConcreteWrapper2 extends Wrapper {
    public ConcreteWrapper2(Component component) {
        super(component);
    }

    @Override
    public void operation() {
        this.component.operation();
        System.out.println("增强功能2");
    }
}