package cm.ltns.basic.gc_垃圾回收.demo1;

import java.lang.ref.WeakReference;

/**
 * 对象的强、软（SoftReference）、弱（WeakReference）、虚引用(PhantomReference)
 *
 * 一、强引用：是指那些可到达状态的对象
 *
 * 二、软引用（SoftReference）
 *    软引用需要通过SoftReference类来实现，当一个对象只有软引用时，它有可能被垃圾回收机制回收，
 *    对于只有软引用的对象而言，当系统空间充足时，他不会被系统回收，当系统内存空间不足时，系统可能会回收它
 *
 * 三、弱引用（WeakReference）
 *     弱引用通过WeakReference类实现，弱引用和软引用很像，但是弱引用的引用级别更低。对于只有弱引用的对象而言，
 *     当系统垃圾回收机制运行时，不管内存是否足够，总会回收该对象所占的内存。
 *
 * 四、虚引用（PhantomReference）
 *    虚引用是通过PhantomReference类实现的，如果一个对象只有一个虚引用，那么它和没有引用的效果大致相同，
 *    虚引用主要用于跟踪对象被垃圾回收的状态，虚引用不能单独使用，必须和引用队列（ReferenceQueue）联合使用
 *
 *    软应用、弱引用、虚引用，都包含一个get方法，用于获取被他们所引用的对象。
 *
 */

// 弱引用所引用的对象被系统垃圾回收过程
public class GCDemo2 {
    public static void main(String[] args) {
        // 创建一个字符串对象
        String str = new String ("好久不见");
        // 创建一个弱引用
        WeakReference wr = new WeakReference(str);

        //切断str引用和“好久不见”字符串之间的引用
        str = null;
        //取出弱引用所引用的对象
        System.out.println(wr.get());
        //强制垃圾回收
        System.gc();
        System.runFinalization();
        // 再次取出弱引用所引用的对象
        System.out.println(wr.get());

    }
}
