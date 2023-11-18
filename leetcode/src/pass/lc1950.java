package pass;

import java.util.ArrayDeque;
import java.util.Deque;

public class lc1950 {
    public int[] findMaximums(int[] nums) {
        // 1.Use monostack twice to calculate the index of nearest smaller components for each nums[i], both left and right. 
		Deque<Integer> stack = new ArrayDeque<>();
		int n = nums.length;
        // left[i] is the idx of nearest component in the left of nums[i] whose value is smaller than nums[i]
        int[] left = new int[n];
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        stack.clear();
		
		// right[i] is the idx of nearest component in the right of nums[i] whose value is smaller than nums[i]
        int[] right = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        
        // 2.For each nums[i], calculate the maximum extension length for the nums[i], that nums[i] can be the smallest one in the subarray with that length. Then, update the result of that length to the maximum one.
        // for each nums[i], find the maximum length of subarray, that nums[i] is the smallest one in the array
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int len = right[i] - left[i] - 1;
            res[len - 1] = Math.max(res[len - 1], nums[i]);
        }
        
        // 3.Update the result in reverse order, reverse the res[i] to the max(res[i], res[i + 1])
        // since we may miss some value, we need to update the res[i] to the larger one between itself and the maximum one in its right. In other words, the maximum one of small query must be larger or equal than the big query
        for (int i = n - 2; i >= 0; i--) {
            res[i] = Math.max(res[i], res[i + 1]);
        }
        return res;
    }
}
