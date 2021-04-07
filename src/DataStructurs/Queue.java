package DataStructurs;

public class Queue {

    public static void main(String[] args) throws Exception {
        Queue myQueue = new Queue(4);
        myQueue.enqueue(1);
        myQueue.enqueue(2);
        myQueue.enqueue(3);
        myQueue.enqueue(4);
        myQueue.dequeue();
        myQueue.dequeue();
        myQueue.dequeue();
        System.out.println(myQueue.dequeue());
        myQueue.enqueue(5);
        System.out.println(myQueue.dequeue());
    }

    private int head;
    private int tail;
    private final int size;
    private final int[] elements;

    public Queue(int size) {
        this.size = size;
        this.elements = new int[size];
        this.head = 0;
        this.tail = -1;
    }

    public void enqueue(int el) throws Exception {
        if(isFull()) throw new Exception("Queue Overflow");

        tail = (tail + 1) % size;
        elements[tail] = el;
    }

    public int dequeue() throws Exception {
        if(isEmpty()) throw new Exception("Queue is empty");

        int el = elements[head];
        head = (head + 1) % size;

        return el;
    }

    private boolean isEmpty() {
        return head == tail + 1;
    }

    private boolean isFull() {
        return head + tail >= size;
    }
}
