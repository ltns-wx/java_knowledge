package cm.ltns.basic.Ploymorphism_多态.demo2_instanceof;

/**
 *  instanceof 的使用
 *  在多态中，引用变量只能调用它编译时期类型的方法，而不能调用它运行时类型的方法（编译报错），
 *  即使它实际所引用的对象中确实包含该方法。如果想要这个引用对象调用运行时类的方法，那么就需要
 *
 *  类型转换：
 *      1.基本变量：基本变量之间只能在数值之间进行，整形、字符型、浮点型
 *      2.引用类型之间的转换，只能在具有继承关系的两个类之间进行。
 *
 *   引用类型强转之前，为了避免ClassCastException，可以先通过instanceof判断
 *
 */
public class ConversionTest {
    public static void main(String[] args) {
        //出现多态， 并且p只能调用编译时期的方法
        ParentClass p = new ChildClass();

        // 如果想调用运行时期类型方法，则必须要强转
        ((ChildClass) p).childFun();

         // 引用类型强转容易报错，所以在强转之前，先要判断是否为同一类型
        if (p instanceof  ChildClass){
            ChildClass c =  (ChildClass) p;
            c.childFun();
        }
    }

}

class ChildClass extends ParentClass {

    public void childFun() {
        System.out.println("子类的普通方法");
    }
}


class ParentClass {

    public void parentFun() {
        System.out.println("父类的普通方法");
    }

}
