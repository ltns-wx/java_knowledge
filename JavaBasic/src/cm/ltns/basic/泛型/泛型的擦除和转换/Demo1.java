package cm.ltns.basic.泛型.泛型的擦除和转换;

import java.util.ArrayList;
import java.util.List;

/**
 * 在严格的泛型代码里，带泛型声明的类总应该带着类型参数，但是为了与老的java代码保持一致，也允许在使用带泛型声明的类时不指定实际的类型参数。
 * 则该数据类型被称为原始类型，默认是声明该参数时指定的第一个上线类型
 *
 * 一、把一个具有泛型信息的对象赋给一个没有泛型信息的变量时，所有在尖括号之间的类型都会被扔掉
 *     例如 ： List<String>类型 复制给List，则该List对集合元素的类型检测变成了类型变量的上线（Object）
 */
public class Demo1 {
    public static void main(String[] args) {
        List<String>  strings = new ArrayList<>();
        List list = new ArrayList();
        list = strings;
 //        for (String s: list) {}   // 报错，说明strings的类型已经被擦除了

    }
}
