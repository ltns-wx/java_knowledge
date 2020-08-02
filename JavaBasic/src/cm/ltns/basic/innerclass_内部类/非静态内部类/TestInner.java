package cm.ltns.basic.innerclass_内部类.非静态内部类;

/**
 * 在其他类中，访问某个类的非静态类内部类
 */
public class TestInner {
    public static void main(String[] args) {
        OutClass out = new OutClass();
        OutClass.InnerClass innerClass = out.new InnerClass();
        innerClass.innerFun();
    }
}

