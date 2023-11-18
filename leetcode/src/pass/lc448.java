package pass;

import java.util.ArrayList;
import java.util.List;

public class lc448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++){
            int idx = Math.abs(nums[i]) - 1;
            if (nums[idx] > 0) nums[idx] *= -1;
        }
        for (int i = 0; i < n; i++){
            if (nums[i] > 0){
                ans.add(i + 1);
            }
        }
        return ans;
    }
}
