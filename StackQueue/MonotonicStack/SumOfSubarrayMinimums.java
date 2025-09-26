package StackQueue.MonotonicStack;

import java.util.Stack;

public class SumOfSubarrayMinimums {

    public int getSumOfMin(int[] nums) {
        int n = nums.length;
        int MOD = 1_000_000_007;

        int[] left = new int[n];  // distance to previous less
        int[] right = new int[n]; // distance to next less

        Stack<Integer> stk = new Stack<>();

        // Previous Less Element (distance)
        for (int i = 0; i < n; i++) {
            while (!stk.isEmpty() && nums[stk.peek()] > nums[i]) {
                stk.pop();
            }
            left[i] = stk.isEmpty() ? i + 1 : i - stk.peek();
            stk.push(i);
        }

        stk.clear();

        // Next Less Element (distance)
        for (int i = n - 1; i >= 0; i--) {
            while (!stk.isEmpty() && nums[stk.peek()] >= nums[i]) {
                stk.pop();
            }
            right[i] = stk.isEmpty() ? n - i : stk.peek() - i;
            stk.push(i);
        }

        long res = 0;
        for (int i = 0; i < n; i++) {
            res = (res + (long) nums[i] * left[i] * right[i]) % MOD;
        }

        return (int) res;
    }

    public static void main(String[] args) {
        SumOfSubarrayMinimums obj = new SumOfSubarrayMinimums();
        int[] arr = {3, 1, 2, 4};
        System.out.println(obj.getSumOfMin(arr));  // Output: 17
    }
}
