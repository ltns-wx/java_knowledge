package cm.ltns.structure.linear_list_线性表.common;

public interface List<T> extends Iterable<T> {

    // 增加
    public void add(int index, T o);
    public void add( T o);

    //修改
    public void modify(int index, T o);

    // 删除
    public T remove(int index);

    // 获取
    public T get(int index);


    // 判断是否为空
    public boolean isEmpty();


    //查找元素位置
    int indexOf(Object o);

    // 长度
    public int size();

    // 下一个元素
    public void next();

    // 清空
    public void clear();

}
