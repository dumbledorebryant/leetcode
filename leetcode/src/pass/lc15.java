package pass;
import java.util.*;
public class lc15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        if (length == 0) return ans;
        if (length < 3) return ans;
        
        for (int i = 0; i < length; i++){
            // Notice that the solution set must not contain duplicate triplets.
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int one = nums[i];
            int left = i + 1;
            int right = length - 1;
            while (left < right){
                int lv = nums[left];
                int rv = nums[right];
                int sum = one + lv + rv;
                if (sum == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(one);
                    list.add(lv);
                    list.add(rv);
                    ans.add(list);

                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                }
                else if (sum > 0){
                    right--;
                }
                else left++;
            }
        }
        
        return ans;
    }
}
