package cm.ltns.structure.linear_线性结构.Statck;

import cm.ltns.structure.linear_线性结构.linearlist_线性表.common.Stack;

import java.util.Arrays;
import java.util.Iterator;

/**
 *  栈：last in first out
 *  只允许一端进出，称为栈顶。另一端称为栈顶
 */
public class ArrayStack<T> implements Stack<T> {

    //
    private T[] arrayStack;
    private int size; // 线性表的个数（也代表最后一个元素的后一个位置）
    // 默认栈的大小
    private static int DEFAULT_CAPACITY = 5;

    // 无参构造函数
    public ArrayStack() {
        // 初始化 栈
        // 创建泛型数组，方式一：    （泛型数组不能直接创建）
        arrayStack = (T[]) new Object[DEFAULT_CAPACITY];
        //  方式二
//        T[] o = Array.newInstance(T.class, 10);
        // 线性表的大小为0
        size = 0;
    }
    // 有参够构造函数

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if (size <= 0) {
            return true;
        }
        return false;
    }

    @Override
    public void push(T t) {
        // 判断是否扩容
        if (size > arrayStack.length) {
            resetSize(arrayStack.length + DEFAULT_CAPACITY);
        }
        arrayStack[size] = t;
        size++;
    }

    private void resetSize(int length) {
        T[] temp = (T[]) new Object[length];
        for (int i = 0; i < arrayStack.length; i++) {
            temp[i] = arrayStack[i];
        }
        arrayStack = temp;
    }

    // 出栈
    @Override
    public T pop(T t) {
        // 判断是否缩容（长度不足 数组的1/4的时候开始） 1,2,3
        if (size == arrayStack.length / 4 && arrayStack.length > DEFAULT_CAPACITY) {
            resetSize(arrayStack.length - 5);
        }
        // 出栈
        T e = arrayStack[size - 1];
        arrayStack[size - 1] = null;
        size--;
        return e;
    }

    @Override
    public T peek(T t) {

        return arrayStack[size - 1];
    }

    @Override
    public void clear() {

    }

    public void getArray() {
        System.out.println(Arrays.toString(arrayStack));
    }


    public Iterator<T> iterator() {
        return new ArrayStackIterator();
    }

    class ArrayStackIterator implements Iterator<T> {
        // 初始化开始遍历的位置
        private int cur = 0;

        @Override
        public boolean hasNext() {
            if (cur >= size) {
                return false;
            }
            return true;
        }

        @Override
        public T next() {
            return arrayStack[cur];
        }
    }

    public static void main(String[] args) {

    }
}
