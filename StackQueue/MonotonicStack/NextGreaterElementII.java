package StackQueue.MonotonicStack;

import java.util.Stack;

public class NextGreaterElementII {
    public int[] getNextGreaterElements(int[] nums){

        int n= nums.length;
        int[] ans= new int[n];
        Stack<Integer> stk= new Stack<>();

        for(int i=(2*n-1); i>=0; i--){

            while(!stk.isEmpty() && stk.peek()<=nums[i%n]){
                stk.pop();
            }
            if(i<n){
                ans[i]= stk.isEmpty()? -1 : stk.peek();
            }
            stk.push(nums[i%n]);
        }
        return ans;
    }
    public static void main(String[] args) {
        NextGreaterElementII obj = new NextGreaterElementII();
        int[] arr= {1, 2, 3, 4, 3};

        int[] res= obj.getNextGreaterElements(arr);

        for(int i=0; i<arr.length; i++){
            System.out.println(res[i]+" ");
        }
    }
}
