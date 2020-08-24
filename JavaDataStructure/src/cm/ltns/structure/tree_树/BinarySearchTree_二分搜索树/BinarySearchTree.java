package cm.ltns.structure.tree_树.BinarySearchTree_二分搜索树;

import cm.ltns.structure.tree_树.BinaryTree_二叉树.BinaryTree;

/**
 * 二分搜索树
 */
public class BinarySearchTree<E extends Comparable<E>> {

    Node root;
    private int size;

    public BinarySearchTree() {
        root = null;
        size = 1;
    }

    public boolean isEmpty() {
        return root == null || size == 0;
    }

    // 添加元素
    public void add(E data) {
        root = add(root, data);
    }

    public Node add(Node node, E data) {
        if (node == null) {
            size++;
            return new Node(data);
        }
        if (data.compareTo(node.getDate()) < 0) {   // data 小 放在左边
            node.leftChild = add(node.getLeftChild(), data);
        } else if (data.compareTo(node.getDate()) > 0) {
            node.rightChild = add(node.rightChild, data);
        }

        return node;

    }

    // 前序遍历DLR
    public void orderDLR(Node node) {  //node为根节点
        if (node == null) {
            return;
        }
        System.out.println(node.date);
        orderDLR(node.leftChild);
        orderDLR(node.rightChild);
    }
    // 层序遍历

    // 删除最小节点
    public E removeMin() {
        E e = minNum();
        root = removeMin(root);
        return e;
    }

    // 删除指定元素
    private Node remove(Node node, E e) {
        if (node == null) {
            return null;
        }
        if (e.compareTo(node.date) < 0) {
            node.leftChild = remove(node, e);
            return node;
        } else if (e.compareTo(node.date) > 0) {
            node.rightChild = remove(node, e);
            return node;
        } else {
            // 如果左子树
            if (node.leftChild == null) {
                Node rightNode = node.rightChild;
                node.rightChild = null;
                size--;
                return rightNode;
            }
            // 如果又子树为null
            if (node.rightChild == null) {
                Node leftNode = node.leftChild;
                node.leftChild = null;
                size--;
                return leftNode;
            }
            // 要么是左子树的最大值来顶替， 要么是右子树的最小值来顶替

            // 查找右子树的最小值
            Node minNode = minNum(node);
            minNode.rightChild = removeMin(node.rightChild);
            minNode.leftChild = node.leftChild;
            node.leftChild = null;
            node.rightChild = null;
            node.date = null;
            return minNode;
        }
    }

    // 已node为节点的二分搜索树中删除最小值，并返回新书的跟
    private Node removeMin(Node node) {
        if (node.leftChild == null) {
            Node rightNode = node.rightChild;
            node.leftChild = null;
            size--;
            return rightNode;
        }
        node.leftChild = removeMin(node.leftChild);
        return node;
    }

    // 获取最小值
    public E minNum() {
        Node minnum = minNum(root);
        return minnum.date;
    }


    private Node minNum(Node node) {
        if (node.leftChild == null) {
            return node;
        }
        return minNum(node.leftChild);
    }

    // 包含
    public boolean contains(E data) {
        return contains(root, data);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        inOrderByString(root, sb);
        return sb.toString();
    }

    private void inOrderByString(Node node, StringBuilder stringBuilder) {
        if (node == null) {
            return;
        }
        inOrderByString(node.leftChild, stringBuilder);
        stringBuilder.append(node.date);
        inOrderByString(node.rightChild, stringBuilder);
    }

    // 是否包含
    private boolean contains(Node node, E data) {
        if (node == null) {
            return false;
        }
        if (data.compareTo(node.date) == 0) {
            return true;
        }
        if (data.compareTo(node.date) > 0) {
            return contains(node.leftChild, data);
        } else {
            return contains(node.rightChild, data);
        }
    }


    // 结点
    class Node {
        E date;
        Node leftChild;
        Node rightChild;

        public Node() {
            this(null, null, null);
        }

        public Node(E date) {
            this(date, null, null);
        }

        public Node(E date, Node leftChild, Node rightChild) {
            this.date = date;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }

        public E getDate() {
            return date;
        }

        public void setDate(E date) {
            this.date = date;
        }

        public Node getLeftChild() {
            return leftChild;
        }

        public void setLeftChild(Node leftChild) {
            this.leftChild = leftChild;
        }

        public Node getRightChild() {
            return rightChild;
        }

        public void setRightChild(Node rightChild) {
            this.rightChild = rightChild;
        }

        @Override
        protected void finalize() throws Throwable {
            System.out.println(this.date + "被收回");
            super.finalize();
        }
    }

}
