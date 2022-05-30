package pass;
import java.util.*;
public class lc18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int length = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < length; i++){
            int a = nums[i];
            for (int j = i + 1; j < length; j++){
                int b = nums[j];
                int left = j + 1;
                int right = length - 1;
                while (left < right){
                    int c = nums[left];
                    int d = nums[right];
                    int sum = a + b + c + d;
                    if (sum == target){
                        List<Integer> item = new ArrayList<>();
                        item.add(a);
                        item.add(b);
                        item.add(c);
                        item.add(d);
                        if (!set.contains(item)){
                            set.add(item);
                            ans.add(item);
                        }
                        left++;
                    }
                    else if (sum < target){
                        left++;
                    }
                    else right--;
                }
            }
        }
        
        return ans;
    }
}
