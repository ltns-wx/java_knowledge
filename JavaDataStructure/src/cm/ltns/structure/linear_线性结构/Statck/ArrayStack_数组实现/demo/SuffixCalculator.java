package cm.ltns.structure.linear_线性结构.Statck.ArrayStack_数组实现.demo;

import cm.ltns.structure.linear_线性结构.Statck.ArrayStack_数组实现.ArrayStack;

import java.math.BigDecimal;

/**
 *  后缀表达式来实现简单计算器
 *
 */
public class SuffixCalculator {

    public static void main(String[] args) {
        String expression = "(10+20/2*3)/2+8";
        String s = insertBlanks(expression);
        expression = switchExpression(s);
        System.out.println(expression);
        String[] s1 = expression.split(" ");
        for (String string: s1) {
            // 如果是数组，则进栈
            // 如果是操作符，则弹出两个进行计算
        }
    }

    // 先把中缀表达式换成后缀表达式
    public static String switchExpression(String expression) {
        // 存放操作符栈
        ArrayStack<Character> opr = new ArrayStack<>(); // 操作符
        //存放数字栈
        ArrayStack<Object> nums = new ArrayStack<>(); // 操作符
        String[] split = expression.split("#");
        for (String s : split) {
            // 判断元素为空
            if (s == null || s.equals("")) {
                continue;
            }
            // 判断是不是 运算符
            if (isOperator(s.charAt(0))) {
                if (opr.isEmpty() || opr.getHead() == '(') {
                    opr.push(s.charAt(0));
                } else if (s.charAt(0) == '+' || s.charAt(0) == '-' ||  s.charAt(0) == '*' || s.charAt(0) == '/') {
                    Character headOpr = opr.getHead();
                    // 判断头是不是 乘除、 如果是，则需要取出来
                    if ((char)headOpr == '*' || (char)headOpr == '/'){
                        nums.push(opr.pop());
                        opr.push(s.charAt(0));
                    }else {
                        // 最后一种情况是+- 的 直接存放
                        opr.push(s.charAt(0));
                    }
                }else if (s.charAt(0) == ')'){
                    while (opr.getHead() != '('){
                        nums.push(opr.pop());
                    }
                }
            } else {
                //存放数组
                nums.push(s);
            }
        }
        // 把nums 变成String
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < nums.size(); i++) {
            System.out.println(i + "索引位置的元素为：" + nums.get(i));
            sb.append(nums.get(i) + " ") ;
        }
        return sb.toString();
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
