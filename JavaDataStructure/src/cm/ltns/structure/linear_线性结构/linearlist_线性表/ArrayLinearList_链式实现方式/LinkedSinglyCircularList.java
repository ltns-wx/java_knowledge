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
       head = null;
        size = 0;
    }

    // 尾部插入
//    public void addEnd(E e) {
//        Node cur = this.head;
//
//        // 找出最后一个节点
//        while (cur.next != this.head) {
//            cur = cur.next;
//        }
//        Node node = new Node(e, null);
//        if (size == 0) {
//            head = node;
//            node.next = head;
//        } else {
//            // 先把当前节点 赋给 新增加节点的下一个节点（这样就不会出现问题）
//            node.next = cur.next;
//            // 然后再把新节点赋给当前节点
//            cur.next = node;
//        }
//        size++;
//    }

    // 头插法
//    public void addStart(E e) {
//        Node node = new Node(e, null);
//        // 尾部节点
//        Node cur = this.head;
//        // 找出最后一个节点
//        while (cur.next != this.head) {
//            cur = cur.next;
//        }
//        if (size == 0) {
//            head = node;
//            node.next = head;
//        } else {
//            node.next = head;
//            head = node;
//            cur.next = head;
//        }
//        size++;
//    }


    //插入指定索引位置（相当于移动指针）
    public boolean addIndex(int index, E data) {
        if (index < 0 || index > size + 1) {
            System.out.println("下标索引越界");
        }
        Node lastNode = head;    // 尾部节点
        for (int i = 0; i < size; i++) {
            lastNode = lastNode.next;
        }
        Node node = new Node(data, null);
        boolean isEmpty = size == 0 && head == null && lastNode == null;
        if (isEmpty) {
            head = node;
            lastNode = node;
            lastNode.next = head;
        } else if (index == 0) {
            node.next = head;
            head = node;
            lastNode.next = head;
        } else if (index == size) { // 表尾添加元素
            node.next = lastNode.next;
            lastNode.next = node;
            lastNode = node;   // 类似于指针移动
        }else{
            Node p = head ;
            for (int i = 0; i < index-1; i++) {
                p = p.next;
            }
            node.next =p.next;
            p.next =node ;
        }
        size++;
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
        for (int i = 1; i < size; i++) {
            sb.append("-->" + q.getData());
            p = q;
            q = p.getNext();
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LinkedSinglyCircularList<String> linkedSinglyCircularList = new LinkedSinglyCircularList();
        linkedSinglyCircularList.addIndex(0,"a");
        linkedSinglyCircularList.addIndex(0,"b");
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
