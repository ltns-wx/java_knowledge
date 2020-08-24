package cm.ltns.structure.tree_树.BinarySearchTree_二分搜索树;

public class TestBinarySearchTree {

    public static void main(String[] args) {
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
        binarySearchTree.add(5);
        binarySearchTree.add(2);
        binarySearchTree.add(4);
        binarySearchTree.add(6);
        binarySearchTree.add(3);
        binarySearchTree.add(1);
        System.out.println(binarySearchTree);
        binarySearchTree.orderDLR(binarySearchTree.root);
        System.out.println("获取最小值" + binarySearchTree.minNum());
        binarySearchTree.removeMin();
        System.gc();
        System.out.println("获取最小值" + binarySearchTree.minNum());
    }
}
