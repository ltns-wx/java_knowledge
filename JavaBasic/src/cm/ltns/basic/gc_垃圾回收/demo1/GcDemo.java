package cm.ltns.basic.gc_垃圾回收.demo1;

/**
 * 垃圾回收
 * 一、垃圾回收特征：
 *      1.垃圾回收机制只负责回收堆内存的对象，不会回收任何物理资源（例如数据库连接和网络IO等资源）
 *      2.程序无法精确控制垃圾回收的运行
 *      3.在垃圾回收机制回收任何对象之前，都会调用改对象的finalize()方法，该方法可能会让对象复活
 *
 * 二、对象在内存中的状态
 *      1.可到达状态
 *      2.可恢复状态
 *      3.不可达状态
 *
 * 三、一个对象可以被一个局部变量引用、也可以被其他类的类变量应用、或者被其他对象实例变量引用。他们的生命周期都是不一样的
 *     局部变量：
 *     类变量：只有该类被销毁是，对象才可能进入可恢复状态
 *     实例变量：只有改对象被销毁时，该对象才进入可恢复状态
 *
 * 四、强制垃圾回收：程序无法精确控制java垃圾回收的时机，但是我们依然可以强制系统进行垃圾回收，这种强制只是通知系统进行垃圾
 *    强制系统垃圾收回有两种方法:
 *      1.System.gc();
 *      2.Runtime.getRuntime.gc();
 *
 * 五、finalize()方法
 *      任何java类都可以重写Object类中的finalize()方法，在方法中清理该对象占用的资源。如果程序在终止之前没有进行垃圾回收，则不会
 *      调用finalize()方法来清理资源。
 *      垃圾回收机制何时调用对象的finalize()方法是完全透明的，只有程序认为需要更多的额外内存时，垃圾回收机制才会进行垃圾回收。
 *      特别注意：
 *          1.永远不要主动调用该方法
 *          2.finalize()方法调用具有不确定性， 不要把该方法当成一定被执行的方法
 *          3.当JVM调用该方法出现异常，垃圾回收机制不会报告异常，程序继续执行
 *
 */
public class GcDemo extends Object{

    public static void main(String[] args) {
        for (int i = 0; i<4; i++){
            new GcDemo(); // 创建匿名对象，立即进入可恢复状态，等待系统回收，但是如果不强制回收（System.gc()），则在程序退出，系统任然不会回收该资源
            System.gc();
        }

        /**
         * 这个循环、虽然System.gc()，但是也是可以调用finalize()方法，从这可以看出垃圾回收机制是在系统任务需要更多内存的时候才会去进行垃圾回收
         */
        for (int i = 0; i> -1; i++){
            new GcDemo(); // 创建匿名对象，立即进入可恢复状态，等待系统回收，但是如果不强制回收（System.gc()），则在程序退出，系统任然不会回收该资源
        }
    }

    public void finalize(){
        System.out.println("系统正在清理GcDemo对象");
    }
}
