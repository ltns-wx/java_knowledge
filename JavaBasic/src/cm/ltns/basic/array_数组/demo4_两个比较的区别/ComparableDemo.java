package cm.ltns.basic.array_数组.demo4_两个比较的区别;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Comparable  和 Comparator的区别
 *
 * 一、Comparable
 *      1.排序逻辑：排序逻辑必须在带排序对象的类中，故称为自然排序
 *      2.排序的方法：compareTo(Object o1)
 *      3.触发排序：Collections.sort()
 *      4.所在的包：java.lang 包下
 * 二、Comparator
 *      1.排序逻辑：排序逻辑在另一个实现类中
 *      2.排序方法：compare(Object o1, Object o2)
 *      3.触发排序：Collection.sort(List,Comparator)
 *      5.所在的包：在 java.util包下
 *
 * 使用：如果我们想进行列表排序，
 *      1.像Integer、String等这些基本类型的JAVA封装类都已经实现了Comparable接口，这些类对象本身就支持自比较，
 *      直接调用Collections.sort()/Arrays.sort()就可以对集合中元素的排序，无需自己去实现Comparable接口，
 *
 *      2.而有些自定义类的List序列，当这个对象不支持自比较或者自比较函数不能满足你的要求时，
 *          （1）你可以写一个比较器来完成两个对象之间大小的比较，也就是指定使用Comparator（临时规则排序，也称作专门规则排序），
 *          （2）如果不指定Comparator，那么就用自然规则排序，这里的自然顺序就是实现Comparable接口设定的排序方式。
 */
public class ComparableDemo {

    public static void main(String[] args) {
        // 定义两个对象
        Person p1 = new Person("张三", 2);
        Person p2 = new Person("李四", 3);
        Person p3 = new Person("王五", 1);
        System.out.println("------------数组排序---------------");
        // 数组排序
        Person[] personArr = {p1, p2, p3};
        Arrays.sort(personArr);
        for (Person p : personArr) {
            System.out.println(p.toString());
        }

        System.out.println("------------集合排序---------------");
        //集合排序
        List<Person> list  = new ArrayList<>();
        list.add(p1);
        list.add(p2);
        list.add(p3);
        Collections.sort(list);
        for (Person p : list) {
            System.out.println(p.toString());
        }

    }


}

/**
 *  定义一个Person类，根据年龄来排序
 */
class Person implements Comparable<Person> {
    private String name;
    private Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    // 返回大于0 是升序， 小于0 是降序
    @Override
    public int compareTo(Person o) {
        return this.age - o.getAge(); //年龄小的在前面
//        return o.age - this.getAge();
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
