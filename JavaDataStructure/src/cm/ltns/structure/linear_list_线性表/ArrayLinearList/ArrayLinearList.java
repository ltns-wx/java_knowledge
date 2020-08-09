package cm.ltns.structure.linear_list_线性表.ArrayLinearList;

import cm.ltns.structure.linear_list_线性表.common.List;
import sun.security.util.Length;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;

/**
 * 线性表数组的表达方式：
 */
public class ArrayLinearList<T> implements List<T> {

    // 线性表的默认长度
    private static int DEFAULT_CAPACITY = 5;

    // 数组存储
    private T[] data;

    //线性表中元素有效个数，也表示新来的元素默认在尾部添加（size也是一个指针，指向最后一个元素的的后一个位置）
    private int size;

    //构造器：使用默认初始值
    public ArrayLinearList() {
        data = (T[]) new Object[DEFAULT_CAPACITY];
        size = 0; // 指针指向第一个位置
    }

    public ArrayLinearList(int size) {
        if (size < 0) {
            throw new IllegalArgumentException("非法参数");
        }
        data = (T[]) new Object[size];
        size = 0; // 指针指向第一个位置
    }

    // 插入一个（只能在有效数组长度+1内增加）、后面的往后移动
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
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
            data[index] = o;
        }
        data[index] = o;
        size++;
    }

    //扩容，一般扩容默认长度
    private void resize(int size) {
        T[] newData = (T[]) new Object[size];
        for (int i = 0; i < data.length; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    @Override
    public void add(T o) {
        // 判断是否满
        if (size== data.length) {
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

    // 1,2, ,4,5,
    @Override
    public T remove(int index) {
        if (index < 0 || index > data.length) {
            throw new IndexOutOfBoundsException("下标索引越界");
        }
        //获取将要删除的元素，并返回
        T temp = data[index];
        // 缩容:如果有效元素的个数是数组容量的四分之一，并且，当前数组的长度是大于10的
        if (size == data.length / 2 && data.length > DEFAULT_CAPACITY) {
            resize(data.length / 2);
        }
        // 减少
        for (int i = index; i < data.length; i++) {
            data[i - 1] = data[i];
        }
        size--;
        return temp;
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
    public int indexOf(Object o) {
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

    @Override
    public void next() {

    }

    @Override
    public void clear() {

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
        strings.add(1,"c");
        strings.add("b");
        strings.add("b");
        strings.add("b");
        Iterator<String> iterator = strings.iterator();
        System.out.println("线性表长度" + strings.size());
        strings.remove(1);


        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
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

