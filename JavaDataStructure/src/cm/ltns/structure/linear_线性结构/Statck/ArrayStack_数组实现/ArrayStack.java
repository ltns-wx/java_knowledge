package cm.ltns.structure.linear_线性结构.Statck.ArrayStack_数组实现;

import cm.ltns.structure.linear_线性结构.linearlist_线性表.common.Stack;

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
    private static int DEFAULT_CAPACITY = 10;

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

    // 入栈：从栈顶到栈底.
    @Override
    public void push(T t) {
        // 判断是否扩容，当size=数组的长度的时候（size表示栈里面的严肃）
        if (size >= arrayStack.length) {
            resetSize(arrayStack.length + DEFAULT_CAPACITY);
        }
        arrayStack[size] = t;
        size++;
    }

    // 出栈
    @Override
    public T pop() {
        // 判断栈是否为空
        if (isEmpty()) {
            System.out.println("队列为空");
            return null;
        }
        // 判断是否缩容（长度不足 数组的1/4的时候开始） 1,2,3
        if (size == arrayStack.length / 4 && arrayStack.length > DEFAULT_CAPACITY) {
            resetSize(arrayStack.length / 2);
        }
        // 出栈
        T e = arrayStack[size - 1];
        System.out.println("出栈元素：" + e);
        arrayStack[size - 1] = null;  // 可以不置空
        size--;
        return e;
    }

    // 获取指定索引位置元素
    public T get(int index) {
        ArrayStack<T> temp = this;
        if (isEmpty() || index > size() - 1) {
            new IllegalArgumentException("下标索引越界");
        }
        return arrayStack[index];
    }

    // 栈的长度
    @Override
    public int size() {
        return size;
    }

    // 判断是否为空（size<=0）
    @Override
    public boolean isEmpty() {
        if (size <= 0) {
            return true;
        }
        return false;
    }

    // 扩容或者缩容
    private void resetSize(int length) {
        T[] temp = (T[]) new Object[length];
        for (int i = 0; i < size; i++) {
            temp[i] = arrayStack[i];
        }
        arrayStack = temp;
    }

    @Override
    public T getHead() {
        return arrayStack[size - 1];
    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        sb.append(size);
        sb.append("/");
        sb.append(arrayStack.length);
        sb.append("]");
        sb.append("-->");
        sb.append("{");
        for (int i = 0; i < size; i++) {
            sb.append(arrayStack[i]);
            sb.append(",");
        }
        if (!isEmpty()) {
            sb.deleteCharAt(sb.length() - 1);
        }
        sb.append("}");

        return sb.toString();
    }

    public Iterator<T> iterator() {
        return new ArrayStackIterator();
    }

    class ArrayStackIterator implements Iterator<T> {
        // 初始化开始遍历的位置
        private int cur = 0;

        @Override
        public boolean hasNext() {
            if (cur > size) {
                return false;
            }
            return true;
        }

        @Override
        public T next() {
            return arrayStack[cur++];
        }

    }

    public static void main(String[] args) {
        ArrayStack<String> arrayStack = new ArrayStack<>();
        arrayStack.push("a");
        arrayStack.push("b");
        arrayStack.push("c");
        arrayStack.push("d");
        arrayStack.push("e");
        arrayStack.push("f");
        arrayStack.push("g");
        arrayStack.push("h");
        arrayStack.push("i");
        arrayStack.push("j");
        System.out.println("获取指定位置上的索引" + arrayStack.get(2));
        System.out.println(arrayStack);
        arrayStack.push("k");
        System.out.println(arrayStack);
        //遍历
        System.out.println("开始遍历--------------");
        Iterator<String> iterator = arrayStack.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("出栈测试-------------");
        // 出栈
        arrayStack.pop();
        arrayStack.pop();
        arrayStack.pop();
        arrayStack.pop();
        arrayStack.pop();
        arrayStack.pop();
        System.out.println(arrayStack);
        arrayStack.pop(); // 开始缩容
        System.out.println(arrayStack);
        arrayStack.pop();
        arrayStack.pop();
        arrayStack.pop();
        arrayStack.pop();
        arrayStack.pop();
        arrayStack.pop();


    }
}
