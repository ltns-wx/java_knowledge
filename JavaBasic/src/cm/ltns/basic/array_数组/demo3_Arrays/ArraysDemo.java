package cm.ltns.basic.array_数组.demo3_Arrays;

import java.util.*;

/**
 * 一、Arrays 类的使用 ：该类包含用于操作数组的各种方法（如排序和搜索）。该类还包含一个静态工厂，可以将数组视为列表
 *
 * 二、数组的copy
 *
 */
public class ArraysDemo {
    public static void main(String[] args) {
        printArray();

        sort();

        sortScope();

        binarySearch();

        onwSort();

        copy();

        copyOfRange();

    }

    /**
     *  获取数组的长度
     */
    public static void size() {
        int[] arr = {1, 2, 3, 4};
        System.out.println("arr 数组的长度:" + arr.length);
    }

    /**
     * 打印数组：
     *      源码使用StringBuilder进行拼接。
     */
    public static void printArray() {
        int[] arr = new int[]{1, 2, 3, 4};
        System.out.println("直接打印：" + arr);
        System.out.println("使用Arrays.toString个方法打印" + Arrays.toString(arr));
    }

    /**
     * 相同的可变参数变成列表（List），这里面的List并不是ArrayList，而是Arrays的内部类.
     *
     *
     *
     */
    public static void asList() {
        // 相同类型的可变参数
        List<Integer> ints = Arrays.asList(1, 2, 3, 4);
        System.out.println(ints); //[1,2,3,4]

        /**
         * 这个地方会把int[] arr当做整个对象，
         * 原因： asList 的方法：public static <T> List<T> asList(T... a)
         *        T 泛型应该是一个Object，所以，他会把int[] arr当做一个对象，
         *        相比String[] strings， 这个T的类型就是String。
         */
        int[] arr = new int[]{1, 2, 3, 4};
        List<int[]> ints1 = Arrays.asList(arr); // 这个会把int[] arr 当做整个对象
        System.out.println(ints1);

        String[] str = {"张三", "李四", "王五", "宋六", "赵七", "朱八", "何九", "田十"};
        List<String> list = Arrays.asList(str);//将数组转换为list集合
        System.out.println(list);
    }

    /**
     * 自定义方法：把数组转成ArrayList
     */
    public static void asArrayList(){
        String [] strings = {"a","b","c","d"};
        // 方法一
        ArrayList<String> stringList = new ArrayList<String>(Arrays.asList(strings));

        // 方式二、
        List<String> list = new ArrayList<String>(strings.length);
        Collections.addAll(list, strings);
    }

    /**
     * 数组转成List
     */
    public static void toList() {

    }

    /**
     * 数组的排序：默认使用升序
     *      1.sort(byte[] a):按照字节数字顺序排列指定的数组。
     *      2.sort(char[] a)：按照字符数字顺序排列指定的数组。
     *      3.sort(double[] a)：按照双精度数字顺序排列指定的数组。
     *      4.sort(float[] a)：按照单精度数字顺序排列指定的数组。
     *      5.sort(int[] a)：按照int类型数字顺序排列指定的数组。
     *      6.sort(long[] a)
     *      7.sort(Object[] a)：对指定对象升序排列的阵列，根据natural ordering的元素。
     *      8.sort(short[] a)
     */
    public static void sort() {
        int[] arr = new int[]{2, 4, 1, 3};
        Arrays.sort(arr); // 排序
        System.out.println("排序后的数组：" + Arrays.toString(arr));

        // String 类型其实就是Object类型
        String[] stringArr = {"ab", "ac", "dd", "bc", "cc"};
        Arrays.sort(stringArr);
        System.out.println("排序后的数组：" + Arrays.toString(stringArr));

    }

    /**
     * 指定范围进行排序:
     *  public static void sort(int[] a,int fromIndex,int toIndex)
     *      按升序排列数组的指定范围。 要排序的范围从索引fromIndex （包括）扩展到索引toIndex ，排他。
     *      如果fromIndex == toIndex ，要排序的范围是空的。
     *   参数
     *      a - 要排序的数组
     *      fromIndex - 要排序的第一个元素（ fromIndex ）的索引
     *      toIndex - 最后一个要排序的元素的索引(不包含)
     *   异常
     *      IllegalArgumentException - 如果是 fromIndex > toIndex
     *      ArrayIndexOutOfBoundsException - 如果 fromIndex < 0或 toIndex > a.length
     */
    public static void sortScope() {
        int[] arr = {6, 5, 4, 3, 2, 1};
        Arrays.sort(arr, 1, 3);
        System.out.println("指定范围排序：" + Arrays.toString(arr));
    }

    /**
     * 自定义排序:
     *  排序有两个接口：1.Comparable  2.Comparator   // 下面会比较两个的区别
     *
     */
    public static void onwSort() {
        Integer[] arr = {1, 2, 3, 4};
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -1;
            }
        };
        Arrays.sort(arr, comparator);
        System.out.println("自定义排序的结果：" + Arrays.toString(arr));
    }

    /**
     *  何为二分法：
     *
     * 二分法进行查找元素:
     *      使用二进制搜索算法搜索指定数组的指定数组。 在进行此调用之前，数组必须按照sort(T [])方法进行排序。 如果没有排序，结果是未定义的。
     *
     *  二分法：指定范围进行搜索：
     *
     *  注意：如果数组包含具有指定值的多个元素，则不能保证将找到哪个元素。(应该都是最后一个元素的位置吧)
     */
    public static void binarySearch() {
        int[] arr = {5, 4, 3, 2, 1, 2, 2, 3};
        Arrays.sort(arr);//1,2,2,2,3,3,4,5
        int i = Arrays.binarySearch(arr, 2);
        System.out.println("使用二分法查找元素位置：" + i);

        int i2 = Arrays.binarySearch(arr, 1, 5, 2);
        System.out.println("使用二分法查找元素位置：" + i2);
    }

    /**
     * 复制指定的数组：底层使用System.arraycopy()方法，下面会讲到
     *  original - 要复制的数组:public static int[] copyOf(int[] original,int newLength)
     *  newLength - 要返回的副本的长度
     */
    public static void copy() {
        int[] arr = {1, 2, 3, 4, 5};
        int[] ints = Arrays.copyOf(arr, 2);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(ints));
    }

    /**
     * 将指定数组的指定范围复制到新数组中
     *  语法：copyOfRange(int[] original, int from, int to)   // 左闭右开
     *  参数：
     *      original - 要从中复制范围的数组
     *      from - 要复制的范围的初始索引（包括）
     *      to - 要复制的范围的最终索引，排他。 （该索引可能位于数组之外）
     */
    public static void copyOfRange() {
        int[] arr = {1, 2, 3, 4, 5};
        int[] ints = Arrays.copyOfRange(arr, 1, 3);
        System.out.println("copyOfRange拷贝的新数组：" + Arrays.toString(ints));

    }

    /**
     * 填充：
     *  1.fill(int[] a, int val)：将指定的int值分配给指定的int数组的每个元素。
     *
     *  2.	fill(int[] a, int fromIndex, int toIndex, int val)：将指定的int值分配给指定的int数组的指定范围的每个元素
     */
    public static void fill() {

    }

    /**
     * jdk8的新特性：排序
     */
    public static void parallelSort() {

    }

    /**
     * jdk1.8新特性：流
     */
    public static void stream() {

    }

}
