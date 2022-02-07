package pass;

import java.util.HashSet;

public class lc128 {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int length = nums.length;
        for (int i = 0; i < length; i++){
            set.add(nums[i]);
        }

        int ans = 0;
        for (int i = 0; i < length; i++){
            int num = nums[i];
            if (!set.contains(num - 1)){
                int count = 1;
                while (set.contains(num + 1)){
                    count++;
                    num++;
                }
                ans = Math.max(ans, count);
            }
        }
        return ans;
    }
}
