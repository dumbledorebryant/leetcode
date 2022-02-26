package pass;

import java.util.*;

public class lc239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int length = nums.length;
        Deque<Integer> deque = new LinkedList<>();
        int len = length - (k - 1);
        int[] dp = new int[len];
        for (int i = 0; i < k - 1; i++){
            int num = nums[i];
            while (!deque.isEmpty() && nums[deque.getLast()] < num){
                deque.removeLast();
            }
            deque.add(i);
        }

        for (int i = k - 1; i < length; i++){
            int num = nums[i];
            while (!deque.isEmpty() && nums[deque.getLast()] < num){
                deque.removeLast();
            }
            deque.addLast(i);
            while (i - deque.getFirst() >= k - 1) deque.removeFirst();
            dp[i - k + 1] = nums[deque.getFirst()];
        }
        return dp;
    }
}
