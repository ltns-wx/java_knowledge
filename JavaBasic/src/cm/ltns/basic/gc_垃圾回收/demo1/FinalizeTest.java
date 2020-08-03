package cm.ltns.basic.gc_垃圾回收.demo1;

/**
 *  finalize()方法并不一定会执行，因为如果想要清理某个类里打开的资源文件，则不会放在finalize()方法中进行清理
 */

// 演示如果在finalize方法里复活自身
public class FinalizeTest {
    private static FinalizeTest finalizeTest = null ;
    public void info(){
        System.out.println("测试资源清理的finalize方法");
    }

    public static void main(String[] args) throws InterruptedException {
        // 创建FinalizeTest对象，立即进入可恢复状态
        new FinalizeTest();
        // 通知系统进行资源回收
        System.gc();
        /**
         * 睡眠2s：
         * 这里当程序调用System.gc()后，系统并没有立即进行垃圾回收，而是有一定的时间差
         * 等待两秒，程序暂停，垃圾回收机制也收到了通知，因此开始进行垃圾回收，调用finalize()方法
         *
         * 除此之外，System和Runtime类里都提供了一个runFinalization方法，可以强制垃圾回收机制进行垃圾回收
         * 因此，我们可以不需要让程序等待两秒，如下面例子
         *
         */
//        Thread.sleep(2000);
        // 强制垃圾回收机制进行垃圾回收，调用finalize()方法
        System.runFinalization();
        finalizeTest.info();
    }
    public void finalize(){
        //让finalizeTest 引用试图回到可到达状态
        finalizeTest = this;
    }
}
