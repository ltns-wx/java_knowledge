package cm.ltns.basic.enum_枚举;

/**
 * 枚举继承问题：-
 */
// 性别枚举
public enum Gender implements GenderDesc {

    MALE, FEMALE;

    // 实现接口中的方法
    @Override
    public void info() {
        System.out.println("枚举类实现接口的方法...");
    }
}


// 性别描述
interface GenderDesc {
    public void info();
}

/**
 * 从上面的枚举类可以看出，再枚举类中实现接口的方法，那么所有枚举对象只是有相同的方法，
 * 如果需要每个枚举值在调用该方法时，呈现不同的行为，则可以让每个枚举对象分别实现
 * <p>
 * 改造Gender
 *
 * 其实枚举类后面的大括号，相当于一个类体，类似于匿名内部类
 */

enum Gender2 implements GenderDesc {
    MALE("男") {
        @Override
        public void info() {
            System.out.println("这是MALE枚举实现的接口方法...");
        }
    },
    FEMALE("女") {
        @Override
        public void info() {
            System.out.println("这是FEMALE枚举实现的接口方法...");
        }
    };

    private String  name ;
    private Gender2(String name){
        this.name = name;
    }
}