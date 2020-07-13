package cm.ltns.basic.interface_.demo1;

/**
 *
 * // 创建的修饰符： public / default / private / protected
 * 一、接口定义： 修饰符 interface 接口名称
 *  1.接口的修饰符只能是public 或者是 不写
 *
 *  二、接口中不允许有静态代码块和初始化代码块：
 *     因为：初始化代码块是在类创建之前进行调用、而接口并不能创建对象
 *
 *  三、接口是一种规范，接口中不能有构造函数（从而，创建的常量一定要赋值）
 *
 *  四、接口的变量默认是：public static final 修饰，并且只能用着三个修饰
 *
 *  五、接口的使用
 *      1.类是实现接口 implements
 *      2.接口之间用继承 extend
 *
 *  JDK8 的新特性：
 *  一、可以定义静态方法，也可以定义默认方法
 *
 */
public interface InterfaceDemo {

//    static {
//        System.out.println("aa");
//    }

//    {
//        System.out.println("bbb");
//    }

    // 定义全局常量
    public static final String str1 = "aa";
    String str = "bb";

    // 定义抽象方法
    public abstract void fun1();

    void fun2();

}


interface a {

}

// 接口之间用的是继承
interface b extends a {

}

interface c {

}

// 类和接口之间用的是实现
class test implements a, c {

}

