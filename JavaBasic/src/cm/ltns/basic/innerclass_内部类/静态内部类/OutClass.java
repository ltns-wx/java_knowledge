package cm.ltns.basic.innerclass_内部类.静态内部类;

/**
 * 静态内部类：如果使用static修饰一个内部类，那么这个内部类就属于外部类本身，而不属于外部类对象
 *
 * 二、静态内部类成员：
 *      可以包含静态成员变量、也可以包含非静态变量
 *
 * 三、访问：
 *    内部类 ---访问--->外部类：根据静态不能访问非静态成员的规则，静态内部类不能访问外部类的实例成员
 *                           即使是内部类的实例，也不能访问外部类的静态成员
 *    问题：为什么静态内部类的实例对象，也不允许访问外部类的成员变量
 *         因为：静态内部类是外部类的类相关联，并不是外部类对象相关联。（在一个类中，静态成员不能访问非静态成员）
 *    外部类----访问--->静态内部类：外部类依然不能直接访问内部类的成员。但是可以使用内部类的类名作为调用者来访问静态内部类的静态成员。
 *         也可以使用静态内部类对象来访问静态内部类的实例成员。
 *
 **  四、外部类变量、 内部类变量、 内部类方法局部变量的访问：（变量名 str）
 *        外部类变量：外部类.this.str
 *        内部类变量：this.str
 *        内部类方法局部变量访问：str
 *
 */
public class OutClass {

    private String outString = "外部类普通变量";
    private static String outStaticString = "外部类静态成员变量";
    private static String str = "外部类静态变量";

    public void outFun() {
        System.out.println("外部类可以使用静态内部类的类，来访问静态内部类的静态成员" + staticInnerClass.innerStaticString);
        System.out.println("外部类可以使用内部类对象来访问成员变量和方法" + new staticInnerClass().innerString);

    }

    // 静态内部类
    public static class staticInnerClass {
        // 1.静态内部类可以包含静态成员、也可以包含非静态成员
        public String innerString = "静态内部类普通变量";
        public static String innerStaticString = "静态内部类静态常量";
        private static String str = "内部类静态变量";

        //2.静态内部类可以包含普通初始化代码块，也可以包含静态代码块
        // 普通初始化代码块
        {
            System.out.println("内部类普通代码块");
        }

        // 静态代码块
        static {
            System.out.println("内部类静态代码块");
        }

        public staticInnerClass(){
            System.out.println("静态内部类的构造器");
        }

        //静态内部类不只能访问外部类的静态成员
        public void innerFun() {
//            System.out.println("静态内部类，不能访问外部类的成员变量" + outString);
            System.out.println("静态内部类，可以方位外部类的静态成员" + outStaticString);
        }

        // 静态内部类的访问方式：
        public void innerFun2() {
            String str = "局部变量";
            System.out.println("内部类方法访问局部变量：" + str);
            System.out.println("内部类方法访问内部类静态变量：" + staticInnerClass.str);
            System.out.println("内部类方法访问外部类变量：" + OutClass.str);
        }
    }
}
