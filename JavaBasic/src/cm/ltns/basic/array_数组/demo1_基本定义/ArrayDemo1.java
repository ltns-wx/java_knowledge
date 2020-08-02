package cm.ltns.basic.array_数组.demo1_基本定义;

/**
 * 数组：把若干具有相同类型的变量按照有序的形式组织起来的一种数据形式
 *
 * 一、数组的定义：
 *      1.数组元素的类型 [] 数组名；
 *      2.数组元素的类型  数组名 []	；
 *
 * 二、数组的初始化
 *      1.静态初始化：由我们自己来为每一个数组元素设值，而且数据的长度由系统决定。
 *          数组元素类型[] 数组名= new 数组元素类型[]{};
 *          int [] a =new int[]{1,2,3,4};
 *
 *      2.动态初始化：由我们来设定数组的长度，而每一个数组元素的初始值由系统给定。
 *          int [] a = new int[10];
 *  总结：new 使用来在对内存分配空间的，如果定义的时候使用了new关键字，
 *      那么声明和初始化就可以分开来定义，否则会出现错误，合在一块是可以的 (int array [] = {2,3,4})。
 *
 *
 */
public class ArrayDemo1 {
    public static void main(String[] args) {
        fun2();

    }

    /**
     * 静态初始化：由我们自己来为每一个数组元素设值，而且数据的长度由系统决定。
     */
    public static void fun() {
        // 1.定义时并初始化
        int[] arr = {1, 2, 3, 4};
        int[] arr2 = new int[]{1, 2, 3, 4};

        //2. 先定义 后初始化
        int[] arr3;
        arr3 = new int[]{1, 2, 3};

        // 下面方法是错误的
        int[] arr4;
//        arr4 = {1,2,3}   b
    }

    /**
     * 动态初始化
     */
    public static void fun2() {
        // 方式一
        int[] arr = new int[10];

        System.out.println(arr.length);

        // 方式二、
        int[] arr2;
        arr2 = new int[10];
    }


}

