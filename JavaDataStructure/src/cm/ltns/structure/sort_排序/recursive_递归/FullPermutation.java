package cm.ltns.structure.sort_排序.recursive_递归;

/**
 * 全排列：ABC 三个字符的排列顺序
 *
 */
public class FullPermutation {
    public static void main(String[] args) {
        String s = "ABC";
        char[] arr = s.toCharArray();
        permutation(arr, 0, arr.length - 1);
    }

    private static void permutation(char[] arr, int from, int to) {
        if (from == to) {
            System.out.println(String.valueOf(arr));
        }
        /**
         * 思路：
         *     一、第一个元素和第一位交换
         *          1.1第二个元素和第二个元素交换
         *              第二个元素和第三个元素交换
         *             ...
         *             第2个元素和第n索引为之元素进行交换
         *
         *     二、第一位元素和第二位交换
         *
         *     ...
         *
         *     n、第一位元素和第n为元素交换
         *
         * 一、第一轮for循环 (i=0时，from=0 to=3)
         *      swap([A,B,C], 0 ,0)  // 确定第一个位置A
         *      permutation([A,B,C],1, 3)
         *          第一轮循环（i= 1 ， from=1， to=3）
         *              swap([A,B,C], 1 ,1)     // 确定第二个位置B
         *              permutation([A,B,C],2, 3)
         *                  第一轮循环（i=2 from=2, to=3）
         *                      swap([A,B,C], 2 ,2)
         *                      permutation([A,B,C], 3 ,3)  //当from=to时候，打印数组
         *                      swap([A,B,C], 2 ,2)
         *              swap([A,B,C], 1 ,1)
         *          第二轮循环（i=2， from=1, to=3）
         *               swap([A,B,C], 2 ,1)   // 交换BC的位置
         *               permutation([A,C,B],2, 3)
         *               swap([A,B,C], 2 ,1)    //回来原来位置
         *      swap([A,B,C], 0 ,0)  // 返回原来位置
         *
         * 二、第二轮循环（i=1, from=0 , to=3）
         *       swap([A,B,C], 1 ,0)    // 还是确定第一个位置B
         *
         * 三、第三次循环（i=2, from =0, to=3）
         *
         * 四、第四次循环
         *
         */
        for (int i = from; i <= to; i++) {
            swap(arr, i, from);
            permutation(arr, from + 1, to);
            swap(arr, i, from);
        }
    }

    private static void swap(char[] arr, int a, int b) {
        char temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
