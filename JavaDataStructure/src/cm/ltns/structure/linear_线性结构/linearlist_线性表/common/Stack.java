package cm.ltns.structure.linear_线性结构.linearlist_线性表.common;

public interface Stack<E> extends Iterable<E> {

    public int size();

    public boolean isEmpty();

    public void push(E t);
    // 出栈
    public E pop();
    // 获取栈顶元素
    public E getHead();

    public void clear();

}
