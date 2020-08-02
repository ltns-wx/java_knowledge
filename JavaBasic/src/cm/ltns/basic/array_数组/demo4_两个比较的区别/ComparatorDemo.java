package cm.ltns.basic.array_数组.demo4_两个比较的区别;

import java.util.*;

/**
 * Comparator自然顺序,
 *  用处：
 *  1.一个对象不支持自己和自己比较（没有实现Comparable接口），但是又想对两个对象进行比较
 *  2.自定义排序规则
 *
 *  总结：两种比较器Comparable和Comparator，后者相比前者有如下优点：
 * 1、如果实现类没有实现Comparable接口，又想对两个类进行比较（或者实现类实现了Comparable接口，
 *  但是对compareTo方法内的比较算法不满意），那么可以实现Comparator接口，自定义一个比较器，写比较算法
 * 2、实现Comparable接口的方式比实现Comparator接口的耦合性要强一些，如果要修改比较算法，则需要修改Comparable接口的实现类，
 *   而实现Comparator的类是在外部进行比较的，不需要对实现类有任何修改。从这个角度说，实现Comparable接口的方式其实有些不太好，
 *  尤其在我们将实现类的.class文件打成一个.jar文件提供给开发者使用的时候。实际上实现Comparator 接口
 *  的方式后面会写到就是一种典型的策略模式。
 */
public class ComparatorDemo {

    public static void main(String[] args) {
        Students s1 = new Students("张三", 2);
        Students s2 = new Students("李四", 3);
        Students s3 = new Students("王五", 1);

        Students[] studentsArr = {s1, s2, s3};
        System.out.println("排序之前的顺序");
        for (Students s : studentsArr) {
            System.out.println(s);
        }

        Comparator<Students> comparator = new Comparator<Students>() {
            @Override
            public int compare(Students o1, Students o2) {
                return o2.getAge() - o1.getAge();
            }
        };

        Arrays.sort(studentsArr, comparator);
        System.out.println("排序后的顺序");

        for (Students s : studentsArr) {
            System.out.println(s);
        }

        System.out.println("-------------集合-----------");
        List<Students> list = new ArrayList<>();
        list.add(s1);
        list.add(s2);
        list.add(s3);
        System.out.println("列表排序前的结果");
        for (Students s : list) {
            System.out.println(s);
        }
        Collections.sort(list,comparator);
        System.out.println("列表排序后的结果：");
        for (Students s : list) {
            System.out.println(s);
        }

    }

}

/**
 *  根据学生年龄进行排序
 *  1. Student类没有实现Comparable接口
 */

class Students {
    private String name;
    private Integer age;

    public Students(String name, Integer age) {
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

    @Override
    public String toString() {
        return "Students{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
