package String;

public class ReverseWordsInString {
    public String reverseWords(String s) {

        //Step1 : clear all the extra leading or trailinmg spaces and space more than one in string
        String cleanedStr=s.trim().replaceAll("\\s+", " ");
        int n=cleanedStr.length();

        //Step 2: Split the words
        String[] words= cleanedStr.split(" ");

        //Step 3:Reverse the words
        StringBuilder sb= new StringBuilder();
        for(int i=words.length-1; i>=0; i--){
            sb.append(words[i]);
            if(i!=0) sb.append(" ");
        }

        return sb.toString();


    }
    public static void main(String[] args) {
        String str="  the sky is blue   ";
        ReverseWordsInString obj= new ReverseWordsInString();

        System.out.println(obj.reverseWords(str));
    }
}
