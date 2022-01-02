package pass;

import java.util.Stack;

public class lc503 {
    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        int[] ans = new int[len];
        Stack<Integer> s = new Stack<>();
        for (int i = 2 * len - 1; i >= 0; i--){
            while(!s.empty() && s.peek() <= nums[i % len]){
                s.pop();
            }
            ans[i % len] = s.empty() ? -1 : s.peek();
            s.push(nums[i % len]); 
        }
        return ans;
    }
}
