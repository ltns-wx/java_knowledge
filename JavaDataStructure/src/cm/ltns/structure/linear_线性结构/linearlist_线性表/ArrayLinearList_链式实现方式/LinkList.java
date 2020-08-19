package cm.ltns.structure.linear_线性结构.linearlist_线性表.ArrayLinearList_链式实现方式;

/**
 * 单向列表：
 * <p>
 * 一、主要是查出指定位置上的元素
 */
public class LinkList<T> {
    //头指针
    private Node<T> head;
    // 单链表长度
    private int length;

    // 构造函数
    public LinkList() {

        head = new Node<T>(null);
        length = 0;
    }

    //获取头结点地址
    public Node<T> getHead() {
        return head;
    }

    /**
     * 插入一个元素：是指在post-1位置和pos位置中间插入一个新的元素
     * 一、首先判断位置的合法性
     * 二、找是指在post-1位置上的元素
     * 三、是指在post-1的节点的next = 新增加节点、 该节点的next就是next-1节点的next
     * <p>
     * head--->a--->b---->c--->d
     */
    public boolean add(T t, int pos) {
        if (pos > length + 1 || pos < 1) {
            System.out.println("索引越界");
            return false;
        }
        // 查找 pos位置的元素
        int num = 1;
        // 插入位置的（n-1）的节点
        Node<T> p = head;
        // 插入位置的（n-1）的元素的下一个节点
        Node<T> q = head.next;
        while (num < pos) {
            p = q;
            q = p.next;
            num++;
        }
        p.next = new Node<T>(t, q);
        length++;
        return true;
    }

    // 在末尾添加一个
    public boolean add(T t) {
        // 查找 pos位置的元素
        int num = 1;
        // 插入位置的（n-1）的节点
        Node<T> p = head;
        // 插入位置的（n-1）的元素的下一个节点
        Node<T> q = head.next;
        while (num <= length) {
            p = q;
            q = p.next;
            num++;
        }
        p.next = new Node<T>(t, q);
        length++;
        return true;
    }


    /**
     * 删除一个索引的节点
     * 1.找到上一个节点的next对象
     * 2.找到下一个节点的Note对象
     */
    public boolean remove(int pos) {
        if (pos > length + 1 || pos < 1) {
            System.out.println("下标索引越界");
            return false;
        }
        int cur = 1;
        Node<T> p = head;
        Node<T> q = head.next;
        while (cur < pos) {
            p = q;
            q = p.next;
            cur++;
        }
        p.setNext(p.next);
        return false;
    }

    // 获取指定位置上的元素
    public T value(int pos) {
        if (isEmpty()) {
            System.out.println("链表为null");
            return null;
        }
        if (pos < 1 && pos > length + 1) {
            System.out.println("下标索引越界");
            return null;
        }
        int cur = 1;
        Node<T> p = head;
        Node<T> q = head.next;
        // 获取指定位置上的元素
        while (cur < pos) {
            p = q;
            q = p.next;
            cur++;
        }
        return q.getData();
    }

    // 获取某个节点的位置： head--->a--->b---->c--->d
    public int find(T t) {
        if (isEmpty()) {
            System.out.println("链表为null");
            return -1;
        }
        int cur = 1;
        Node<T> p = head;
        while (cur <= length) {
            p = p.next;
            if (p.getData().equals(t)) {
                return cur;
            }
            cur++;
        }
        return -1;
    }

    // 更新链表中的某个节点
    public boolean modify(int pos, T t) {
        if (isEmpty()) {
            System.out.println("链表为null");
            return false;
        }
        if (pos < 1 && pos > length + 1) {
            System.out.println("下标索引越界");
            return false;
        }
        int num = 1;

        return false;
    }

    // 判断是否为空
    public boolean isEmpty() {
        if (length == 0) {
            return true;
        }
        return false;
    }

    // 长度
    public int size() {
        return length;
    }

    // 打印所有元素
    public void nextOrder() {
        if (head != null) {
            Node<T> next = head.next;
            while (next != null) {
                System.out.println(next.getData());
                next = next.next;
            }
        } else {
            System.out.println("该链表为空");
        }
    }

    // 清空元素
    public void clear() {
        length = 0;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        Node<T> p = head;
        Node<T> q = head.next;
        sb.append("head=").append(head.getData());
        for (int i = 1; i <= length; i++) {
            sb.append("-->" + q.getData());
            p = q;
            q = p.getNext();
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LinkList<String> linkList = new LinkList<>();

        linkList.add("a");
        linkList.add("b");

        System.out.println(linkList.toString());
        System.out.println("获取位置3的元素：" + linkList.value(3));
        linkList.nextOrder();
        System.out.println("---移除---");
        linkList.remove(2);
        linkList.remove(3);
        linkList.nextOrder();
        System.out.println("---长度--");
        System.out.println("链表长度" + linkList.size());
        System.out.println("查找a节点的位置" + linkList.find("a"));
        System.out.println("查询aa节点的位置" + linkList.find("aa"));
    }

    /**
     * 每一个元素成为一个节点，
     * 对于一个节点，有两部分组成
     * 1.存储自身元素
     * 2.存储指向下一个元素的指针
     */
    class Node<T> {
        T t;
        Node<T> next;

        public Node(T obj, Node<T> next) {
            this.t = obj;
            this.next = next;
        }

        public Node(Node<T> node) {
            next = node;
        }

        // 该节点内容
        public T getData() {
            return t;
        }

        // 下一个元素
        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        public void setT(T t) {
            this.t = t;
        }
    }
}
