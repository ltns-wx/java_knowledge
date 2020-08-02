package cm.ltns.basic.funtion_.Demo2;

/**
 *  一、方法可变参数使用：JDK1.5的新特性
 *      原理：就是把形参定义一个数组、 然后去调用，即：fun 的源码编译的结果就是fun1
 *  二、注意：
 *      1.可变类型参数，后面不能紧跟相同类型的参数，不然系统会发生歧义，不知道后面的参数是不是数据数组
 */
public class FuntionDemo2 {
    public static void main(String[] args) {
        fun(1, 2, 3, 4, 5, 6);

        // 原理：1.首先先把形参定义成数组 2.然后把方法参数的形参也改成数组、3最后调用
        int[] ayy = {1,2,3,4,5,6};
        fun1(ayy);

        System.out.println("-----------fun2------------");
        fun2(ayy, 1);

    }

    // 可变参数
    public static void fun(int... array) {
        int sum = 0;
        for (int i : array) {
            sum = sum + i;
        }
        System.out.println("总和：" + sum);
    }
    // 可变参数的底层实现就是把 可变性餐定义一个数据、然后进行调用
    public static void fun1(int [] array) {
        int sum = 0;
        for (int i : array) {
            sum = sum + i;
        }
        System.out.println("总和：" + sum);

    }

    public static void fun2(int [] array, int c){
        int sum = 0;
        for (int i : array) {
            sum = sum + i;
        }
        System.out.println("总和：" + sum);
        System.out.println("总和：" + c);
    }

    public static void fun3(int [] array, String str, int c) {
        int sum = 0;
        for (int i : array) {
            sum = sum + i;
        }
        System.out.println("总和：" + sum);
        System.out.println("str：" + str);
        System.out.println(c);
    }
}
