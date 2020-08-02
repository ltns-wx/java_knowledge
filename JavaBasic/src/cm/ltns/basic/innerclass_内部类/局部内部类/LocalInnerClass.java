package cm.ltns.basic.innerclass_内部类.局部内部类;

/**
 * 局部内部类：如果把一个内部类放到方法里(成员方法或静态方法)，那么就称为局部内部类
 *
 *  一、有效范围：局部内部类只能在该方法中有效
 */
public class LocalInnerClass {

    public void fun(){
        class FunClass{

        }
    }

    public static void staticFun(){
        class  staticFunClass{

        }
    }

}
