package cm.ltns.basic.流程控制.for_循环;

/**
 *  for 循环：
 *      语法： for([表达式];[表达式];[表达式])
 *      要形成一个表达式语句,则表达式E必须只能是:
 *          1)赋值表达式,
 *          2)自增++表达式,
 *          3)自减--表达式,
 *          4)方法调用表达式,
 *          5)new 表达式（对象创建表达式）
 */
public class Demo {
    public static void main(String[] args) {
        int i = 0;
//        for(i ; i < 10 ; i ++) {}  // 这种写法是错误的，第一个i不能构成表达式
        // 我们可以省略
        for (; i < 10; i++) {

        }

    }
}
