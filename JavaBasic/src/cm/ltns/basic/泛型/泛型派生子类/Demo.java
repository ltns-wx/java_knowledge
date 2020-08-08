package cm.ltns.basic.泛型.泛型派生子类;

import java.util.ArrayList;
import java.util.List;

/**
 * 泛型在继承方面的表现：其实并不存在泛型类
 *
 *
 */
public class Demo {
    /**
     *  如果Foo是Bar的子类或者子接口，而G是具有泛型类的类或者接口，那么G<Foo> 并不是G<Bar> 的子类。
     *  数组和泛型不同，假设Foo是Bar的一个子类，那么Foo[]依然是Bar[]的子类型
     */
    public static void main(String[] args) {

        // 类
        Object obj = null;
        String str = null;
        obj = str;

        // 数组
        Object[] objects = null;
        String[] strings = null;
        objects = strings;

        // 集合
        List<String> StringList = new ArrayList<>();
        List<Integer> integerList = new ArrayList<>();
        System.out.println(StringList.getClass() == integerList.getClass());// true
    }
}



