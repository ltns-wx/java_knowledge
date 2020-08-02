package cm.ltns.basic.Ploymorphism_多态.demo1;

/**
 * 多态：java的引用变量有两种类型：
 *      一是编译类型：编译时类型由声明该变量时使用的类型决定的
 *      一个是运行时类型：运行时类型是由实际赋值给该变量的对象决定
 *      如果编译性类型和运行时类型不一样时，产生多态。
 *
 *  执行步骤：
 *      1.如果对象调用一个方法，先判断编译类型是否有该方法，如果没有，则编译不通过，报错
 *      2.如果有，那么运行时，会先判断子类是否有该方法，如果没有，则调用父类方法，如果有，调用子类方法
 *
 */
public class SubClass extends BasicClass {
    public int book = 1;

    public void test() {
        System.out.println("子类覆盖父类的方法");
    }

    public void sub() {
        System.out.println("子类的普通方法");
    }

    public static void staticFun() {
        System.out.println("子类的静态方法");
    }

    public static void main(String[] args) {
        // 1.编译类型和运行类型不同是
        BasicClass basic = new SubClass();
        System.out.println("多态时变量值：" + basic.book);// 6 对象的Field不具备多态性

        //2.调用从父类覆盖的方法
        basic.test();   // 编译通过， 编译时会判断父类是否有该方法。运行时，去找子类是否有该方法，如果有调用子类方法

        //3.调用父类的普通方法
        basic.base();   // 编译通过，编译时判断父类是否有该方法。运行时，去找子类是否有该方法，如果没有，则调用父类方法

        //4.调用子类的普通方法
//        basic.sub();      // 编译不通过， 因为basic在编译时期，会找编译时期类型是否有该方法

        // 调用被覆盖的静态方法
        basic.staticFun();  // 静态方法没有多态、 编译时期和运行时期都会去找根据编译类型去判断

    }

}

class BasicClass {
    public int book = 6;

    public void base() {
        System.out.println("父类的普通方法");
    }

    public void test() {
        System.out.println("父类的被覆盖方法");
    }

    public static void staticFun() {
        System.out.println("父类的静态方法");
    }
}
