package StackQueue.MonotonicStack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElementI {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> nextGreaterMap = new HashMap<>();
        Stack<Integer> stk = new Stack<>();

        for (int i = nums2.length - 1; i >= 0; i--) {
            int num = nums2[i];
            while (!stk.isEmpty() && stk.peek() <= num) {
                stk.pop();
            }
            nextGreaterMap.put(num, stk.isEmpty() ? -1 : stk.peek());
            stk.push(num);
        }

        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            ans[i] = nextGreaterMap.get(nums1[i]);
        }

        return ans;
    }

    public static void main(String[] args) {
        NextGreaterElementI obj = new NextGreaterElementI();

        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};

        int[] result = obj.nextGreaterElement(nums1, nums2);

        System.out.print("Result: ");
        for (int val : result) {
            System.out.print(val + " ");
        }
    }
}
