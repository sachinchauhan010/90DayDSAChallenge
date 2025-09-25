package StackQueue;

import java.util.Stack;

public class ImpMinStack {

    private Stack<int[]> stk;

    public ImpMinStack() {
        stk = new Stack<int[]>();
    }

    public void push(int val) {
        if (stk.isEmpty()) {
            stk.push(new int[]{val, val});
        } else {
            int currentMin = stk.peek()[1];
            stk.push(new int[]{val, Math.min(currentMin, val)});
        }
    }

    public void pop() {
        if (!stk.isEmpty()) {
            stk.pop();
        }
    }

    public int top() {
        return stk.peek()[0];
    }

    public int getMin() {
        return stk.peek()[1];
    }

    public static void main(String[] args) {
        ImpMinStack minStack = new ImpMinStack();

        minStack.push(5);
        minStack.push(3);
        minStack.push(7);

        System.out.println("Top: " + minStack.top());        // 7
        System.out.println("Min: " + minStack.getMin());     // 3
        minStack.pop();
        System.out.println("Top: " + minStack.top());        // 3
        System.out.println("Min: " + minStack.getMin());     // 3
        minStack.pop();
        System.out.println("Min: " + minStack.getMin());     // 5
    }
}
