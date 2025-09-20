package String;

public class MaxNestingDepthParenthesis {
    public int maxDepth(String s) {
        int n=s.length();
        int depth=0;
        int maxDepth=Integer.MIN_VALUE;

        for(char ch: s.toCharArray()){
            if(ch=='('){
                depth++;
            }
            if(ch==')'){
                maxDepth=Math.max(maxDepth,depth);
                depth--;
            }
        }
        return maxDepth;
    }
    public static void main(String[] args) {
        String str="(1)+((2))+(((3)))" ;
        MaxNestingDepthParenthesis obj =new MaxNestingDepthParenthesis();

        System.out.println(obj.maxDepth(str));
    }
}
