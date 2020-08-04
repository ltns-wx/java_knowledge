package cm.ltns.basic.泛型.demo1;

import java.util.List;

/**
 * 一、创建泛型类，为该类定义构造器时，构造器还是原来的类名，不要增加泛型生命
 *
 * 二、再静态代码块、 静态方法、 静态变量中，不允许使用泛型
 */
public class Apple<T> {

    private T t ;
    //泛型类构造器，不需要加泛型说明
    public  Apple(){

    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}

/**
 *  泛型类派生子类
 *  一、当创建了带泛型声明的接口或者是父类之后，可以为该类创建实现类，或者从该父类派生子类
 *      但是需要指出的是，当使用这些接口、父类时不能再包含类型形参。class A extends Apple<T>{} 错误的写法，T要指定明确类型
 *      当然也可以不传，那么T默认是Object类型
 *  二、
 */
class A extends Apple<String>{ }

class B{
    // 传入Apple对象， 但是Apple泛型类又不确定，这时候可以使用通配符
    public void fun(Apple<?> a){

    }

    public <T> void fun1 (Apple<T> a){

    }

    public void test(List<?> list){

    }
    public <T> void test2(List<T> list){

    }

    public static void main(String[] args) {
        B b = new B();
        b.fun1(new Apple<String>());
    }
}