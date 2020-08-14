package cm.ltns.structure.linear_线性结构.queue_队列.QueueArray_数组实现;

import java.util.Scanner;

/**
 * 队列（Queue）
 *  特点：先进先出
 *
 *  队列的操作
 *      1.初始化
 *      2.入队
 *      3.出队
 *      4.获取队头
 *      5.求长度
 *      6.判断队列是否为空
 *      7.正序遍历
 *      8.销毁
 *
 */
public class TestArrayQueue {

    public static void main(String[] args) {


        //创建一个队列
        ArrayQueue<String> arrayQueue = new ArrayQueue<String>(String.class, 3);
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("（1）s(show)显示队列");
            System.out.println("（2）e(exit)退出程序");
            System.out.println("（3）a(add)添加");
            System.out.println("（4）s(show)显示");
            System.out.println("（5）g(取出)");
            // key接受一个字符串
            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    arrayQueue.showQueue();
                    break;
                case 'e':
                    scanner.close();
                    break;
                case 'a':
                    System.out.println("-->请输入一个元素");
                    String data = scanner.next();
                    arrayQueue.add(data);
                    break;
                case 'g':
                    arrayQueue.getQueue();
                    break;
                case 'h':
                    break;

                default:
                    System.out.println("请输入合法的关键字");
            }

        }
    }

}

