package DataStructurs.Trees;

public class BinaryTree {
    private class Node {
        public int  value;
        public Node left;
        public Node right;
        public Node parent;

        public Node(int value) {
            this.value  = value;
            this.left   = null;
            this.right  = null;
            this.parent = null;
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.insert(890);
        tree.insert(1);
        tree.insert(4);
        tree.insert(3);
        tree.insert(20);
        tree.insert(8);
        tree.insert(12);
        tree.printInOrder(tree.getRoot());
        tree.printPreOrder(tree.getRoot());
        tree.printPostOrder(tree.getRoot());
    }

    private Node root;

    public BinaryTree() {
        root = null;
    }

    public Node find(int key) {
        Node current = root;
        while (current != null) {
            if(key < current.value) {
                if(current.left == null) return current;
                current = current.left;
            } else if (key > current.value) {
                if (current.right == null) return current;
                current = current.right;
            } else {
                return current;
            }
        }
        return null;
    }

    public void insert(int value) {
        Node newNode = new Node(value);
        if(root == null) {
            root = newNode;
        } else {
            Node parent = find(value);
            if(value < parent.value) {
                parent.left = newNode;
                parent.left.parent = parent;
            } else {
                parent.right = newNode;
                parent.right.parent = newNode;
            }
        }
    }

    public Node getRoot() {
        return root;
    }

    public void printInOrder(Node localRoot) {
        if(localRoot != null) {
            printInOrder(localRoot.left);
            System.out.println(localRoot.value + " ");
            printInOrder(localRoot.right);
        }
    }

    public void printPreOrder(Node localRoot) {
        if (localRoot != null) {
            System.out.println(localRoot.value + " ");
            printPreOrder(localRoot.left);
            printPreOrder(localRoot.right);
        }
    }

    public void printPostOrder(Node localRoot) {
        if(localRoot != null) {
            printPostOrder(localRoot.left);
            printPostOrder(localRoot.right);
            System.out.println(localRoot.value + " ");
        }
    }
}
