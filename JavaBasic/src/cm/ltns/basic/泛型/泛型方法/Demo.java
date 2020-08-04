package cm.ltns.basic.泛型.泛型方法;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 泛型方法格式：修饰符 <T,S> 返回值类型 方法名（形参列表）{ // 方法体 }
 *
 * 泛型方法和通配符的区别：
 *  大多数情况下，都可以使用泛型方法来替换通配符
 */
public class Demo {

    // 把数组转成对应的集合中
    public static <T> void formArrayToCollection(T[]a , Collection<T> c){
        for(T o : a){
            c.add(o);
        }
    }

    public static void main(String[] args) {
        String [] strings = {"aa","bb","cc"};
        Collection<String> collection = new ArrayList<>();
        formArrayToCollection(strings,collection);
    }
}
