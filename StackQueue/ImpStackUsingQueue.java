package StackQueue;

import java.util.LinkedList;
import java.util.Queue;

public class ImpStackUsingQueue {

    private Queue<Integer> q;

    public ImpStackUsingQueue() {
        q = new LinkedList<>();
    }

    public void push(int x) {
        q.add(x);
        // reverse the queue size-1
        for (int i = 0; i < q.size() - 1; i++) {
            q.add(q.poll());
        }
    }

    public int pop() {
        return q.poll();
    }

    public int top() {
        return q.peek();
    }

    public boolean empty() {
        return q.isEmpty();
    }

    public static void main(String[] args) {
        // Create an object of the stack
        ImpStackUsingQueue stack = new ImpStackUsingQueue();

        stack.push(2);
        stack.push(5);
        stack.push(10);

        System.out.println("Top element: " + stack.top()); // 10
        System.out.println("Pop element: " + stack.pop()); // 10
        System.out.println("Is stack empty? " + stack.empty()); // false
    }
}
