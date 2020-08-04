package cm.ltns.basic.泛型.泛型通配符;

import java.util.ArrayList;
import java.util.List;

/**
 * 通配符：
 * 一、拿List集合来说，我们知道List<Object> 并不是List<String>的父类，所以，为了表示List的父类，我们需要
 *     使用通配符，类型通配符是一个问号（?）
 * 二、这种通配符的List表示各种泛型List的父类，并不把元素放在其中。
 *
 * 三、通配符和泛型方法的区别
 */
public class Demo1 {


    public void printList(List<?> list){
        for (int i = 0 ; i < list.size(); i ++){
            System.out.println(list.get(i));
        }
    }

    // 这里编译不通过，因为List<?> 这种通配符，并不能确定泛型的类型
    public void test(){
        List<?> list = new ArrayList<String>();
//        list.add("aa");  // 编译错误
    }
}
