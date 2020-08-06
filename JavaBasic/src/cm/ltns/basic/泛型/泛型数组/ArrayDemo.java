package cm.ltns.basic.泛型.泛型数组;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  java中可以声明带泛型的数组，但是不能创建泛型对象，即：
 *      List<String> list = new List<String>[10]中， 前面List<String> list 是可以声明的
 *      但是 new List<String>[10]是不可以声明的
 */
public class ArrayDemo {

    /**
     * 如果List<String> [] isa = new List<String>[10];合法，
     * 下面的实例将发生异常
     */
    public static void fun(){
        // 语法错误
        List<String> [] isa = new List[10];
        // 强转成Object数组
        Object[] oa = (Object[])isa;

        List<Integer> li = new ArrayList<>();
        li.add(new Integer(3));

        //将List<Integer>对象作为oa的第二个元素
        oa[1] = li;
        // 发生转换异常
        String s = isa[1].get(0);

    }

    /**
     * 泛型数组的创建方法
     */

    public  <T> T[] fun2 (Class<T> cls,int length){
        T[] t = (T[])Array.newInstance(cls , length);
        return t ;
    }

    public static void main(String[] args) {
        fun();
    }
}
