package pass;
import java.util.*;
class lc46 {
    List<List<Integer>> ans;
    List<Integer> item;
    int length;
    public List<List<Integer>> permute(int[] nums) {
        ans = new ArrayList<>();
        item = new ArrayList<>();
        length = nums.length;
        build(nums);
        return ans;
    }
    public void build(int[] nums) {
        for (int num : nums){
            if (item.contains(num)) continue;
            else {
                item.add(num);
                if (item.size() == length){ 
                    ans.add(new ArrayList<>(item));
                }
                else build(nums);
                item.remove(item.size() - 1);
            }
        }
    }
}
