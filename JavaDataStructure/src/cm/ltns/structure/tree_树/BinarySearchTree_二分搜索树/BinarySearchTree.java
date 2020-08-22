package cm.ltns.structure.tree_树.BinarySearchTree_二分搜索树;

public class BinarySearchTree<E extends Comparable<E>> {

    private Node root;
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

    // 包含
    public boolean contains(E data) {
        return contains(root, data);
    }

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

    public static void main(String[] args) {
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
        binarySearchTree.add(4);
        binarySearchTree.add(3);
        binarySearchTree.add(5);
        binarySearchTree.add(1);
        binarySearchTree.add(2);
        binarySearchTree.add(6);
        System.out.println(binarySearchTree);
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
    }

}
