package abstractfactory.demo1;


abstract class Phone {
}

abstract class Computer {
}

class IphoneX extends Phone {
}

class MacBook extends Computer {
}

class HuaweiMate extends Phone {
}

class MateBook extends Computer {
}


// class EmberFactory
class AppleFactory extends AbstractFactory {
    @Override
    public Phone createPhone() {
        return new IphoneX();
    }

    @Override
    public Computer createComputer() {
        return new MacBook();
    }
}

// class EnginolaFactory
class HuaweiFactory extends AbstractFactory {
    @Override
    public Phone createPhone() {
        return new HuaweiMate();
    }

    @Override
    public Computer createComputer() {
        return new MateBook();
    }
}

enum Vender {
    APPLE, HUAWEI
}

public abstract class AbstractFactory {
    private static final AppleFactory APPLE_FACTORY = new AppleFactory();
    private static final HuaweiFactory HUAWEI_FACTORY = new HuaweiFactory();

    // Returns a concrete factory object that is an instance of the
    // concrete factory class appropriate for the given architecture.
    static AbstractFactory getFactory(Vender vender) {
        AbstractFactory factory = switch (vender) {
            case APPLE -> APPLE_FACTORY;
            case HUAWEI -> HUAWEI_FACTORY;
            default -> null;
        };
        return factory;
    }

    public abstract Phone createPhone();

    public abstract Computer createComputer();
}
