package cm.ltns.basic.object_.demo1;

public class Person {
    private String name;
    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    //将在垃圾回收器清除对象之前调用。
    @Override
    protected void finalize() throws Throwable {
        System.out.println("该对象再垃圾回收器清除之前调用");
    }

    public static void main(String[] args) {
        Person p = new Person();
        p = null;
    }
}
