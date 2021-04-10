package DataStructurs;

public class DoubleLinkedList {
    public static void main(String[] args) throws Exception {
        DoubleLinkedList myList = new DoubleLinkedList();
        myList.insertHead(1);
        myList.insertHead(2);
        myList.insertHead(3);
        myList.insertTail(10);
        myList.insertByPosition(100, 2);
        myList.deleteHead();
        myList.deleteTail();
        myList.insertTail(10);
        myList.print(myList.tail);
    }

    private DoubleNode head;
    private DoubleNode tail;
    private int size;

    DoubleLinkedList() {
        this.head = null;
        this.tail = null;
        size = 0;
    }

    public void insertHead(int value) {
        insertByPosition(value, 0);
    }

    public void insertTail(int value) {
        insertByPosition(value, size);
    }

    public void insertByPosition(int value, int position) {
        if(isEmpty()) {
            head = new DoubleNode(value, null, null);
            tail = head;
            size++;
            return;
        } else if(position == 0) {
            DoubleNode newHead = new DoubleNode(value, head, null);
            head.next = newHead;
            head = newHead;
            size++;
            return;
        } else if(position == size) {
            DoubleNode newTail = new DoubleNode(value, null, tail);
            tail.prev = newTail;
            tail = newTail;
            size++;
            return;
        }
        DoubleNode currentNode = head;
        for (int i = 0; i < position; ++i) {
            currentNode = currentNode.prev;
        }
        DoubleNode newNode = new DoubleNode(value, currentNode, currentNode.next);
        currentNode.next.prev = newNode;
        currentNode.next = newNode;
        size++;
    }

    public void deleteHead() {
        DoubleNode destroyNode = head;
        head.prev.next = null;
        head = head.prev;
        destroyNode = null;
        size--;
    }

    public void deleteTail() {
        DoubleNode destroyNode = tail;
        tail.next.prev = null;
        tail = tail.next;
        destroyNode = null;
        size--;
    }

    public void print(DoubleNode node) {
        System.out.println(node.value);
        if(node.next == null) {
            return;
        }
        print(node.next);
    }

    public int getSize() {
        return size;
    }

    public DoubleNode head() {
        return head;
    }

    public DoubleNode tail() {
        return tail;
    }

    private boolean isEmpty() {
        return head == null;
    }
}

class DoubleNode {
    public int value;
    public DoubleNode prev;
    public DoubleNode next;

    DoubleNode(int value, DoubleNode prev, DoubleNode next) {
        this.value = value;
        this.prev = prev;
        this.next = next;
    }
}

