package pass;

import java.util.*;

public class lc491 {
    Set<List<Integer>> ans = new HashSet<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        backtrack(nums, 0, new ArrayList<>());
        List<List<Integer>> res = new ArrayList<>(ans);
        return res;
    }

    public void backtrack(int[] nums, int idx, List<Integer> list){
        if (list.size() >= 2){
            ans.add(new ArrayList<>(list));
        }
        int length = nums.length;
        for (int i = idx; i < length; i++){
            int num = nums[i];
            if (list.size() == 0 || num >= list.get(list.size() - 1)){
                list.add(num);
                backtrack(nums, i + 1, list);
                list.remove(list.size() - 1);
            }
        }
    }
}
