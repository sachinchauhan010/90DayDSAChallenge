package String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SumOFBeautyOFSubstrings {
    public int beautySumBrouteApproach(String s) {
        int n=s.length();
        List<String> subStringList= new ArrayList<>();
        int count=0;

        // Step 1: get all the possible substrings
        for(int i=0; i<n; i++){
            for(int j=i+1; j<=n; j++){
                subStringList.add(s.substring(i,j));
            }
        }

        //Step 2: Get All the non-zero beauty substring;

        for(String str:subStringList){
            HashMap<Character, Integer> freq =new HashMap<>();
            // Freq Count
            for(char ch: str.toCharArray()){
                freq.put(ch, freq.getOrDefault(ch,0)+1);
            }

            int maxFreq=Integer.MIN_VALUE;
            int minFreq=Integer.MAX_VALUE;
            int maxChar=' ';
            int minChar=' ';
            //Get Most and Least Frequent Element
            for (Map.Entry<Character, Integer> entry : freq.entrySet()){
                int feq=entry.getValue();
                char ch= entry.getKey();

                if(feq>maxFreq){
                    maxFreq=feq;
                    maxChar=ch;
                }

                if(feq<minFreq){
                    minFreq=feq;
                    minChar=ch;
                }

            }

            int beauty=maxFreq-minFreq;
            if(beauty>0){
                count=count+beauty;
            }

        }
        return count;

    }

    public int beautySum(String str){
        int n=str.length();
        int count=0;

        for(int i=0; i<n; i++){
            int[] freq= new int[26];

            for(int j=i; j<n; j++){
                freq[str.charAt(j)-'a']++;
                int maxFreq=0;
                int minFreq=Integer.MAX_VALUE;

                for(int f: freq){
                    if(f>0){
                        maxFreq=Math.max(maxFreq, f);
                        minFreq=Math.min(minFreq, f);
                    }
                }

                count+=(maxFreq-minFreq);
            }
        }
        return count;
    }
    public static void main(String[] args) {
        String str= "aabcbaa";

        SumOFBeautyOFSubstrings obj = new SumOFBeautyOFSubstrings();
        System.out.println(obj.beautySum(str));

    }
}
