package cm.ltns.structure.linear_list_线性表.common;

import java.util.Iterator;

public interface Stack<E> extends Iterable<E> {

    public int size();

    public boolean isEmpty();

    public void push(E t);
    // 出栈
    public E pop(E e);
    // 获取栈顶元素
    public E peek(E e);

    public void clear();

}
