package pass;
import java.util.*;
public class lc78 {
    List<List<Integer>> ans;
    public List<List<Integer>> subsets(int[] nums) {
        ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        construct(nums, 0, list);
        return ans;
    }
    public void construct(int[] nums, int i, List<Integer> cur){
        int length = nums.length;
        if (i >= length) {
            ans.add(new ArrayList<>(cur));
        }
        else {
            int num = nums[i];
            construct(nums, i + 1, cur);
            cur.add(num);
            construct(nums, i + 1, cur);
            cur.remove(cur.size() - 1);
        }
    }
}
