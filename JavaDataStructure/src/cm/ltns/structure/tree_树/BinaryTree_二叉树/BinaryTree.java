package cm.ltns.structure.tree_树.BinaryTree_二叉树;

/**
 * 二叉树
 * 一、二叉树的前序（DLP）、中序(LDR)、后续遍历(LRD)
 * 深度查询
 *  前序遍历
 *      1.先输出当前节点（root）
 *      2.如果左节点不为空，则继续递归遍历前序遍历
 *      3.如果有节点不为空，则递归继继续前序遍历
 *  中序遍历
 *      1.如果当前节点的左节点不为空，则递归中序遍历
 *      2.输出当前节点
 *      3.如果当前节点的右节点不为空，则递归中序遍历
 *  后续遍历
 *      1.如果当前节点的左子节点不为空，则递归后续遍历
 *      2.如果当前节点的右子节点不为空，则递归后续遍历
 *      3.输出当前节点
 *
 * 广度优先遍历：从左到右，使用队列实现
 *      1.先把根节点放到队列中
 *      2.根据出一个节点，再把其对应的左右子节点放进队列中
 *
 */
public class BinaryTree<E> {

    // 根节点
    private Node root;
    private int length;

    public BinaryTree() {
        root = null;
        length = 0;
    }

    // 设置头结点
    public BinaryTree(E date) {
        root = new Node(date);
    }

    // 左子结点插入
    public void insertLeft(E data, Node parent) {
        if (parent == null) {
            System.out.println("父结点为空");
        }
        Node p = new Node(data);
        if (parent.left == null) {
            parent.left = p;
        } else {
            //
            Node pLest = parent.left;
            parent.left = p;
            p.left = pLest;
        }
    }

    //设置某个结点的右结点
    public void insertRight(E data, Node parent) {
        if (parent == null) {
            System.out.println("父结点为空");
        }
        Node p = new Node(data);
        if (parent.right == null) {
            parent.right = p;
        } else {
            //
            Node pLest = parent.right;
            parent.right = p;
            p.right = pLest;
        }
    }

    // 删除二叉树的左子数
    public void deleteLeft(Node parent){
        if (parent == null){
            System.out.println("该结点为空");
        }else {
            parent.left = null;  // 这样不会导致空间浪费吗？
        }

    }



    // 前序遍历DLR
    public void orderDLR(Node node) {  //node为根节点
        if (node == null) {
            System.out.println("该二叉树为null");
        }
        System.out.println(node.data);
        orderDLR(node.left);
        orderDLR(node.right);
    }

    //中序遍历LDR
    public void orderLDR(Node node) {

        orderDLR(node.left);
        System.out.println(node.data);
        orderDLR(node.right);
    }

    //后续遍历LDR
    public void orderLRD(Node node) {
        orderDLR(node.left);
        orderDLR(node.right);
        System.out.println(node.data);
    }

    //后续遍历LRD
    class Node {
        private E data;
        private Node left;
        private Node right;

        public Node() {
            this(null, null, null);
        }

        public Node(E e) {
            this(e, null, null);
        }

        public Node(E e, Node left, Node right) {
            this.data = e;
            this.left = left;
            this.right = right;
        }

        // 在节点内部进行遍历
        public void orderDLR() {
            System.out.println(this.data); // 当前节点
            if (this.left != null) {
                this.left.orderDLR(); // 左节点不为null，打印左节点
            }
            if (this.right != null) {
                this.right.orderDLR(); // 左节点不为null，打印左节点
            }
        }

        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(data);
            if (left != null) {
                stringBuilder.append("--->left=" + left.data);
            }
            if (right != null) {
                stringBuilder.append("--->right=" + right.data);
            }
            return stringBuilder.toString();
        }
    }


}
