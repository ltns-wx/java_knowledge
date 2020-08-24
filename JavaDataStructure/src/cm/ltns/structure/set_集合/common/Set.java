package cm.ltns.structure.set_集合.common;

import java.util.HashMap;

public interface Set<E>  {
    public void add(E e);
    public void remove(E e);
    public boolean contains(E e);
    public int size();
    public void isEmpty();
}
