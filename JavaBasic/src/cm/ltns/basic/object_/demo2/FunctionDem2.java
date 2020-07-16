package cm.ltns.basic.object_.demo2;

/**
 * Java可变参数的传递（相同类型）
 */
public class FunctionDem2 {

    public static void main(String[] args) {
        int[] array1 = {1, 2, 3, 4, 5};
        // 相同参数 传递
        sumFun(1, 2, 3, 4, 5);
        // 传递数据
        sumFun1(array1);

        System.out.println("--------------------------------------------");
        // 可变参数：既可以接受数组、 也可以接受单个的参数
        sumFun2(array1);

        sumFun2(1, 2, 3, 4, 5);

        System.out.println("--------------------------------------------");

        // 注意：如果一个参数类型和可变参数类型相同，那么可变参数一定要放在最后。不然会有歧义

        System.out.println("--------------------------------------------");

        /**
         * 可变参数其实是语法糖、 底层还是把单数顶一个数据再去调用（反编译看源码）
         * 步骤：
         *  1.sumFun2(1, 2, 3, 4, 5);  把1,2,3,4,5定义一个数
         *  2.把sumFun2（int .. array）方法的参数变为 sumFun2（int [] array）
         *  3.数组作为形参去调用
         */
        sumFun2(1, 2, 3, 4, 5);
        int[] array2 = {1, 2, 3, 4, 5};
        sumFun1(array1);
    }

    public static void sumFun(int a, int b, int c, int d, int f) {
        int sum = a + b + c + d + f;
        System.out.println(sum);
    }

    public static void sumFun1(int[] array) {
        int sum = 0;
        for (int i : array) {
            sum = sum + i;
        }
        System.out.println(sum);
    }

    public static void sumFun2(int... array) {
        int sum = 0;
        for (int i : array) {
            sum = sum + i;
        }
        System.out.println(sum);

    }

    // 直接报错：Vararg parameter must be the last in the list
//    public static void sumFun3(int... array, int y) {
//    }


}
