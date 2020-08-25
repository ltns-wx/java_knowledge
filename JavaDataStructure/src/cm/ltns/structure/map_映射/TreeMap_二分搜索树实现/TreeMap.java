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

    // 删除指定节点
    public V remove(K key) {
        // 获取将要删除的节点
        Node delNode = getNode(root, key);
        if (delNode != null) {
            remove(root, key);
        }
        return null;
    }

    private Node remove(Node node, K key) {
        if (key.compareTo(node.key) < 0) {
            node.leftChild = remove(node.leftChild, key);
            return node;
        } else if (key.compareTo(node.key) > 0) {
            node.rightChild = remove(node.rightChild, key);
            return node;
        } else {  // 找到要删除的节点
            if (node.leftChild == null) {
                Node right = node.rightChild;
                node.rightChild = null;
                size--;
                return right;
            }
            if (node.rightChild == null) {
                Node left = node.leftChild;
                node.leftChild = null;
                size--;
                return node;
            }

            // 都不为空；
            Node successor = minnum(root.rightChild);
            successor.rightChild = removeMin(node.rightChild);
            successor.leftChild = node.leftChild;
            node.leftChild = node.rightChild = null;
            return successor;
        }
    }

    // 查找最小值
    public Node minnum(Node node) {
        if (node.leftChild == null) {
            return node;
        }
        return minnum(node.leftChild);
    }

    // 删除最小值
    private Node removeMin(Node node) {
        if (node.leftChild == null) {
            Node right = node.rightChild;
            node.rightChild = null;
            size--;
            return right;
        }
        node.leftChild = removeMin(node.leftChild);
        return node;
    }

    // 查询节点
    public V get(K key) {
        Node n = getNode(root, key);
        return n == null ? null : n.value;
    }

    public boolean contains(K key) {
        return getNode(root, key) != null;
    }

    public void set(K key, V value){
        Node n = getNode(root,key);
        if (n == null){
            System.out.println("key值不存在");
        }
        n.value = value;
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

    public static void main(String[] args) {
        String s = "aa";
        String s1 = "aa";
        int i = s.hashCode();
        System.out.println(i);
        System.out.println(s1.hashCode());
    }
}
