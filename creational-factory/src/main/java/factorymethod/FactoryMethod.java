package factorymethod;

public class FactoryMethod {
    public static void main(String[] args) {
        PhoneFactory factory = new IphoneXFactory();
        Phone phone = factory.createPhone();
    }
}


abstract class Phone {
}

class IphoneX extends Phone {
}

class IphoneSE extends Phone {
}

enum Brand {
    IPHONEX, IPHONESE
}

class IphoneXFactory implements PhoneFactory {
    @Override
    public Phone createPhone() {
        // TODO
        return new IphoneX();
    }
}

class IphoneSEFactory implements PhoneFactory {
    @Override
    public Phone createPhone() {
        // TODO
        return new IphoneSE();
    }
}

interface PhoneFactory {
    Phone createPhone();
}

