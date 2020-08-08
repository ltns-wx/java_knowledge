package cm.ltns.structure.linear_list_线性表.ArrayLinearList;

import cm.ltns.structure.linear_list_线性表.common.List;
import sun.security.util.Length;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;

public class ArrayLinearList<T> implements List<T> {

    //默认数组长度为10
    private int maxsize = 10;
    // 线性表的长度（包含元素的数量）
    private int length;
    // 存储（可以定义为Object， 插入的时候用泛型规定插入的数据类型、就不会发生类型转换异常）
    private T[] arr;

    // 无参构造器
    public ArrayLinearList() {
        arr = (T[]) new Object[maxsize];
    }

    //有参构造器
    public ArrayLinearList(int length) {
        arr = (T[]) new Object[length];
        //另一种初始化方式
//        t = (T[]) Array.newInstance(clz, maxsize);
    }

    // 增加
    @Override
    public void add(int index, T o) {


    }
    @Override
    public void add(T o) {

    }

    // 修改
    @Override
    public void modify(int index, T o) {

    }

    @Override
    public void remove(int index) {

    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public void size() {

    }

    @Override
    public void next() {

    }

    @Override
    public void clear() {

    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
