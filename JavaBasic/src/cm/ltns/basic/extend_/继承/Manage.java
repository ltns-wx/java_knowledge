package cm.ltns.basic.extend_.继承;

public class Manage extends Employee {

    /**
     * 一、继承时构造器的问题：
     *  1.子类的构造函数中，会默认调用父类的无参构造函数，因为子类会继承夫类的所有字段，所以夫类的字段初始化要使用夫类的构造器。
     *  2.如果父类没有构造函数，那么就需要显示的调用构造函数。super(参数，参数...)的方式调用
     *  3.
     *
     *  二、override 重写的问题：重写的规则：两同、两小、一大
     *      两同：即方法名和形参列表相同
     *      两小：1.指子类方法返回值类型比父类方法返回值类型更小或者相等。
     *          2.子类方法抛出的异常比父类方法抛出的异常更小或者相等
     *      一大：即子类方法的访问权限应比父类方法的访问权限更大或者相等
     *
     *  三、super关键字
     *      1.super可以调用父类的字段和方法，所以super和this关键字一样，不能出现在static修饰的方法中
     *      2.系统会根据super（参数列表）调用里传入的实参列表调用夫类的构造器。
     */

    private final char value[] = null;
    private final char[] value1 = null;

    public Manage() {
//        super();
        System.out.println("Manage 的无参构造函数");
    }

    @Override
    public void run(){
        System.out.println("这是子类的run方法");
    }
}
