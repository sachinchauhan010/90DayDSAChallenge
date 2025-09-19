package String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortCharByFreq {
    public String frequencySort(String s) {
        HashMap<Character, Integer> freqMap= new HashMap<>();

        //Get the Frequency of each character
        for(char ch: s.toCharArray()){
            freqMap.put(ch, freqMap.getOrDefault(ch, 0)+1);
        }

        //Convert the frequency Map to List
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(freqMap.entrySet());

        //Sort the list based on freq
        list.sort((a,b)->b.getValue() - a.getValue());

        //arrange the string
        StringBuilder sb= new StringBuilder("");
        for (Map.Entry<Character, Integer> entry : list) {
            for(int i=0; i<entry.getValue(); i++){
                sb.append(entry.getKey());
            }
        }
        return sb.toString();

    }
    public static void main(String[] args) {
        String str="tree";
        SortCharByFreq obj = new SortCharByFreq();
        System.out.println(obj.frequencySort(str));
    }

    public static class RemoveOutmostParenthesis {
        public String removeOuterParentheses(String s) {
            StringBuilder sb = new StringBuilder("");
            int n = s.length();
            int depth=0;

            for (int i = 0; i < n; i++) {
                char ch = s.charAt(i);
                if (ch == '(') {
                    if (depth>0) sb.append(ch);
                    depth++;
                } else {
                    depth--;
                    if (depth>0) {
                        sb.append(ch);
                    }
                }
            }

            return sb.toString();

        }
        public static void main(String[] args) {
            String str= "(()())(())(()(()))";
            RemoveOutmostParenthesis obj= new RemoveOutmostParenthesis();
            String res=obj.removeOuterParentheses(str);
            System.out.println(res);
        }
    }
}
