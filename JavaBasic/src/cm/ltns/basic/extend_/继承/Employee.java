package cm.ltns.basic.extend_.继承;

public class Employee {
    private String name;

    public String age;

    public static String salary;

    public final String birthday = "birthday";

    public Employee(){
        System.out.println("Employee 的无惨构造函数2");
    }

    public static void eat() {
        System.out.println("父类中的static修饰的eat方法");
    }

    public void run() {
        System.out.println("父类中的run方法");
    }

    public final void jump() {
        System.out.println("父类中final的修饰jimp方法");
    }
}
