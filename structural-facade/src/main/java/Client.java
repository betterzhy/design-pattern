public class Client {
    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.task();

        // 不使用外观模式
//        SubSystem subSystem = new SubSystem();
//        subSystem.prepare();
//        if(true){
//            subSystem.doSomething1();
//        }else {
//            subSystem.doSomething2();
//        }
//        subSystem.clean();
    }
}

class Facade {
    SubSystem subSystem;

    Facade() {
        subSystem = new SubSystem();
    }

    void task() {
        subSystem.prepare();
        if (true) {
            subSystem.doSomething1();
        } else {
            subSystem.doSomething2();
        }
        subSystem.clean();
    }
}

class SubSystem {
    void prepare() {

    }

    void doSomething1() {

    }

    void doSomething2() {

    }

    void clean() {

    }

}

