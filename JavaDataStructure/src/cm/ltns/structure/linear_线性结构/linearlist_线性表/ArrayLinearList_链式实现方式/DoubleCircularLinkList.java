package cm.ltns.structure.linear_线性结构.linearlist_线性表.ArrayLinearList_链式实现方式;

/**
 * 双向循环列表
 */
public class DoubleCircularLinkList<E> {

    private Node head;
    private Node tail; // 尾指针
    private int size;

    public DoubleCircularLinkList() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * 在表头添加元素
     *      1.把head的pre 给新节点的pre    // 这个必须是吧head的pre 给 新节点的pre
     *      2.新节点的下一跳 指向head
     *      3.head的上一调，指向新节点的next
     *      4.更新head，让head指向新节点
     *      5.更新tail，让tail的next从新指向head
     *
     *  在表位添加元素
     *      1.把tail的下一跳元素 给 新节点的下一跳
     *      2.tail的下一跳 指向新节点
     *      3.新节点的上一条 指向tail
     *      4.tail从新指向新节点
     *      5.head的上一跳从新指向tail
     */
    public void add(int index, E data) {
        if (index < 0 || index > size) {
            System.out.println("下标索引越界");
        }
        Node node = new Node(data);
        if (isEmpty()) {    // 当链表为null时
            head = node;
            tail = node;
            tail.next = head;
            head.pre = tail;
        } else if (index == 0) { // 在表头添加
            node.pre = head.pre; // 这地方也可以这样写
            node.next = head;
            head.pre = node;
            head = node;
            tail.next = head;
        } else if (index == size) {
            node.next = tail.next;
            tail.next = node;
            node.pre = tail;
            tail = node;
            head.pre = tail;
        } else { //在其中间添加
            Node p, q;
            if (index <= size / 2) {
                p = head;
                for (int i = 0; i < index - 1; i++) {
                    p = p.next;
                }
                q = p.next;
                p.next = node;
                node.pre = p;
                q.pre = node;
                node.next = q;
            } else {
                p = tail;
                for (int i = size - 1; i > index; i--) {
                    p = p.pre;
                }
                q = p.pre;
                q.next = node;
                node.pre = q;
                p.pre = node;
                node.next = p;
            }
        }
        size++;

    }

    public boolean isEmpty() {
        return size == 0 && head == null && tail == null;
    }

    // 默认在表位添加
    public void add(int index) {

    }

    // 删除
    public void remove(E e) {
        int index = indexOf(e);
        if (index != -1) {
            remove(index);
        }
    }

    public int indexOf(E e){
        Node p = head;
        int index = 0;
        while(!p.data.equals(e)){
            p = p.next;
            index++;
            if (p ==head){
                return  -1;
            }
        }
        return index;
    }

    /**
     * 删除索引位置上的节点
     * 一、删除头元素
     *      1.node为head.next，为最终的新节点
     *      2.将head的next = null 置空， 原因
     *      3.将head的上一跳 给node的上一跳
     *      4.将head从新指向node
     *      3.把tail从新指向head
     *
     * 二、删除尾结点
     *      1.node为tail的pre
     *      2.将tail的上一跳置空
     *      2.tail的下一跳给node下一跳，
     *      4.tail的下一跳置空
     *      5.将tail从新指向node
     *      6.最后将head.pre从新指向tail
     */
    public E remove(int index) {
        if (index < 0 || index >= size) {
            System.out.println("删除时，下标索引越界");
        }
        E ret = null;
        Node node; //定义一个新的头结点或者尾结点
        if (size == 1) {
            ret = head.data;
            head = null;
            tail = null;
        } else if (index == 0) {
            ret = head.data;
            node = head.next;
            head.next = null;
            node.pre = head.pre;
            head.pre = null;
            head = node;
            tail.next = head;
        } else if (index == size - 1) {
            ret = tail.data;
            node = tail.pre;
            tail.pre = null;
            node.next = tail.next;
            tail.next = null;
            head.pre = tail;
        } else {
            Node p, q, r;
            if (index <= size / 2) {
                p = head;
                for (int i = 0; i < index - 1; i++) {
                    p = p.next;
                }
                q = p.next;
                ret = q.data;
                r = q.next;
                p.next = r;
                r.pre = q;
                q.next = null;
                q.pre = null;
            } else {
                p = tail;
                for (int i = size; i > index + 1; i--) {
                    p = p.pre;
                }
                q = p.pre;
                ret = q.data;
                r = q.pre;
                r.next = p;
                p.pre = r;
                q.next = null;
                q.pre = null;
            }
        }

        return ret;
    }


    //定义节点
    class Node {
        E data;
        Node pre;
        Node next;

        public Node() {
            this(null, null, null);
        }

        public Node(E e) {
            this(e, null, null);
        }

        public Node(E e, Node pre, Node next) {
            this.data = e;
            this.pre = pre;
            this.next = next;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }

}
