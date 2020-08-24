package cm.ltns.structure.map_映射.TreeMap_二分搜索树实现;

import java.util.Comparator;

public class TreeMap<K extends Comparable<K>, V> {

    private Node root;
    public int size;

    public TreeMap() {
        root = null;
        size = 0;
    }

    // 以node为根的二分搜索树中查询key的那个节点对象
    private Node getNode(Node node, K key) {
        if (node == null) {
            return null;
        }
        if (key.compareTo(node.key) < 0) {
            return getNode(node.leftChild, key);
        } else if (key.compareTo(node.key) > 0) {
            return getNode(node.rightChild, key);
        } else {
            return node;
        }
    }

    public void put(K key, V value) {
        root = put(root, key, value);
    }

    //在以node为根节点的BSt中插入键值对
    private Node put(Node node, K key, V value) {
        if (node == null) {
            size++;
            return new Node(key, value);
        }
        if (key.compareTo(node.key) < 0) {
            node.leftChild = put(node.leftChild, key, value);
        } else if (key.compareTo(node.key) > 0) {
            node.rightChild = put(node.rightChild, key, value);
        } else { // 如果key相等，那么就修改
            node.value = value;
        }
        return node;
    }

    // 节点
    class Node {
        K key;
        V value;
        private Node leftChild;
        private Node rightChild;

        public Node() {
            this.key = null;
            this.value = null;
            this.leftChild = null;
            this.rightChild = null;
        }

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.leftChild = null;
            this.rightChild = null;
        }
    }
}
