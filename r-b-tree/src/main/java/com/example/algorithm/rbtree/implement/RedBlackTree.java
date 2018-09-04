package com.example.algorithm.rbtree.implement;

/**
 * FileName: RedBlackTree
 * Author:   SunEee
 * Date:     2018/9/3 14:09
 * Description: 红黑树
 */
public class RedBlackTree {
    private Boolean RED = true;

    private Boolean BLACK = false;

    private Node root;

    /**
     * 一个节点
     */
    public class Node {

        private Node left;

        private Node right;

        private Node parent;

        private Integer treeKey;

        private String treeValue;

        private boolean color;

        public Node(Integer treeKey, String treeValue) {
            this.treeKey = treeKey;
            this.treeValue = treeValue;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public Node getParent() {
            return parent;
        }

        public void setParent(Node parent) {
            this.parent = parent;
        }

        public Integer getTreeKey() {
            return treeKey;
        }

        public void setTreeKey(Integer treeKey) {
            this.treeKey = treeKey;
        }

        public String getTreeValue() {
            return treeValue;
        }

        public void setTreeValue(String treeValue) {
            this.treeValue = treeValue;
        }

        public boolean isColor() {
            return color;
        }

        public void setColor(boolean color) {
            this.color = color;
        }
    }

    public void put(Integer treeKey, String treeValue) {
        root = putValue(root(), treeKey, treeValue);
    }

    private Node putValue(Node node, Integer treeKey, String treeValue) {
        while (true) {
            if (null == node) {
                Node newNode = new Node(treeKey, treeValue);
                newNode.setColor(BLACK);
                node =  newNode;
                break;
            }
            Integer nodeTreeKey = node.getTreeKey();
            if (null == nodeTreeKey) {
                break;
            }
            int i = treeKey.compareTo(nodeTreeKey);
            if (i == 0) {
                node.setTreeValue(treeValue);
            }
            if (i > 0) {
                if (node.right == null) {
                    Node newNode = new Node(treeKey, treeValue);
                    newNode.setColor(RED);
                    newNode.setParent(node);
                    node.right = newNode;
                    break;
                } else {
                    node = node.right;
                }


            } else if (i < 0) {
                if (node.left == null) {
                    Node newNode = new Node(treeKey, treeValue);
                    newNode.setColor(RED);
                    newNode.setParent(node);
                    node.left = newNode;
                    break;
                } else {
                    node = node.left;
                }
            }
        }

        while (true) {
            //平衡化操作
            if (isRed(node.right) && !isRed(node.left)) { //右边红，左边不红
                node = rotateLeft(node);
            }
            if (node.left != null && node.left.left != null && !isRed(node.left) && isRed(node.left.left)) {
                node = rotateRight(node);
            }
            if (isRed(node.left) && isRed(node.right)) {
                flipColor(node);
            }
            if (node.parent == null) {
                return node;
            }
            node = node.parent;
        }
    }

    /**
     * 左旋
     *
     * @param node 节点
     */
    private Node rotateLeft(Node node) {
        Node parent = node.getParent();
        Node right = node.getRight();
        Node right_left = right.getLeft();

        right.setParent(parent);
        right.setLeft(node);
        right.setColor(node.color);

        node.setParent(right);
        node.setRight(right_left);
        node.setColor(RED);

        if (null == parent) {
            return right;
        }
        int i = parent.getTreeKey().compareTo(node.treeKey);
        if (i > 0) {
            parent.left = right;
        } else {
            parent.right = right;
        }

        return right;
    }

    /**
     * 右旋
     *
     * @param node 节点
     * @return
     */
    private Node rotateRight(Node node) {
        Node parent = node.parent;
        Node left = node.left;
        Node left_right = left.right;

        left.parent = parent;
        left.right = node;
        left.color = node.color;

        node.parent = left;
        node.left = left_right;
        node.color = RED;

        if (null == parent) {
            return node;
        }
        int i = parent.getTreeKey().compareTo(node.treeKey);
        if (i > 0) {
            parent.left = left;
        } else {
            parent.right = left;
        }

        return left;
    }


    /**
     * 转换颜色
     *
     * @param node 节点
     */
    public void flipColor(Node node) {
        node.right.color = BLACK;
        node.left.color = BLACK;
        node.color = RED;
        if (node.treeKey.equals(getRoot().treeKey)) {
            node.color = BLACK;
        }
    }

    private boolean isRed(Node node) {
        return null != node && node.color;
    }

    /**
     * 获取值
     *
     * @param treeKey 值
     * @return 值
     */
    public String get(Integer treeKey) {
        return getValue(root(), treeKey);
    }

    /**
     * 获取根节点
     *
     * @return 根节点
     */
    private Node root() {
        if (this.root == null) {
            return null;
        }
        for (Node r = root, p; ; ) {
            if ((p = r.parent) == null) {
                return r;
            }
            r = p;
        }
    }

    /**
     * 获取值
     *
     * @param root    树
     * @param treeKey 值
     * @return 结果
     */
    private String getValue(Node root, Integer treeKey) {
        if (root == null) {
            return null;
        }
        Node next = root;
        for (; ; ) {
            int i = next.getTreeKey().compareTo(treeKey); //树的key与key比较
            if (i == 0) {
                return next.getTreeValue();//获取值
            }
            if (i > 0) {
                next = next.left;//比key大，找左边
            } else {
                next = next.right;//比key小，找右边
            }
            if (next == null) {
                return null;
            }
            System.out.println("获取值");
        }
    }


    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }
}
