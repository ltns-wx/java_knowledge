package cm.ltns.basic.innerclass_内部类.闭包;

/**
 * 定义一个程序员对象 和一个老师的接口
 *
 * 如果有一个人，即使程序员、又是老师，那么他就需要继承Programmer类，和实现Teachable接口。
 * 问题是：Teachable 和 Programmer包含了相同的work()方法，也就是只能“教学”或者“编程”
 * 这个时候我们就可以效仿闭包
 */
public class Programmer {
    String name;

    public Programmer() {

    }

    public Programmer(String name) {
        this.name = name;
    }

    public void work() {
        System.out.println(name + "在等下敲键盘");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

interface Teachable {
    void work();
}

class ProgrammerTeacher extends Programmer implements Teachable {
    // 只能有一种work
    public void work() {

    }


}