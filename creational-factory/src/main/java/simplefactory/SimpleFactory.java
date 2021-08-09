package simplefactory;

abstract class Phone {
}

class IphoneX extends Phone {
}

class IphoneSE extends Phone {
}

enum Brand {
    IPHONEX, IPHONESE
}

public class SimpleFactory {
    static Phone createPhone(Brand brand) {
        return switch (brand) {
            case IPHONEX -> new IphoneX();
            case IPHONESE -> new IphoneSE();
            default -> null;
        };
    }
}