package String;

public class RemoveOutmostParenthesis {
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder("");
        int n = s.length();
        int depth = 0;

        for(int i = 0; i < n; ++i) {
            char ch = s.charAt(i);
            if (ch == '(') {
                if (depth > 0) {
                    sb.append(ch);
                }

                ++depth;
            } else {
                --depth;
                if (depth > 0) {
                    sb.append(ch);
                }
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "(()())(())(()(()))";
        RemoveOutmostParenthesis obj = new RemoveOutmostParenthesis();
        String res = obj.removeOuterParentheses(str);
        System.out.println(res);
    }
}
