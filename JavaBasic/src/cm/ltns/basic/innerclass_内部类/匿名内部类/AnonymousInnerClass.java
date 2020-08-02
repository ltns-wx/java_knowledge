package cm.ltns.basic.innerclass_内部类.匿名内部类;

/**
 *  匿名内部类：适合创建那种只需要使用一次的类。
 *  一、格式： new 父类构造器|实现接口(参数){ 内容 }
 *
 *  二、匿名内部类必须继承一个父类或者实现一个借口，但是最多只能继承一个父类或者一个实现一个接口
 *     匿名内部类没有构造器、因为他没有名字；
 *
 *  三、匿名内部类需要访问局部变量变量，那么该成员变量一定要用final修饰
 *      在jdk1.8,final 可以忽略不写，但是，编译会自动加上
 *
 *  四、为什么匿名内部类访问局部变量，局部变量必须用final修饰
 *      看下面的例子， 如果不是final修饰，那么在System.out.println("访问外部类的常量" + str); 之后，str就会失效，
 *      那么在 product.productFun();就会出现str为null的现象，
 *      为了防止，才需要final修饰，把修饰的变量放在常量池中。
 *
 */
public class AnonymousInnerClass {

    private String str = "final修饰的常量";

    public void fun() {
         String str = "局部变量";
        // product  就是一个匿名对象   后面的就是匿名类
        Product product = new Product() {
            @Override
            public void productFun() {
                System.out.println("访问外部类的常量" + str);
                System.out.println("访问外部类的常量" + AnonymousInnerClass.this.str);
                System.out.println("匿名对象实现的方法");
            }
        };
        product.productFun();
//        str = "修改局部变量";
        this.str = "修改成员变量";

    }

    public static void main(String[] args) {
        AnonymousInnerClass anonymousInnerClass = new AnonymousInnerClass();
        anonymousInnerClass.fun();

    }

}

interface Product {
    public void productFun();
}

