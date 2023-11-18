package pass;

import java.util.ArrayList;
import java.util.List;

public class lc442 {
    public List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++){
            int idx = Math.abs(nums[i]) - 1;
            if (nums[idx] < 0){
                ans.add(idx + 1);
            }
            nums[idx] *= -1;
        }
        return ans;
    }
}
