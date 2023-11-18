package pass;

import java.util.ArrayDeque;
import java.util.Deque;

public class lc2832 {
    public int[] maximumLengthOfRanges(int[] nums) {
        int n = nums.length;
        Deque<Integer> dq = new ArrayDeque<>();
        int[] ans = new int[n];
        for (int i = 0; i < n; i++){
           int num = nums[i];
           while (!dq.isEmpty() && num > nums[dq.getLast()]){
               int idx = dq.removeLast();
               if (dq.isEmpty()){
                   ans[idx] = i;
               }
               else {
                   ans[idx] = i - dq.getLast() - 1;
               }
           } 
           dq.addLast(i);
        }
        while (!dq.isEmpty()){
            int idx = dq.removeLast();
            if (dq.isEmpty()){
                   ans[idx] = n;
               }
               else {
                   ans[idx] = n - dq.getLast() - 1;
               }
        }
        return ans;
    }
}
