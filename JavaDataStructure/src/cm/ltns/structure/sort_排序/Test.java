package cm.ltns.structure.sort_排序;

public class Test {

    static int i = 0;

    public static void main(String[] args) {
        System.out.println(d(45));
    }

    // 迭代算法
    public static int b(int i) {
        int sum = 1;
        for (int j = 1; j < i + 1; j++) {
            sum = j * sum;
        }
        return sum;
    }

    // 递归算法
    public static int a(int i) {
        if (i == 1) {
            return 1;
        } else {
            return i * a(i - 1);
        }
    }

    // 斐波那契数列 1 1 2 3 5 8 13 21 .... 从第二项开始，都是前两项的和
    // 时间复杂度2的n次密（2^n）
    public static int c(int num) {
        if (num == 1 || num == 2) {
            return 1;
        } else {
            return c(num - 1) + c(num - 2);
        }
    }

    // 使用迭代的方式实现斐波那契数列
    public static int d(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        int first = 1;
        int second = 2;
        int current = 0;
        for (int j = 3; j < n; j++) {
            current = first + second;
            first = second;
            second = current;
        }
        return current;
    }
}
