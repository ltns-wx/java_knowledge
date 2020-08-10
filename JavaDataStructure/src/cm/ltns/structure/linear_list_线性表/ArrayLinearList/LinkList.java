package cm.ltns.structure.linear_list_线性表.ArrayLinearList;

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
     * 二、找n-1位置上的元素
     * 三、n-1的节点的next = 该节点、 该节点的next就是next-1节点的next
     * <p>
     * head--->a--->b---->c--->d
     */
    public boolean add(T t, int pos) {
        if (pos < length && pos > 1) {
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
            q = q.next;
            num++;
        }
        p.next = new Node<T>(t, q);
        return true;
    }

    // 删除指定位置上的元素
    public boolean remove(int pos) {
        return false;
    }

    // 获取指定位置上的元素
    public T value(int pos) {
        return null;
    }

    // 获取某个节点的位置
    public int find(T t) {
        return 0;
    }

    // 更新链表中的某个节点
    public boolean modify() {
        return false;
    }

    // 判断是否为空
    public boolean isEmpty() {
        return false;
    }

    // 长度
    public int size() {
        return 0;
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

    }

    public static void main(String[] args) {
        LinkList<String> linkList = new LinkList<>();
        linkList.add("a",1);
        linkList.add("b",2);
        linkList.add("c",3);
        linkList.add("d",2);
        linkList.nextOrder();
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


    }
}
