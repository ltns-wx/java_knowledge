package cm.ltns.basic.泛型.泛型类;

import java.util.List;

/**
 * 泛型：就是允许在定义类、接口和方法的时候使用类型形参，这个类型形参在声明变量、创建对象、实现接口时动态指定。
 *
 * 一、创建泛型类，为该类定义构造器时，构造器还是原来的类名，不要增加泛型生命
 *
 * 二、再静态代码块、 静态方法、 静态变量中，不允许使用泛型
 */
public class Apple<T> {

    private T t;

    //泛型类构造器，不需要加泛型说明
    public Apple() {

    }
    // 该方法不属于泛型方法
    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public void fun(T t) {
        System.out.println("泛型类型" + t.getClass());
    }

    public static void main(String[] args) {
        Apple<String> a = new Apple<>();
        a.setT("long time no see");
        System.out.println(a.getT());
        a.fun("好久不见");
    }
}
