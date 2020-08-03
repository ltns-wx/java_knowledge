package cm.ltns.basic.enum_枚举.demo2;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        System.out.println(SeasonEnum.SPRING);
        System.out.println(SeasonEnum.SPRING.getDesc());
        System.out.println(SeasonEnum.SPRING.getName());
        // 根据code获取desc
        System.out.println(SeasonEnum.getDescByName(SeasonEnum.SPRING.getName()));

        //所有枚举类中都有一个values()方法，返回该枚举类的所有实例
        SeasonEnum[] values = SeasonEnum.values();
        System.out.println(Arrays.toString(values));

        // 返回枚举值 在枚举中的索引位置（从0开始）
        System.out.println(SeasonEnum.FALL.ordinal());

        //name()返回枚举实例的名称
        System.out.println(SeasonEnum.WINTER.name());

    }
}
