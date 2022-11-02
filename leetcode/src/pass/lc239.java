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
    public int[] maxWindow(int[] nums, int k){
        int length = nums.length;
        int[] ans = new int[length - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < k - 1; i++){
            int num = nums[i];
            while (!deque.isEmpty() && nums[deque.getLast()] < num){
                deque.removeLast();
            }
            deque.addLast(i);
        }
        for (int i = k - 1; i < length; i++){
            int num = nums[i];
            while (!deque.isEmpty() && nums[deque.getLast()] < num){
                deque.removeLast();
            }
            deque.addLast(i);
            while (i - deque.getFirst() >= k) deque.removeFirst();
            ans[i - k + 1] = nums[deque.getFirst()];
        }
        return ans;
    }

    class MonotonicQueue{
        Deque<Integer> maxq = new LinkedList<>();
        public void push(int n){
            while (!maxq.isEmpty() && maxq.getLast() < n){
                maxq.removeLast();
            }
            maxq.addLast(n);
        }
        public int max(){
            return maxq.getFirst();
        }
        public void pop(int n){
            if (n == maxq.getFirst()){
                maxq.removeFirst();
            }
        }
    }

    MonotonicQueue mq = new MonotonicQueue();
    int[] maxSWin(int[] nums, int k){
        int length = nums.length;
        int[] ans = new int[length - k + 1];
        for (int i = 0; i < length; i++){
            mq.push(nums[i]);
            if (i >= k - 1){
                ans[i - k + 1] = mq.max();
                mq.pop(nums[i - k + 1]);
            }
        }
        return ans;
    }
}



