package pass;

import java.util.ArrayDeque;
import java.util.Deque;

public class lc2104 {
    public long subArrayRanges(int[] nums) {
        Deque<Integer> stack = new ArrayDeque<>();
        long max = 0;
        long min = 0;
        int n = nums.length;
        for (int i = 0; i <= n; i++){
            while (!stack.isEmpty() && (i == n || nums[stack.peek()] < nums[i])){
                int j = stack.poll();
                max += (long)nums[j] * (i - j) * (j - (stack.isEmpty() ? -1 : stack.peek()));
            }
            stack.push(i);
        }
        stack.clear();
        for (int i = 0; i <= n; i++){
            while (!stack.isEmpty() && (i == n || nums[stack.peek()] > nums[i])){
                int j = stack.poll();
                min += (long)nums[j] * (i - j) * (j - (stack.isEmpty() ? -1 : stack.peek()));
            }
            stack.push(i);
        }
        return max - min;
    }
}
