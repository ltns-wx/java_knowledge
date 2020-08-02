package cm.ltns.basic.interface_接口.Demo4;

/**
 *  接口继承问题：
 *      1.静态常量继承
 *      2.方法继承
 *   多继承接口（不能多继承类）
 *      如果多继承导致变量名和方法冲突，那么具体使用哪个、是根据多态来决定的。
 *
 *  接口中默认方法冲突问题：参考jdk1.8的新特性
 */
public class Test4 implements A{

    @Override
    public void fun() {

        System.out.println("aaaa");
    }

    public static void main(String[] args) {
        A test4 = new Test4();
        System.out.println(test4.a);
    }
}

interface  A {
    String a  = "aa";
    public abstract void fun();
}

interface B {
    public static final String a = "bb";
    public abstract void fun();
}
