package Arrays.Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Majority_Element_II_229 {

  //Brute Force
  private List<Integer> BruteApproach(int[] nums ){
    int n=nums.length;
    int freq=n/3;
    ArrayList<Integer> list= new ArrayList<>();

    for(int i=0; i<n; i++){
      if(list.isEmpty() || list.get(0)!=nums[i]){
        int count=0;
        for(int j=0; j<n; j++){
          if(nums[j]==nums[i]) count++;
        }
        if(count>freq) list.add(nums[i]);
      }
      if(list.size()>=2){
        return list;
      }
    }
    return list;
  }

  public List<Integer> BetterApproach(int[] nums){
    int n=nums.length;
    int minFreq=n/3;

    HashMap<Integer, Integer> freqMap= new HashMap<>();
    List<Integer> result= new ArrayList<>();

    for(int num: nums){
      freqMap.put(num, freqMap.getOrDefault(num, 0)+1);
    }

    for(Map.Entry<Integer, Integer> entry: freqMap.entrySet()){
      if(entry.getValue()>minFreq){
        result.add(entry.getKey());
      }
    }
    return result;
  }

  public List<Integer> OptimalApproach(int[] nums){
    int n=nums.length;
    int minFreq=n/3;

    int element1=0, count1=0;
    int element2=0, count2=0;
    ArrayList<Integer> result= new ArrayList<>();

    for(int i=0; i<n; i++){
      if(count1==0 && nums[i]!=element2){
        element1=nums[i];
        count1++;
      }
      else if(count2==0 && nums[i]!=element1){
        element2=nums[i];
        count2++;
      }
      else if(nums[i]==element1){
        count1++;
      }
      else if(nums[i]==element2){
        count2++;
      }else{
        count1--;
        count2--;
      }
    }

    int freq1=0, freq2=0;
    for(int i=0; i<n; i++){
      if(nums[i]==element1){
        freq1++;
      }
      else if(nums[i]==element2){
        freq2++;
      }
    }

    if(freq1>minFreq){
      result.add(element1);
    }

    if(freq2>minFreq){
      result.add(element2);
    }
    return result;
  }

  public static void main(String[] args) {
    Majority_Element_II_229 obj= new Majority_Element_II_229();

    int [] nums= {3,2,3};
    int atMostElement=2;
    List<Integer> ans= obj.OptimalApproach(nums);
    for(int i=0;i<ans.size();i++){
      System.out.println(ans.get(i));
    }
  }
}
