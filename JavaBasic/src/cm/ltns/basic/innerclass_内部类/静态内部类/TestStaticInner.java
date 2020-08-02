package cm.ltns.basic.innerclass_内部类.静态内部类;

/**
 * 外部类以外的地方访问静态内部类
 *
 */
public class TestStaticInner {
    public static void main(String[] args) {
        OutClass.staticInnerClass in = new OutClass.staticInnerClass();
        in.innerFun2();
    }
}
