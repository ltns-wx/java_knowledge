package cm.ltns.basic.extend_.继承;

/**
 * Employee中的字段：
 * private String name;
 * public String age;
 * public static String salary;
 * public final String birthday = "birthday";
 */
public class TestDemo1 {

    public static void main(String[] args) {
        /**
         * 一、子类继承父类：会的到父类所有的字段、方法（除了private 和static 修饰）
         *
         * 二、继承对于私有成员你的问题：
         *     子类在继承父类时，严格的来讲会继承父类中的全部操作，但是对于所有的私有操作属于隐式继承，而所有的非私有操作属于显示继承.
         *
         * 三、继承时构造器的问题：
         *  子类继承父类，当子类创建对象的时候， 那么父类也要创建对象， 这是就需要子类构造器中包含父类构造器， 那么子类构造器中会默认有父类的无参构造器，
         *  如果父类没有无参数构造器，那么就需要使用super(参数)来显示的表明
         *
         *
         */
        Manage manage = new Manage();
        System.out.println(manage.age);
        System.out.println(manage.birthday);

        manage.run();
        manage.jump();

        String str = new String();
        System.out.println(str);

    }
}
