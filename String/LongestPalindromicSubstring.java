package String;

public class LongestPalindromicSubstring {
    public boolean checkPalindrome(String str){
        int n=str.length();
        for(int i=0; i<n/2; i++){
            if(str.charAt(i)!= str.charAt(n-i-1)){
                return false;
            }
        }
        return true;
    }
    public String longestPalindrome(String s) {
        int n=s.length();
        StringBuilder maxPalindromicSubstring=new StringBuilder("");

        //Step 1: get all the substring
        for(int i=0; i<n; i++){
            for(int j= i+1; j<n; j++){
                String sub=s.substring(i,j);
                if(checkPalindrome(sub)){
                    if(maxPalindromicSubstring.length()< sub.length()){
                        maxPalindromicSubstring= new StringBuilder(sub);
                    }
                }
            }
        }
        return maxPalindromicSubstring.toString();
    }

    public static void main(String[] args) {
        String str="cbbd";
        LongestPalindromicSubstring obj= new LongestPalindromicSubstring();

        System.out.println(obj.longestPalindrome(str));
    }
}
