package cm.ltns.structure.linear_线性结构.linearlist_线性表.ArrayLinearList_数组实现方式;

import cm.ltns.structure.linear_线性结构.linearlist_线性表.common.List;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Objects;

/**
 * 线性表数组的表达方式：
 *      1.data表示数组
 *      2.size表示新增加的元素的个数，有代表数组有效数组的最后一位
 *
 * 新增： data[] = 1,2,3,4,5  size = 6
 *      1.在默认新增：data[size]   // size表示元素的个数，和有效数据的下一个位置
 *      2.在指定位置（index=3）上新增：那么4以后的元素往后移动一位，即：data[6]=data[5], data[5]=data[4]
 *        这里index是数组索引位置上是3，例如data={1,2,3,4,5,6} index=3， 那么应该在3的后面新增加一个
 *
 *  线性表特性：
 *      1、在线性表中逻辑上相邻的元素在物理存储位置上也相邻；
 *      2.可按照数据元素的索引号进行随机存取，时间复杂度为O(1)；
 *      3.插入、删除操作需要移动大量的元素，时间复杂度为O(n)；
 *      4.需要预先分配存储空间，可能会造成空间浪费，但存储密度高，数据紧凑
 */
public class ArrayLinearList<T> implements List<T> {

    // 线性表的默认长度
    private static int DEFAULT_CAPACITY = 10;

    // 数组存储
    private T[] data;

    //线性表中元素有效个数，也表示新来的元素默认在尾部添加（size也是一个指针，指向最后一个元素的的后一个位置）
    private int size;

    //构造器：使用默认初始值
    public ArrayLinearList() {
        data = (T[]) new Object[DEFAULT_CAPACITY];
        size = 0; // 指针指向第一个位置
    }

    // 构造器：指定数组大小
    public ArrayLinearList(int size) {
        if (size < 0) {
            throw new IllegalArgumentException("非法参数");
        }
        data = (T[]) new Object[size];
        size = 0; // 指针指向第一个位置
    }

    // 把数组转成线性表
    private ArrayLinearList(T[] arr) {
//        data = arr ;   // 这里不能直接进行引用，根据java对象引用，这个地方是地址引用，即data和arr会指向同一块区域，如果arr发生改变，data也会发生改变
        if (arr == null || arr.length == 0) {
            data = (T[]) new Object[DEFAULT_CAPACITY];
        }
        // 先创建data对象
        data = (T[]) new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
            size++;
        }
    }

    // 指定索引位置上插入一个元素
    @Override
    public void add(int index, T o) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("下标索引越界");
        }
        // 判断表是否已经满了
        if (size > data.length) {  //size永远都指向最有一个元素的后一个位置
            // 扩充（一般扩容为当前容量的一倍）
            resize(data.length + DEFAULT_CAPACITY);
        }
        // 插入位置，后面的需要移动 【size - 1：最后一个元素】
        for (int i = size; i >= index; i--) {       // 只能从后往前移动
            data[i] = data[i - 1];
        }
        data[index] = o;
        size++;
    }

    /**
     * 扩容，一般扩容默认长度
     */
    private void resize(int size) {
        T[] newData = (T[]) new Object[size];
        System.out.println("触发数组长度变化为" + size);
        for (int i = 0; i < this.size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    @Override
    public void add(T o) {
        // 可以调用add(index,o)方法进行添加
//        add(size,o);
        // 判断是否满
        if (size == data.length) {
            // 扩容
            resize(data.length + DEFAULT_CAPACITY);
        }
        data[size] = o;
        size++;
    }

    @Override
    public void modify(int index, T o) {
        if (index < 0 || index > data.length) {
            throw new IndexOutOfBoundsException("下标索引越界");
        }
        data[index] = o;
    }

    // 删除 指定位置上的元素
    @Override
    public T remove(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("下标索引越界");
        }
        //获取将要删除的元素，并返回
        T temp = data[index];
        // 缩容:如果有效元素的个数是数组容量的四分之一，并且，当前数组的长度是大于10的
        if (size == data.length / 4 && data.length > DEFAULT_CAPACITY) {
            resize(data.length / 2);
        }
        // 减少 --> 从前往后复制
        for (int i = index; i < data.length; i++) {
            data[i - 1] = data[i];
        }
        size--;
        return temp;
    }
    // 删除指定索引位置上的元素。
    public T removeByIndex(int index){
        // 判断索引的合法性
        if (index < 0 || index > size-1) {
            throw new IllegalArgumentException("下表索引越界");
        }
        // 判断是否扩容

        T e = data[index];
        // 元素需要往前移动
        for (int i = index; i < size-1; i ++ ) {
            data[i] = data[i +1];
        }
        size -- ;
        return e;
    }


    @Override
    public T get(int index) {
        if (isEmpty()) {
            System.out.println("线性表为空..");
        }
        if (index < 0 || index > data.length) {
            throw new IndexOutOfBoundsException("下标索引越界");
        }
        return data[index];
    }

    @Override
    public boolean isEmpty() {

        return size == 0 ? true : false;
    }

    @Override
    public int indexOf(T o) {
        if (isEmpty()) {
            System.out.println("线性表为空");
        }
        for (int i = 0; i < data.length; i++) {
            if (data.equals(o)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }
    // 获取数组的大小
    public  int getArrayLength(){
        return data.length;
    }

    // 判断是否包含某个元素
    public boolean contains(T o){
        return indexOf(o) != -1;
    }

    @Override
    public void next() {

    }

    // 清空
    @Override
    public void clear() {
        data = (T[]) new Object[DEFAULT_CAPACITY];
    }

    // 排序
    public void sort (Comparator<T> c){

    }

    @Override
    public String toString() {
        return "ArrayLinearList{" +
                "data=" + Arrays.toString(data) +
                ", size=" + size +
                '}';
    }

    // 创建迭代器
    @Override
    public Iterator<T> iterator() {
        return new ArrayLinearListIterator();
    }

    public static void main(String[] args) {

        System.out.println("开始验证...");
        ArrayLinearList<String> strings = new ArrayLinearList<>();
        strings.add("a");

        strings.add("b");
        strings.add(1, "c");
        System.out.println(strings.toString());
        strings.remove(1);
        System.out.println(strings.toString());
    }

    class ArrayLinearListIterator implements Iterator<T> {
        private int cur = 0;

        // 判断下一位是否有元素
        @Override
        public boolean hasNext() {
            return cur < size;
        }

        // 移动指标
        @Override
        public T next() {
            return data[cur++];
        }
    }

}

