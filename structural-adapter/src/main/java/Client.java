public class Client {
    public static void main(String[] args) {
        Plug plug = new Plug();

        Phone phone = new Phone();
        PhoneAdapter phoneAdapter = new PhoneAdapter(plug);
        phone.charge(phoneAdapter.outputRatedVoltage());

        Computer computer = new Computer();
        ComputerAdapter computerAdapter = new ComputerAdapter(plug);
        computer.charge(computerAdapter.outputRatedVoltage());

    }
}

class Phone {
    void charge(int input) {
        System.out.println("手机充电中, 电压: " + input + "V");
    }
}

class Computer {
    void charge(int input) {
        System.out.println("电脑充电中, 电压: " + input + "V");
    }
}

interface Adapter {
    // 输出额定电压
    int outputRatedVoltage();
}

// 手机适配器
class PhoneAdapter implements Adapter {
    private Plug plug;

    public PhoneAdapter(Plug plug) {
        this.plug = plug;
    }

    @Override
    public int outputRatedVoltage() {
        int output = plug.output220v();
        output -= 215; // 复杂的转换(适配)过程
        return output;
    }
}


// 手机适配器
class ComputerAdapter implements Adapter {
    private Plug plug;

    public ComputerAdapter(Plug plug) {
        this.plug = plug;
    }

    @Override
    public int outputRatedVoltage() {
        int output = plug.output220v();
        output -= 200; // 复杂的转换(适配)过程
        return output;
    }
}

// 插板
class Plug {
    int output220v() {
        return 220;
    }
}