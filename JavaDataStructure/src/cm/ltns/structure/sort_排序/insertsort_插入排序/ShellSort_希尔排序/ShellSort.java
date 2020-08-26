package cm.ltns.structure.sort_排序.insertsort_插入排序.ShellSort_希尔排序;

import sun.security.util.Length;

import java.util.Arrays;
import java.util.logging.Level;

/**
 * 希尔排序
 * 1.先分组
 * 2.对每个分组的元素进行直接插入排序
 */
public class ShellSort {

    public static void main(String[] args) {
        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        shellSort(arr);
    }

    public static void shellSort1(int[] arr) {
        for (int def = arr.length / 2; def >= 1; def = def / 2) {
            System.out.println(def);
            for (int i = def; i < arr.length; i++) {
                //直接插入排序
                for (int j = i - def; j >= 0; j = j - def) {        // 交换
                    if (arr[j] > arr[j + def]) {
                        int temp = arr[j];
                        arr[j] = arr[j + def];
                        arr[j + def] = temp;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void shellSort(int[] arr) {
        for (int def = arr.length / 2; def >= 1; def = def / 2) {
            System.out.println(def);
            for (int i = def; i < arr.length; i++) {
                //直接插入排序
                int e = arr[i]; // 比较元素
                int post = i;
                while (post - def >= 0 && arr[post - def] > e) {
                    arr[post] = arr[post - def];
                    post = post - def;
                }
                arr[post] = e;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
