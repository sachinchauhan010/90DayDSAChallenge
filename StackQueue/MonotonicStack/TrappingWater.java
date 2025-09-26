package StackQueue.MonotonicStack;

public class TrappingWater {

    public int BetterSol(int[] nums){

        int n=nums.length;

        //PrefixMax
        int[] prefixMax= new int[n];
        prefixMax[0]=nums[0];
        for(int i=1; i<n; i++){
            prefixMax[i]= Math.max(prefixMax[i-1], nums[i]);
        }

        //SuffixMax
        int[] suffixMax= new int[n];
        suffixMax[n-1]= nums[n-1];
        for(int i=n-2; i>=0; i--){
            suffixMax[i]= Math.max(suffixMax[i+1], nums[i]);
        }

        //Total Unit of Water
        int total=0;
        for(int i=0; i<n; i++){
            if(nums[i] < prefixMax[i] && nums[i]< suffixMax[i]){
                total+= Math.min(prefixMax[i], suffixMax[i]) - nums[i];
            }
        }
        return total;
    }
    public static void main(String[] args) {

        int[] arr= {0,1,0,2,1,0,1,3,2,1,2,1};
        TrappingWater obj = new TrappingWater();
        System.out.println(obj.BetterSol(arr));

    }
}
