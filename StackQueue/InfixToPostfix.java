package StackQueue;

import java.util.Stack;

public class InfixToPostfix {

    public int checkPriority(char ch) {
        if (ch == '^') return 3;
        else if (ch == '/' || ch == '*') return 2;
        else if (ch == '+' || ch == '-') return 1;
        else return -1;
    }

    public String getPostfix(String str) {
        int n = str.length();
        Stack<Character> stk = new Stack<>();
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < n; i++) {
            char ch = str.charAt(i);

            // Operand (a-z, A-Z, 0-9)
            if ((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9')) {
                ans.append(ch);
            }
            // Opening parenthesis
            else if (ch == '(') {
                stk.push(ch);
            }
            // Closing parenthesis
            else if (ch == ')') {
                while (!stk.isEmpty() && stk.peek() != '(') {
                    ans.append(stk.pop());
                }
                if (!stk.isEmpty() && stk.peek() == '(') {
                    stk.pop(); // remove '('
                }
            }
            // Operator
            else {
                while (!stk.isEmpty() && checkPriority(ch) <= checkPriority(stk.peek())) {
                    ans.append(stk.pop());
                }
                stk.push(ch);
            }
        }

        // Pop remaining operators
        while (!stk.isEmpty()) {
            ans.append(stk.pop());
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        InfixToPostfix obj = new InfixToPostfix();
        String str = "a*(b+c)/d";
        System.out.println(obj.getPostfix(str)); // Expected: abc+*d/
    }
}
