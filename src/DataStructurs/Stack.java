package DataStructurs;

public class Stack {
    private int[] elements;
    private int top;

    public static void main(String[] args) throws Exception {
        Stack myStack = new Stack(4);
        myStack.push(1);
        System.out.println(myStack.getTop());
        myStack.push(10);
        myStack.push(20);
        myStack.pop();
        System.out.println(myStack.getTop());
    }

    public Stack(int length) {
        elements = new int[length];
        top = -1;
    }

    private boolean isEmpty() {
        return top == -1;
    }

    public void push(int el) {
        top++;
        elements[top] = el;
    }

    public void pop() throws Exception {
        if(isEmpty()) throw new Exception("Stack is empty :(");
        top--;
    }

    public int getTop() throws Exception {
        if(isEmpty()) throw new Exception("Stack is empty :(");

        return elements[top];
    }
}
