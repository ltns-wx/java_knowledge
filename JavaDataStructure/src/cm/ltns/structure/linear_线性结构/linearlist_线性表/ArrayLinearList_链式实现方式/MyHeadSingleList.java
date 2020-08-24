package cm.ltns.structure.linear_线性结构.linearlist_线性表.ArrayLinearList_链式实现方式;

/**
 * 这种是有head头的
 */
public class MyHeadSingleList {
    class Node {  //内部节点类
        private int data;  //节点数据
        private Node next;  //下一个节点引用

        public Node(int data) {  //带参数的构造方法，用于实例化普通节点
            this.data = data;
            this.next = null;
        }

        //头结点
        public Node() {  //不带参数的构造方法，用于实例化头节点
            this.data = -1;
            this.next = null;
        }
    }

    private Node head;//声明头节点

    public MyHeadSingleList() {  //外部类无参构造方法
        this.head = new Node();   //实例化头节点
        this.head.next = this.head;  //构成循环链表
    }

    //头插法
    public void addFirst(int data) {
        Node node = new Node(data);
        node.next = this.head.next;
        this.head.next = node;
    }

    //尾插法
    public void addLast(int data) {
        Node cur = this.head;
        while (cur.next != this.head) {
            cur = cur.next;
        }
        Node node = new Node(data);
        node.next = cur.next;
        cur.next = node;
    }

    //检验位置合法性
    private void checkIndex(int index) {
        if (index < 0 || index > getLength()) {
            throw new UnsupportedOperationException("index位置不合法");
        }
    }

    //任意位置插入，第一个节点为0
    public boolean addIndex(int index, int data) {
        checkIndex(index);
        Node cur = this.head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        //cur就是index位置的前驱
        Node node = new Node(data);
        node.next = cur.next;
        cur.next = node;
        return true;
    }

    //是否包含关键字key
    public boolean contains(int key) {
        Node cur = this.head.next;//head没有数据，从第一个节点开始查找
        while (cur != this.head) {
            if (cur.data == key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    //查找节点前驱
    private Node searchPrev(int key) {
        Node cur = this.head;
        while (cur.next != this.head) {//从头节点开始遍历
            if (cur.next.data == key) {
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }

    //删除第一次出现的关键字key
    public int remove(int key) {
        Node prev = searchPrev(key);
        if (prev == null) {
            throw new UnsupportedOperationException("没有key的前驱");
        }
        int oldData = 0;
        Node del = prev.next;
        oldData = del.data;
        prev.next = del.next;
        return oldData;
    }


    //删除所有值为key的关键字
    public void removeAllKey(int key) {
        if (this.head == null || this.head.next == this.head) {
            return;
        }
        Node prev = this.head;
        Node cur = this.head.next;
        while (cur != this.head) {
            if (cur.data == key) {
                prev.next = cur.next;
                cur = prev.next;
            } else {
                prev = cur;
                cur = cur.next;
            }
        }
    }

    //获取链表的长度
    public int getLength() {
        int count = 0;
        Node cur = this.head.next;//链表的长度不包括头节点
        while (cur != this.head) {
            count++;
            cur = cur.next;
        }
        return count;
    }

    //打印链表元素
    public void display() {
        Node cur = this.head.next;//不需要打印头节点
        while (cur != this.head) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    //清空链表
    public void clear() {
        while (this.head.next != this.head) {
            Node cur = this.head.next;
            this.head.next = cur.next;
        }
        this.head = null;

    }

    public static void main(String[] args) {
        MyHeadSingleList myHeadSingleList = new MyHeadSingleList();
        myHeadSingleList.addLast(1);
        myHeadSingleList.addLast(2);
        myHeadSingleList.addLast(3);
        myHeadSingleList.display();
    }
}