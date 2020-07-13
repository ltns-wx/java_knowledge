package cm.ltns.basic.interface_.demo2;

/**
 * 简单的接口示例：
 *  场景：USB接口
 */
public class InterfaceUse {
    public static void main(String[] args) {
        Computer computer = new Computer();

        Flash flash = new Flash();
        computer.transterDate(flash);
    }
}

// 定义USB接口
interface USB {

    public abstract void start();

    void stop();
}

// 定义闪存盘类
class Flash implements USB {

    @Override
    public void start() {
        System.out.println("闪存盘开始工作");
    }

    @Override
    public void stop() {
        System.out.println("闪存盘停止工作");
    }
}

// 定义打印机对象
class Printer implements USB {
    @Override
    public void start() {
        System.out.println("打印机开始工作...");
    }

    @Override
    public void stop() {
        System.out.println("打印机停止工作...");
    }
}

//定义电脑使用USB的方法
class Computer {
    // 传输数据
    public void transterDate(USB usb) {
        usb.start();
        System.out.println("具体的传输数据");
        usb.stop();
    }
}
