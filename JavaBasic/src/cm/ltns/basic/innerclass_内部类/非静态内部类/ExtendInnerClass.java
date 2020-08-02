package cm.ltns.basic.innerclass_内部类.非静态内部类;

/**
 * 继承非静态内部类
 * 一、方式extends OutClass.InnerClass：外部类.非静态内部类
 *
 * 二、调用非静态内部类的构造器是，必须有非静态内部类的对象。
 *     在一般继承的情况加，实例化子类，构造其中会默认调用父类的构造器即：super
 *     但是在非静态内部类中，如果需要实例化非静态内部类， 就必须使用外部类对象，
 *     所以，非静态内部类的子类为什么要用out.super()来显示调用。
 *
 */
public class ExtendInnerClass extends OutClass.InnerClass{

    // 调用子类构造器的时候，必须要调用父类的构造器，所有必须有外部类对象
    public ExtendInnerClass(OutClass out){
        out.super(); //super 代表内部类的静态方法.
    }

    public static void main(String[] args) {
        OutClass out = new OutClass();
        ExtendInnerClass extendInnerClass = new ExtendInnerClass(out);
    }
}
