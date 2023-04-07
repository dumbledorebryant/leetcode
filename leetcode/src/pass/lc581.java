package pass;

import java.util.Deque;
import java.util.LinkedList;

public class lc581 {
    public int findUnsortedSubarray(int[] nums) {
        Deque<Integer> stack = new LinkedList<>();
        int length = nums.length;
        int left = length;
        int right = -1;
        for (int i = 0; i < length; i++){
            int num = nums[i];
            while (!stack.isEmpty() && nums[stack.getLast()] > num){
                left = Math.min(left, stack.removeLast());   
            }
            stack.addLast(i);
        }
        Deque<Integer> stack2 = new LinkedList<>();
        for (int i = length - 1; i >= 0; i--){
            int num = nums[i];
            while (!stack2.isEmpty() && nums[stack2.getLast()] < num){
                right = Math.max(right, stack2.removeLast());   
            }
            stack2.addLast(i);
        }
        if (left == length) return 0;
        return right - left + 1;
    }
}
