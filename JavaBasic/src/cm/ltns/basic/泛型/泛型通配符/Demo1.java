package cm.ltns.basic.泛型.泛型通配符;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

/**
 * 通配符：
 * 一、拿List集合来说，我们知道List<Object> 并不是List<String>的父类，所以，为了表示List的父类，我们需要
 * 使用通配符，类型通配符是一个问号（?）
 * 二、这种通配符的List表示各种泛型List的父类，并不把元素放在其中。
 * <p>
 * 三、通配符和泛型方法的区别
 * <p>
 * 四、泛型的PECS原则（Producer Extends Consumer Super）原则
 * 1.无界通配符：List<?>
 * 2.上边界限定通配符<? extends superclass>： 问号为superclass的子类
 * List<? extends Number> list表示某种特定类型（Number或者Number的子类）对象的List。跟无边界通配符一样，
 * 因为无法确定持有的实际类型，所以这个List也不能add除null外的任何类型的对象。
 * 3.
 */
public class Demo1 {


    public void printList(List<?> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    // 这里编译不通过，因为List<?> 这种通配符，并不能确定泛型的类型
    public void test() {
        List<?> list = new ArrayList<String>();
//        list.add("aa");  // 编译错误
    }

    /**
     * 无界通配符：List<?> list和List list的区别：
     * 1.List<?> list是表示持有某种特定类型对象的List，但是不知道是哪种类型；List list是表示持有Object类型对象的List。
     * 因为List<?>不知道明确的类型，所以不能进行add操作。
     * 2.List 是持有Object类型对象，所以可以add任何类型的对象。
     * 注意：List<?> list可以add(null)，因为null是任何引用数据类型都具有的元素。
     * <p>
     * 下边界限定的通配符：List<? super Integer> list表示某种特定类型（Integer或者Integer的父类）对象的List
     * 可以确定这个List持有的对象类型肯定是Integer或者其父类，所以往list里面add一个Integer或者其子类的对象是安全的，
     * 因为Integer或者其子类的对象都可以向上转型为Integer的父类对象。但是因为无法确定实际类型，
     * 所以往list里面add一个Integer的父类对象是不安全的。
     */
    public void test1() {
        List list = new ArrayList();
        list.add(new Object());

        List<?> list1 = new ArrayList<String>();
//        list1.add(new Object());

    }

    /**
     * 上边界限定的通配符
     */
    public void extendTest() {
        // 声明  ：？是Number的子类，
        List<? extends Number> list = new ArrayList<Integer>(); // OK
//        List<? extends Number> list = new ArrayList<Object>(); // error

        // 存放：list是不确定的，所以不能添加
//        list.add(new Integer(1)); // error
        list.add(null); // OK

        // 读取：从list中获取对象是是可以的（比如get(0)），因为在这个List中，不管实际类型是什么，但肯定都能转型为Number。
        Number n = list.get(0); // OK
//        Integer i = list.get(0); // error

    }

    /**
     * 下边界限定的通配符
     */
    public void superTest() {
        /**
         * 声明：可以确定这个list持有的对象类型肯定是Integer或者是其父类，所以忘其中add添加Number的子类或者是Number对象是可以的
         *      但是无法确定时机类型
         */

        List<? super Number> list = new ArrayList<Number>(); // OK
        List<? super Number> list2 = new ArrayList<Object>(); // OK
//        List<? super Number> list3 = new ArrayList<Integer>(); // error Integer不是Number的父类


        /**
         * 添加：往其添加Integer对象或者是其子类是可以的
         */
        list.add(new Integer(1)); // OK
//        list.add(new Object()); // error

        //读取：JVM在编译的时候知道实际类型可以是任何Integer的父类，所以为了安全起见，用一个最顶层的父类对象来指向取出来的数据
        Object obj = list.get(0); // OK
//        Integer i = list.get(0); // error
    }

    public static void main(String[] args) {
    }
}
