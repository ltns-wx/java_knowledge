package cm.ltns.structure.linear_线性结构.queue_队列.QueueArray_数组实现;

import java.lang.reflect.Array;

/**
 * 使用数组实现队列：（first in  first out）
 * 头指针始终指向队列头元素的前一个位置，尾指针始终指向队列尾元素的位置
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
        // 为什么初始化为-1？ 因为指针值得为之已经有数据了
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
        for (int i = front + 1; i <= rear; ++i) {
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

