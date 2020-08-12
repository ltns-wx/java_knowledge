package cm.ltns.basic.array_数组.demo3_数组拷贝;

import java.util.Arrays;

/**
 * 数组的拷贝：
 *  使用Arrays.copy()方法可以实现copy，他们的底层使用system.arraycopy()；
 *
 */
public class CopyDemo {
    public static void main(String[] args) {
        delete();
    }

    /**
     *  基本使用
     */
    public static void basicUse() {
        /**
         *  第一个数组：原数组
         *  第二个参数：索引值，指从哪开始拷贝
         *  第三个参数：copy到的目标数组
         *  第四个参数：从目标数组的第几个开始
         *  第五个参数：拷贝个数
         */
        String[] sourceArr = {"a", "b", "c", "d", "e", "f", "g"};
        String[] tagerArr = new String[10];

        System.arraycopy(sourceArr, 2, tagerArr, 2, 4);
        System.out.println("copy的数组：" + Arrays.toString(tagerArr));

    }

    /**
     * 删除指定位置上的元素（其实也是拷贝，拷贝自身）
     */
    public static void delete() {
        // 删除 索引位置3的元素d
        int index = 3;
        String[] sourceArr = {"a", "b", "c", "d", "e", "f", "g"};

        System.arraycopy(sourceArr, index + 1, sourceArr, index, sourceArr.length - (index + 1));

        // 删除最后一个多余的
        sourceArr[sourceArr.length - 1] = null;
        System.out.println("删除指定元素后数组：" + Arrays.toString(sourceArr));

    }
}
