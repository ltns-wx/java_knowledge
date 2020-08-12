package cm.ltns.structure.linear_线性结构.linearlist_线性表.ArrayLinearList_数组实现方式;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(2,6);
        System.out.println(list);
    }
}
