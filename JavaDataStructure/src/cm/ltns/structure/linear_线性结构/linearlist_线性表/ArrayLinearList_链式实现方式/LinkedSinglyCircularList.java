package cm.ltns.structure.linear_线性结构.linearlist_线性表.ArrayLinearList_链式实现方式;

import sun.security.util.Length;

import java.util.LinkedList;

/**
 * 单向循环链表
 */
public class LinkedSinglyCircularList<E> {

    // 头节点
    private Node head;
    // 长度
    private int size;

    transient Node first;
    /**
     * Pointer to last node.
     * Invariant: (first == null && last == null) ||
     * (last.next == null && last.item != null)
     */
    transient Node last;

    // 构造函数
    public LinkedSinglyCircularList() {
        head = new Node();
        head.next = head;
        size = 0;
    }

    // 尾部插入
    public void add(E e) {
        Node cur = this.head;
        // 找出最后一个节点
        while (cur.next != this.head) {
            cur = cur.next;
        }
        Node node = new Node(e, null);
        node.next = cur.next;
        cur.next = node;
        size ++ ;
    }



    // 头插法
    public void add(int index, E e) {
        if (index < 0 || index > size + 1) {
            System.out.println("下标索引越界");
        }
        int cur = 0;
        Node p = head;
        Node q = head.next;
        while (cur < index - 1) { //获取index前一个节点
            p = q;
            q = p.next;
            cur++;
        }
        // p 为指定位置上的元素
        Node node = new Node(e, null);
        node.setNext(q);
        p.next = node;
        size ++;
    }

    //任意位置插入，第一个节点为0
    public boolean addIndex(int index, E data) {
        if (index < 0 || index > size + 1) {
            System.out.println("下标索引越界");
        }
        Node curNode = head;    // 当前元素
        for (int i = 0; i < index; i++) {
            curNode = curNode.next;
        }
        //cur就是index位置的前驱
        Node node = new Node(data,null);
        node.next = curNode.next;
        curNode.next = node;
        size ++;
        return true;
    }
        // 指定索引

    // 删除

    //插叙


    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        Node p = head;
        Node q = head.next;
        sb.append("head=").append(head.getData());
        for (int i = 1; i <= size; i++) {
            sb.append("-->" + q.getData());
            p = q;
            q = p.getNext();
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LinkedSinglyCircularList<String> linkedSinglyCircularList = new LinkedSinglyCircularList();
        linkedSinglyCircularList.addIndex(1,"a");
        linkedSinglyCircularList.addIndex(1,"b");
        linkedSinglyCircularList.addIndex(2,"c");
        System.out.println(linkedSinglyCircularList);

    }

    // 节点对象
    class Node {
        E data;
        Node next;

        public Node(E obj, Node next) {
            this.data = obj;
            this.next = next;
        }

        public Node() {
            this(null, null);
        }

        public E getData() {
            return data;
        }

        public void setData(E data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", next=" + next +
                    '}';
        }
    }
}
