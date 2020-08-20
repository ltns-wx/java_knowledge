package cm.ltns.structure.linear_线性结构.linearlist_线性表.ArrayLinearList_链式实现方式;

/**
 * 双向链表：使用真实节点
 */
public class DoubleLinkList<E> {

    // 头结点
    private Node head;
    //为节点
    private Node tail;
    // 长度
    private int size;

    /**
     * 头结点不存储值 并且头结点初始化时 就一个头结点。
     * 所以头结点的前后节点都是自己
     * 并且这个链表的长度为0；
     */
    public DoubleLinkList() {
        head = null;
        tail = null;
        size = 0;
    }

    // 指定位置增加（index=0 值增加第一个位置）
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            System.out.println("下标索引越界");
        }
        Node node = new Node(e);
        // 如果队列为null
        if (size == 0) {
            head = node;
            tail = node;
        } else if (index == 0) { // 插入链表头部
            node.next = head;
            head.pre = node;
            head = node;
        } else if (size == index) {  //插入链表尾部
            tail.next = node;
            node.pre = tail;
            tail = node;
        } else {
            Node curNode = head;
            int cur = 0;
            while (cur < index - 1) {
                curNode = curNode.next;
                cur++;
            }
            node.next=curNode.next;
            curNode.next.pre=node;
            curNode.next=node;
            node.pre=curNode;
        }
        size++;
    }


    public int getSize() {
        return this.size;
    }

    /**
     * 判断链表的长度是否为空
     */
    public boolean isEmplty() {
        return size == 0;
    }

    /**
     * 判断索引是否超出范围
     */
    public void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return;
    }

    /**
     * 通过索引获取链表当中的节点
     */
    public Node getNode(int index) {
        /**
         * 检查该索引是否超出范围
         */
        checkIndex(index);
        /**
         * 当索引的值小于该链表长度的一半时，那么从链表的头结点开始向后找是最快的
         */
        Node cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur;
    }

    /**
     * 获取节点当中的值
     */
    public E getValue(Node cur) {
        return cur.getE();
    }

    /**
     * 获取第一个节点的值
     */
    public E getFirst() {
        return getValue(getNode(0));
    }

    /**
     * 获取最后一个节点的值
     */
    public E getLast() {
        return getValue(getNode(size - 1));
    }

    /**
     * 向表头插入数据
     */
    public void insertTo(E Value) {
        add(0, Value);
    }

    /**
     * 将元素插入到链表的尾部
     */
    public void insertTotatil(E vlaue) {
        Node cur = new Node(vlaue, head.next, head);
        //head.next 代表原来的尾部节点
        //遵循两个原则 一 新插入节点的前一个节点的后一个节点为新节点。新节点的后一个节点的前一个节点是新节点
        head.next.pre = cur;
        head.next = cur;
        size++;
    }

    /**
     * 删除节点的方法
     */
    public void remove(int index) {
        checkIndex(index);
        Node cur = getNode(index);
        System.out.println("将要删除的节点" + cur.getE());
        if (0 == index){  // 删除头结点
            head = head.next;
            head.pre=null;
            size--;
        }else if (index == size-1){ // 删除尾结点
            tail.pre.next=null;
            tail = tail.pre;
            size--;
        }else {
            //记住此时的指针还没断开 赋值以后才相当于断开
            cur.pre.next = cur.next;
            cur.next.pre = cur.pre;
            cur.pre=null;
            cur.next=null;
            size--;
            cur = null;
        }

    }

    /**
     * 删除第一个节点
     */
    public void delFirst() {
        remove(0);
    }

    /**
     * 删除最后一个节点
     */
    public void delLast() {
        remove(size - 1);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DoubleLinkList:size=" + size + "--->{");
        Node cur = head;
        while (true) {
            sb.append(cur.getE());
            if (cur.next == null) {
                sb.append('}');
                break;
            } else {
                sb.append(',');
            }
            cur = cur.next;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        DoubleLinkList<String> doubleLinkList = new DoubleLinkList<>();
        doubleLinkList.add(0, "a");
        doubleLinkList.add(0, "b");
        doubleLinkList.add(2, "c");
        doubleLinkList.add(2, "d");
        System.out.println(doubleLinkList.toString());

        DoubleLinkList.Node node = (DoubleLinkList.Node) doubleLinkList.getNode(3);
        System.out.println(node.getE());

        // 删除
        doubleLinkList.remove(2);
        System.out.println(doubleLinkList);

    }


    // 节点定义
    class Node {
        E e;
        Node pre;
        Node next;

        public Node() {
            this(null, null, null);
        }

        public Node(E e) {
            this(e, null, null);
        }

        public Node(E e, Node pre, Node next) {
            this.e = e;
            this.pre = pre;
            this.next = next;
        }

        public E getE() {
            return e;
        }

        public void setE(E e) {
            this.e = e;
        }

        public Node getPre() {
            return pre;
        }

        public void setPre(Node pre) {
            this.pre = pre;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
