package cm.ltns.basic.enum_枚举.demo1;

/**
 * 手动实现枚举类
 * 一、私有化构造器
 * 二、把这个类中所有可能实例都用public static final 修饰的变量来保存
 * 三、
 */
public class Season {
    private final String name;
    private final String desc;

    public static final Season spring = new Season("春天", "spring");
    public static final Season summer = new Season("夏天", "summer");
    public static final Season fall = new Season("秋天", "fall");
    public static final Season winter = new Season("冬天", "winter");

    private Season(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public static Season getSpring() {
        return spring;
    }



    public static void main(String[] args) {
        System.out.println("");
    }
}
