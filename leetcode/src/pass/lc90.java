package pass;
import java.util.*;
public class lc90 {
    List<List<Integer>> ans = new ArrayList<>();
    boolean[] visited;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        visited = new boolean[length];
        backtrace(nums, 0, new ArrayList<>());
        return ans;
    }
    public void backtrace(int[] nums, int idx, List<Integer> list){
        int length = nums.length;
        if (idx >= length){
            ans.add(new ArrayList<>(list));
            return;
        }
        
        
        backtrace(nums, idx + 1, list);
        if (idx > 0 && nums[idx] == nums[idx - 1] && !visited[idx - 1]) return;
        int num = nums[idx];
        list.add(num);
        visited[idx] = true;
        backtrace(nums, idx + 1, list);
        visited[idx] = false;
        list.remove(list.size() - 1);
    }
}
