package cm.ltns.basic.泛型.泛型派生子类;

import java.util.Date;

/**
 *  泛型类派生子类
 *  一、当创建了带泛型声明的接口或者是父类之后，可以为该类创建实现类，或者从该父类派生子类
 *      但是需要指出的是，当使用这些接口、父类时不能再包含类型形参。class A extends Apple<T>{} 错误的写法，T要指定明确类型
 *      当然也可以不传，那么T默认是Object类型
 *  二、泛型类的子类也可以是泛型类：class test<T> extends A<T>{}
 *
 */
public class Apple2 {
    public static void main(String[] args) {
        //1.实例化泛型类
        A<String> a = new A<String>();

        //2.多态的形式实例化泛型子类， 这个时候A一定要加上 泛型说明，不然是Object
        A<String> a1 = new SubA();
        a1.fun("long time no see"); // fun参数类型和A<String> 一样

        // 不加泛型说明
        A sa2 = new SubA();
        sa2.fun(new Date()); // fun里面的参数是Object类型

        // 3.实例化子类
        SubA sa = new SubA();
        sa.fun("String");


    }

}

//泛型类的子类也可以是泛型类
class SubA2<T> extends A<T> {

    public SubA2(T t) {

    }
}

class SubA extends A<String> {


}

class A<T> {
    // 泛型变量
    private T t;// 泛型类的构造器是不需要加泛型


    // 该方法并不是泛型方法
    public void fun(T t) {
        System.out.println("泛型类型" + t.getClass());
    }

}