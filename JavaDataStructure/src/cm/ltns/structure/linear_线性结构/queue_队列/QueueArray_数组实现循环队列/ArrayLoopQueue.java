package cm.ltns.structure.linear_线性结构.queue_队列.QueueArray_数组实现循环队列;

/**
 * 双端队列
 * 一、判断条件
 *  1.判断队列为null的条件 front=rear
 *  2.判断队列满：（rear + 1） % maxsize = front
 */
public class ArrayLoopQueue<E> {
    // 定义数组
    private E[] array;
    //定义头指针
    private int front;
    // 定义尾指针
    private int rear;

    private int size;

    private int default_size = 10;

    // 无参构造函数
    public ArrayLoopQueue() {
        array = (E[]) new Object[default_size + 1]; //+1 是因为有一个不可用
        front = 0;
        rear = 0;
        size = 0;
    }

    // 有参构造函数
    public ArrayLoopQueue(int size) {
        array = (E[]) new Object[size + 1];
        front = 0;
        rear = 0;
        size = 0;
    }

    //入队列
    public void offer(E e) {
        if (isFull()) {
            new Exception("队列已满");
        }
        array[rear] = e;
        rear = (rear + 1) % array.length;
        size++;
    }

    //出队列: 检索并删除此队列的头，如果此队列为空，则返回 null 。
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        E e = array[front];
        front = (front + 1) % array.length;
        return e;
    }

    // 判断是否满
    public boolean isFull() {
        if ((rear + 1) % array.length == front) {
            return true;
        }
        return false;
    }
    // 长度

    // 判断是否为null
    public boolean isEmpty() {
        if (front == rear) {
            return true;
        }
        return false;
    }


    // 清空队列
    public void clear() {
        array = (E[]) new Object[array.length];
        front = 0;
        rear = 0;
        size = 0;
    }

    //检索但不删除此队列的头，如果此队列为空，则返回 null
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        E e = array[front];
        return e;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(String.format("ArrayLoopQueue:%d,%d[" + size,array.length-1));

        if (isEmpty()){
            stringBuilder.append("]");
        }else{
            for (int i = front; i != front ; i = (i+1)%array.length) {
                    stringBuilder.append(array[i]);
                    if ((i+1)%array.length == rear){
                        stringBuilder.append("]");
                    }else {
                        stringBuilder.append(",");
                    }
            }
        }
        return  stringBuilder.toString();
    }

    public static void main(String[] args) {
        ArrayLoopQueue<String> arrayLoopQueue = new ArrayLoopQueue<>();
        arrayLoopQueue.offer("a");
        arrayLoopQueue.offer("a");
        arrayLoopQueue.offer("a");
        arrayLoopQueue.offer("a");
        arrayLoopQueue.offer("a");
        System.out.println(arrayLoopQueue);
    }
}
