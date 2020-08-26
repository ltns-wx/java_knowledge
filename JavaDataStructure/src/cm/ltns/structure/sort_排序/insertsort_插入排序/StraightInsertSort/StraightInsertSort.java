package cm.ltns.structure.sort_排序.insertsort_插入排序.StraightInsertSort;

import java.util.Arrays;

/**
 * 插入排序：直接插入排序和希尔排序
 * 一、 直接插入排序
 *      1.时间复杂度O（n^2）
 *      2.冒泡、选择、插入时间复杂度都是一样的，但是直接插叙排序比较快
 */
public class StraightInsertSort {

    public static void main(String[] args) {
        int[] arr = {49, 38, 13, 27, 55, 4, 49, 1};
        insertSort(arr);
    }

    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int e = arr[i];  // 将要排序的元素
            int j = i;      // 将要排序元素的位置
            for (; j > 0 && arr[j - 1] > e; j--) { // 那i和i之前的元素进行比较， 当j>0并且arr[j - 1] > e时候
                arr[j] = arr[j - 1];
            }
            arr[j] = e;
        }
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 优化：从后往前比较
     */
    public static void insertSort3(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0 && arr[j - 1] > arr[j]; j--) {  // 从后往前比较。 这样虽然可能会导致交换次数减少，但还是有
                int temp = arr[j];                                // 优化：拿最后一个比较，不交换、只复制。
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    //直接插入排序
    public static void insertSort2(int[] arr) {
        if (arr == null || arr.length == 0) {
            System.out.println("排序的数组为null");
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {       // 从前往后排序，会导致多增加交换，影响效率，改进：从后往前进行进行比较。
                if (arr[j] > arr[i]) { // 交换
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }


    public static void insertSort1(int[] arr) {
        int cur = 0;
        if (arr == null || arr.length == 0) {
            System.out.println("排序的数组为null");
        }
        // 定义一个新的数组
        int[] newArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) { //取出 来一个元素
            if (cur == 0) {
                newArr[i] = arr[i];
            }
            for (int j = 0; j < cur; j++) {   //遍历、比较、存放
                if (arr[i] <= newArr[j]) {
                    //
                    for (int k = cur; k > j; k--) { //再j的位置上插入
                        newArr[k] = newArr[k - 1];
                    }
                    newArr[j] = arr[i];
                    break;
                } else {
                    newArr[cur] = arr[i];
                }

            }

            cur++;
        }
        System.out.println(Arrays.toString(newArr));
    }


}
