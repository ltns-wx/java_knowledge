package cm.ltns.structure.linear_线性结构.Statck.ArrayStack_数组实现.demo;

import cm.ltns.structure.linear_线性结构.Statck.ArrayStack_数组实现.ArrayStack;
import com.sun.org.apache.xpath.internal.operations.Or;

import java.math.BigDecimal;
import java.util.Arrays;

// 中缀表达式实现建议计算器

/**
 * 中缀表达式实现简易计算器：
 * 一、需要两个操作栈：操作符栈、数字栈
 * 操作符栈
 * 数字栈
 *  1.如果遇到数组，则直接进入数字栈
 *  2.如果遇到操作符
 *      2.1 如果操作符栈为空，则直接进
 *      2.2 如果操作符栈定位（,则直接进
 *      3.3 如果操作符栈定位其他操作符
 *          3.3.1 如果当前操作符比栈顶操作符的优先级大，则直接进
 *          3.3.2 如果当前操作符比栈顶的优先级等于或者小于，则将操作符栈中，较高的操作符处理掉
 *  3.如果操作符为），将操作符中（上面的操作符处理掉，最终（ 出栈
 *
 */
public class InfixCalculator {
    String expression = "(2+2)/2";

    public static void main(String[] args) {
        String expression = "(1-3)+1.1";
        String s = insertBlanks(expression);
        System.out.println("添加分隔符的结果" + s);
        String[] tokens = s.split("#"); //注意空字符串
        System.out.println(Arrays.toString(tokens));

        // 创建两个队列
        // 存放操作符栈
        ArrayStack<Character> opr = new ArrayStack<>(); // 操作符
        //存放数字栈
        ArrayStack<BigDecimal> nums = new ArrayStack<>(); // 操作符

        // 存放数字
        for (String string : tokens) {
            if (tokens.length == 0 || string == null || string.equals("")) {
                continue;
            }
            // 先判断是否是 （
            if (string.equals("(")) {
                opr.push(string.charAt(0));
            } else if ("+".equals(string) || "-".equals(string) || "*".equals(string) || "/".equals(string)) { // 如果是+/-操作符
                // 获取栈顶的操作符
                if (opr.isEmpty()) {
                    opr.push(string.charAt(0));
                    continue;
                }
                Character headOpr = opr.getHead();
                // 如果是(，则直接添加，
                if (headOpr == '(') {
                    opr.push(string.charAt(0));
                } else if ((char) headOpr == '*' || (char) headOpr == '/') {
                    processAnOperator(nums, opr);
                    opr.push(string.charAt(0));
                } else {
                    // 直接进
                    opr.push(string.charAt(0));
                }

            } else if (")".equals(string)) {
                // 把 （ 到 ） 的内容都需要处理掉
                while ('(' != opr.getHead()) {
                    processAnOperator(nums, opr);
                }
                opr.pop();  // 弹出（
            } else {
                nums.push(new BigDecimal(string));
            }

        }

        // 处理栈里面剩下的内容
        while (!opr.isEmpty()) {
            processAnOperator(nums, opr);
        }

        System.out.println("处理结果" + nums.pop());

    }

    private static void processAnOperator(ArrayStack<BigDecimal> nums, ArrayStack<Character> opr) {
        char op = opr.pop();
        BigDecimal bigDecimal1 = nums.pop();
        BigDecimal bigDecimal2 = nums.pop();
        if (op == '+') {
            nums.push(bigDecimal2.add(bigDecimal1));
        }
        if (op == '-') {
            nums.push(bigDecimal2.subtract(bigDecimal1));
        }
        if (op == '*') {
            nums.push(bigDecimal2.multiply(bigDecimal1));
        }
        if (op == '/') {
            nums.push(bigDecimal2.divide(bigDecimal1));
        }

    }

    // 在数组和运算符之间添加分隔符 #
    private static String insertBlanks(String expression) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < expression.length(); i++) {
            if (isOperator(expression.charAt(i))) {
                sb.append("#");
                sb.append(expression.charAt(i));
                sb.append("#");
            } else {
                sb.append(expression.charAt(i));
            }
        }
        return sb.toString();
    }

    // 判断是运算符 还是数字
    public static boolean isOperator(char c) {
        switch (c) {
            case '+':
            case '-':
            case '*':
            case '/':
            case '(':
            case ')':
            case '#':
                return true;
            default:
                return false;
        }

    }
}
