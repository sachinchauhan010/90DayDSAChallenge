package StackQueue;

import java.util.Stack;

public class InfixToPrefix {

    public String reverseString(String s) {
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }

    public int checkPriority(char ch) {
        if (ch == '^') return 3;
        else if (ch == '/' || ch == '*') return 2;
        else if (ch == '+' || ch == '-') return 1;
        else return -1;
    }

    public String getPrefix(String str) {
        StringBuilder reversed = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            char ch = str.charAt(i);
            if (ch == '(') reversed.append(')');
            else if (ch == ')') reversed.append('(');
            else reversed.append(ch);
        }

        String revStr = reversed.toString();
        Stack<Character> stk = new Stack<>();
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < revStr.length(); i++) {
            char ch = revStr.charAt(i);

            if (Character.isLetterOrDigit(ch)) {
                ans.append(ch);
            } else if (ch == '(') {
                stk.push(ch);
            } else if (ch == ')') {
                while (!stk.isEmpty() && stk.peek() != '(') {
                    ans.append(stk.pop());
                }
                if (!stk.isEmpty() && stk.peek() == '(') stk.pop();
            } else {
                if (ch == '^') {
                    while (!stk.isEmpty() && checkPriority(ch) < checkPriority(stk.peek())) {
                        ans.append(stk.pop());
                    }
                } else {
                    while (!stk.isEmpty() && checkPriority(ch) <= checkPriority(stk.peek())) {
                        ans.append(stk.pop());
                    }
                }
                stk.push(ch);
            }
        }

        while (!stk.isEmpty()) ans.append(stk.pop());
        return reverseString(ans.toString());
    }

    public static void main(String[] args) {
        InfixToPrefix obj = new InfixToPrefix();

        String infix1 = "(A-B/C)*(A/K-L)";
        String infix2 = "A+B*(C^D-E)";

        System.out.println("Infix : " + infix1);
        System.out.println("Prefix: " + obj.getPrefix(infix1));

        System.out.println("Infix : " + infix2);
        System.out.println("Prefix: " + obj.getPrefix(infix2));
    }
}
