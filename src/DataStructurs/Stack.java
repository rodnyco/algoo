package DataStructurs;

public class Stack {
    public static void main(String[] args) throws Exception {
        Stack myStack = new Stack(4);
        myStack.push(1);
        myStack.push(10);
        myStack.push(20);
        myStack.push(30);
        System.out.println(myStack.top());
    }

    private final int size;
    private final int[] elements;
    private int top;

    public Stack(int length) {
        size = length;
        elements = new int[size];
        top = -1;
    }

    public void push(int el) throws Exception {
        if(isFull()) throw new Exception("Stack Overflow");
        top++;
        elements[top] = el;
    }

    public void pop() throws Exception {
        if(isEmpty()) throw new Exception("Stack is empty");
        top--;
    }

    public int top() throws Exception {
        if(isEmpty()) throw new Exception("Stack is empty");

        return elements[top];
    }

    private boolean isEmpty() {
        return top == -1;
    }

    private boolean isFull() {
        return top+1 == size;
    }
}
