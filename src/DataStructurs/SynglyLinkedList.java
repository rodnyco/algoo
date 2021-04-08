package DataStructurs;

public class SynglyLinkedList {
    public static void main(String[] args) throws Exception {
        SynglyLinkedList list = new SynglyLinkedList();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.delete(2);
        System.out.println(list.toString());
    }

    private Node head;
    private int size;

    SynglyLinkedList() {
        this.head = null;
        this.size = 0;
    }

    public void insert(int value) {
        if(isEmpty()) {
            head = new Node(value);
            size++;
            return;
        }
        head = new Node(value, head);
        size++;
    }

    public void delete(int position) {
        if(position == 0) {
            Node destroy = head;
            head = head.next;
            destroy = null;
            size--;
            return;
        }
        Node currentNode = head;
        for (int i = 0; i < position - 1; ++i) {
            currentNode = currentNode.next;
        }

        Node destroy = currentNode.next;
        currentNode.next = currentNode.next.next;
        destroy = null;

        size--;
    }

    public String toString() {
        StringBuilder list = new StringBuilder();
        Node currentNode = head;
        while (currentNode != null) {
            String delimiter = "->";
            if(currentNode.next == null) {
                delimiter = "";
            }
            list.append(String.valueOf(currentNode.value)).append(delimiter);
            currentNode = currentNode.next;
        }
        return list.toString();
    }

    public int count() {
        int count = 0;
        Node currentNode = head;
        while(currentNode != null) {
            currentNode = currentNode.next;
            count++;
        }
        return count;
    }

    public boolean search(int key) {
        Node node = head;
        while (node != null) {
            if(node.value == key) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

    public Node head() {
        return head;
    }

    private boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
}

/* contain value and link to the next node*/
class Node {
    public int value;
    public Node next;

    Node(int value) {
        this.value = value;
        this.next = null;
    }

    Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }
}
