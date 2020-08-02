package cm.ltns.basic.innerclass_内部类.非静态内部类;

/**
 * 成员：1.非静态内部类、2.静态内部类
 * 非静态内部类
 *  一、内部类的修饰符
 *      外部类的上已经是包，所以它只有2个作用域，public和缺省（只能在本包下访问）
 *      内部类：的上一级是程序类，所以他的作用域和普通类的字段一样，有四个访问权限：public、 protect、 缺省、 private
 *
 *  二、编译结果：外部类$内部类，class
 *
 *  二、非静态内部类成员，不能包含静态的内容：静态变量、 静态代码块、以及静态方法、
 *     原因：
 *
 *  三、访问：
 *      1. 非静态内部类  --访问--> 外部类：可以访问外部类的所有的成员：因为在非静态内部类中，保存了一个它寄存的外部类对象的引用。
 *      2.外部类  --> 访问非静态内部类 ： 不能直接访问、只能通过初始化
 *
 *  三、内部类的访问优先级
 *      在非静态内部类中的某个方法访问某个变量时，系统有限在该方法中查找是否有改变了，如果有直接使用
 *      如果没有，则找内部类是否有该变量，如果有直接使用，
 *      如果没有，则找外部类知否有该变量，如果有，则直接使用，如果没有，则编译报错。
 *      即优先级：局部变量 > 内部类 > 外部类
 *
 *  四、外部类变量、 内部类变量、 内部类方法局部变量的访问：（变量名 str）
 *      外部类变量：外部类.this.str
 *      内部类变量：this.str
 *      内部类方法局部变量访问：str
 *
 *  五、在其他类中访问某个类的非静态内部类
 *      外部类.内部类 in = 外部类对象.new 内部类构造器();
 *
 *  五、非静态内部类对象、 和外部类对象的关系
 *      非静态内部类必须寄存在外部类对象里，而外部类不一定有非静态内部类对象。
 *      所以，这就是为什么非静态内部类可以直接访问外部类的所有成员，而外部类不能直接访问内部类的成员，必须显示的去访问（new）
 *
 *
 */
public class OutClass {
    private String outString = "外部类普通变量";
    private String str = "外部类非静态变量";
    private static String staticStr = "外部类静态变量";

    // 外部类方法
    public void outFun() {
        System.out.println("外部类方法");
        InnerClass ic = new InnerClass();
        ic.innerFun();
    }

    public static void main(String[] args) {
        OutClass oc = new OutClass();
        oc.outFun();
    }


    // 非静态内部类
    public class InnerClass {

        private String str = "内部类静态变量";
//        private static staticStr ="内部类静态变量";  // 非静态内部类不能包含静态成员、

        {
            System.out.println("内部类初始化代码块");
        }

//        static {
//            System.out.println("内部类静态初始化代码块");
//        }

        public InnerClass(){
            System.out.println("非静态内部类的方法");
        }

        // 非静态内部类既可以访问外部类的所有变量，方法
        public void innerFun() {
            String  str = "内部类局部变量";
            System.out.println(str);
            System.out.println(this.str);
            System.out.println(OutClass.this.str);
        }
    }
}
