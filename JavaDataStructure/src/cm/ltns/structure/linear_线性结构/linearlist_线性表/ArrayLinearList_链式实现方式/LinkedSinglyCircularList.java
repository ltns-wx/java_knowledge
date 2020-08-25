package cm.ltns.structure.linear_线性结构.linearlist_线性表.ArrayLinearList_链式实现方式;

import sun.security.util.Length;

import java.util.LinkedList;

/**
 * 单向循环链表： 该类头结点是真是你节点
 *
 * 一、没有head， 初始化的时候头指针和尾指针都是null
 */
public class LinkedSinglyCircularList<E> {

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
        first = null;
        last = null;
        size = 0;
    }

    //任意位置插入，根据索引位置（索引位置为0， 那么就是放在头部）
    public boolean addIndex(int index, E data) {
        if (index < 0 || index > size) {
            System.out.println("下标索引越界");
        }
        Node node = new Node(data, null);
        // 插入分情况
        if (isEmpty()) {
            first = node;   // 头指针指向第一个元素
            last = node;    // 尾指针指向第一个元素
            node.next = node;   // 让第一个元素形成一个环
        } else if (index == 0) { // 头插入：
            node.next = first;
            first = node;
            last.next = first;
        } else if (index == size) { //尾部插入
            last.next = node;
            last = node;
            node.next = first;
        } else {  // 中间插入
            // 查到索引位置上的元素
            Node curNode = first;
            int cur = 1;
            while (cur < index - 1) {
                curNode = first.next;
            }
            node.next = curNode.next;
            curNode.next = node;
        }
        size++;
        return true;
    }

    // 判断是否为null
    public boolean isEmpty() {
        if (size == 0 && first == null && last == null) {
            return true;
        }
        return false;
    }

    // 删除指定索引位置上的节点
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("删除角标非法");
        }
        // 判断循环列表是否为空
        if (isEmpty()) {
            System.out.println("该链表为null");
            return null;
        }
        E e = null;
        if (size == 1) {
            first = null;
            last = null;
        } else if (index == 0) {    // 删除头结点
            e = first.getData();
            first = first.next;
            last.next = first;
        } else if (index == size-1) { // 删除尾节点
            Node cur = first;
            while (cur.next != last) {
                cur = cur.next;
            }
            e = cur.next.data;
            cur.next = first;
            last = cur;
        } else {    // 删除其他位置
            Node curNode = first;
            int cur = 0;
            while (cur < index - 1) {
                curNode = curNode.next; // 要删除节点的前一个
            }
            e = curNode.next.data;
            curNode.next = curNode.next.next;
        }
        size--;
        return e;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LinkedSinglyCircularList:size=" + size);
        if (isEmpty()) {//判空
            sb.append("[]");
        } else {
            sb.append("[");
            Node p = first;
            while (true) {
                sb.append(p.getData());
                if (p.next == first) {
                    sb.append(']');
                    break;
                } else {
                    sb.append(',');
                }
                p = p.next;
            }
        }
        return sb.toString();

    }

    public static void main(String[] args) {
        LinkedSinglyCircularList<String> linkedSinglyCircularList = new LinkedSinglyCircularList();
        linkedSinglyCircularList.addIndex(0, "a");
        linkedSinglyCircularList.addIndex(0, "b");
        linkedSinglyCircularList.addIndex(2, "c");  // 索引位置
        linkedSinglyCircularList.addIndex(1, "e");  // 索引位置
        System.out.println(linkedSinglyCircularList);
        linkedSinglyCircularList.remove(0);
        linkedSinglyCircularList.remove(2);
        System.gc();
        System.runFinalization();
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
        protected void finalize() throws Throwable {
            System.out.println(this.data + "该元素即将被删除");
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
