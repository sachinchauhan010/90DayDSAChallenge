package StackQueue;

import java.util.Stack;

public class ImplQueueUsingStack {

        private Stack<Integer> input;
        private Stack<Integer> output;

        public ImplQueueUsingStack() {
            input= new Stack<>();
            output= new Stack<>();
        }

        public void push(int x) {
            while(!input.isEmpty()){
                output.push(input.pop());
            }
            input.push(x);
            while(!output.isEmpty()){
                input.push(output.pop());
            }
        }

        public int pop() {
            return input.pop();
        }

        public int peek() {
            return input.peek();
        }

        public boolean empty() {
            return input.isEmpty();
        }

    public static void main(String[] args) {
        ImpStackUsingQueue queue= new ImpStackUsingQueue();
        queue.push(3);
        queue.push(12);
        queue.push(11);
        queue.top();
        queue.pop();
    }
}
