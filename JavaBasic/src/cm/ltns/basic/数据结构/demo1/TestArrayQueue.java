package cm.ltns.basic.数据结构.demo1;

import java.lang.reflect.Array;
import java.sql.SQLOutput;
import java.util.Scanner;

/**
 * 队列（Queue）
 *  特点：先进先出
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

/**
 * 使用数组实现队列
 */
class ArrayQueue<T> {  // 使用泛型
    // 数组的最大值
    private Integer maxsize;
    // 定义头指针的位置
    private Integer rear;// 指向队列头部，分析出front是指向队列头的前一个位置.（出栈所用）
    // 定义尾部指针
    private Integer front;// 指向队列尾，指向队列尾的数据(即就是队列最后一个数据)（入栈所用）

    private T[] t;

    // 构造函数
    public ArrayQueue(Class<T> clz, Integer maxsize) {
        this.maxsize = maxsize;
        // java中不允许创建带泛型的数组类，详情请参考泛型章节。
        // t = new T[maxsize];
        t = (T[]) Array.newInstance(clz, maxsize);
        this.front = -1; // 指向队列头部，分析出front是指向队列头的前一个位置.（出栈所用）
        this.rear = -1; // 指向队列尾，指向队列尾的数据(即就是队列最后一个数据)（入栈所用）
    }

    // 判断队列是否为空
    public boolean isEmpty() {
        return rear == front;
    }

    // 判断队列是否满
    public boolean isFull() {
        return rear == maxsize - 1; //判断队尾指针是不是在对吼一个元素上
    }

    // 添加数据到队列
    public void add(T data) {
        // 先判队列是否满
        if (isFull()) {
            System.out.println("队列已满，不能添加数据");
        }
        //像队首添加数据，并是尾部指针像移动
        rear++; // 让rear 后移
        this.t[rear] = data;
        System.out.println("====添加数据成功" + data);
    }

    // 出队列(出队列不是删除，而是front指针移动后，该位置上的元素)
    public void getQueue() {
        // 出队列，从队头查数据
        if (isEmpty()) {
            System.out.println("队列是空，不能够取出");
        }
        //
        front++;
        System.out.println("当前出栈的元素：" + t[front]);  //这里出栈不是删除g，而是队头指针移动所指的位置
    }

    // 显示队列的所有数据(队头 -- > 队尾)
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列为空....");
        }
        for ( int i = front + 1; i <= rear; ++i) {
            System.out.println("显示的数据" + t[i]);
        }
    }

    // 显示队列的头数据， 注意不是取出数据
    public void headQueue() {
        if (isEmpty()) {
            System.out.println("队列为空...");
        }
        System.out.println(t[front + 1]); // 这地方 + 1 是因为front是指向队列头的前一个位置
    }

}

