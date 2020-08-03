package cm.ltns.basic.enum_枚举.demo2;

/**
 * 枚举类
 *  一、使用enum定义的、非抽象的枚举类默认会使用final修饰，因此枚举类不能派生子类
 *
 *  二、枚举类的构造器只能是private修饰的
 *
 *  三、所有枚举类都必须放在开头， 并且中间用逗号隔开， 最后加上分号（；）
 *
 *  四、所有枚举类都是用public static final 修饰。可以忽略，单系统也会自动加上
 *
 *  五、所有枚举类中都有一个values()方法，返回该枚举类的所有实例
 */
public enum  SeasonEnum {
    SPRING("春天", "spring"),
    SUMMER("夏天", "SUMMER"),
    FALL("秋天", "FALL"),
    WINTER("冬天", "WINTER1");

    private String name;
    private String desc;

    private SeasonEnum(String name, String desc){
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public static String getDescByName(String name){
        if (name == null || name == ""){
            return "";
        }
        for (SeasonEnum param : values()) {
            if (param.getName().equals(name)) {
                return param.getDesc();
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "SeasonEnum{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
