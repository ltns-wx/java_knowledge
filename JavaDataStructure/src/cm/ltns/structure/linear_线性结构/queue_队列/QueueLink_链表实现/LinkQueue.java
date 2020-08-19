package cm.ltns.structure.linear_线性结构.queue_队列.QueueLink_链表实现;

import cm.ltns.structure.linear_线性结构.linearlist_线性表.ArrayLinearList_链式实现方式.LinkList;

/**
 * 队列 先进先出
 * 队列：使用链表实现
 */
public class LinkQueue<T> {

    // 队首元素

    //队尾元素

    // 定义节点
    class Node<T> {
        T t;
        Node<T> next;

        public T getT() {
            return t;
        }

        public void setT(T t) {
            this.t = t;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }

}
