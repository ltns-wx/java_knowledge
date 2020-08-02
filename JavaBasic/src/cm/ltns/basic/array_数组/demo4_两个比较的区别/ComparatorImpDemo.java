package cm.ltns.basic.array_数组.demo4_两个比较的区别;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 测试 某个类实现Comparator接口，能不能实现排序
 * 结果：实现comparator 接口，并不能直接满足Arrays.sort()直接排序
 */
public class ComparatorImpDemo {

    public static void main(String[] args) {
        Teacher t1 = new Teacher("张三",3);
        Teacher t2 = new Teacher("李四",1);
        Teacher t3 = new Teacher("王五",2);
        Teacher [] teachers = {t1,t2,t3};
        System.out.println("排序之前的顺序");
        for (Teacher s : teachers) {
            System.out.println(s);
        }

        // 排序
        Arrays.sort(teachers);
        System.out.println("排序过后结果：");
        for (Teacher s : teachers) {
            System.out.println(s);
        }



    }
}
class Teacher implements Comparator<Teacher> {
    private String name;
    private Integer age;

    public Teacher(String name, Integer age) {
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

    @Override
    public int compare(Teacher o1, Teacher o2) {

        return o1.getAge()-o2.getAge();
    }
}
