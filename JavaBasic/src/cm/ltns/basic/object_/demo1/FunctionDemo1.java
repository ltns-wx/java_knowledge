package cm.ltns.basic.object_.demo1;

/**
 * 方法参数传递方式：
 * 一、程序设计语言中有关参数传递有两种方式：
 *  1.按值调用 （call by value) 表示方法接收的是调用者提供的值。即：形参是估计定的值
 *  2.按引用调用 （ call by reference) 表示方法接收的是调用者提供的变量地址。即：形参是对象（String对象除外）
 *  但是java程序总是采用按值调用。也就是说，方法得到的是所有参数值的一个拷贝，特别的是，方法不能修改传递给它的任何参数变量的内容。
 *
 *  二、方法的参数有两种：
 *      1.基本数据类型（数字、布尔类型）
 *      2.对象应用（String除外）
 *
 * 三、一个例子来说明java是值调用
 *
 * 四：总结：
 *  1.一个方法不能修改一个基本数据类型的参数（即数值型或布尔型）。
 *  2.一个方法可以改变一个对象参数的状态。
 *  3.一个方法不能让对象参数引用一个新的对象。
 *  4.String虽然也是一个对象，但是他是final修饰符修饰。
 */
public class FunctionDemo1 {
    public static void main(String[] args) {

        /**
         * 范例一、
         *  执行步骤：
         *  （1）x 被初始化为 percent 值的一个拷贝。也就是10
         *  （2）) x 被乘以 3后等于 30。 但是 percent 仍然是 10
         */
        int i = 10;
        valueFun(i);
        System.out.println("调用valueFun 后 i 的结果" + i);

        System.out.println("------------------------------------------");

        /**
         * 范例二、
         *  执行步骤
         *   （1） person初始化为 p值的拷贝，这里是对象的地址。此时person和p指向同一个对象
         *   （2）修改person的内容，也就是修改地址指向的对象的内容
         *   （3）相对应p指向的地址也发生改变
         */
        Person p = new Person();
        p.setName("好久不见");
        System.out.println("调用方法之前person对象name的值：" + p.getName());
        referenceFun(p);
        System.out.println("调用方法后person对象name的值：" + p.getName());

        System.out.println("------------------------------------------");


        /**
         * 范例三、
         * 证明java是值调用
         *  如果是引用传递，那么person1和person2会交换
         */
        Person person1 = new Person();
        person1.setName("person1");
        Person person2 = new Person();
        person2.setName("person2");
        System.out.println("调用方法之前person1.name = " + person1.getName() + ",persion2.name =" +person2.getName());
        exchangeObject(person1,person2);
        System.out.println("调用方法之后person1.name = " + person1.getName() + ",persion2.name =" +person2.getName());
    }

    //基本数据类型（数字、布尔类型）
    public static void valueFun(int x){
        x = x * 10;
        System.out.println("valueFun 中的i结果" + x);
    }
    // 引用类型
    public static void referenceFun(Person person){
        person.setName("数据被污染");
    }

    // 两个对象进行交换
    public static void exchangeObject(Person person1, Person person2){
        Person temp = new Person();
        temp = person1;
        person1 = person2;
        person2 = temp;
    }



}
