package pass;
import java.util.*;
public class lc47 {
    boolean[] visited;
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        visited = new boolean[length];
        backtrace(nums, 0, new ArrayList<>());
        return ans;
    }
    public void backtrace(int[] nums, int idx, List<Integer> list){
        int length = nums.length;
        if (idx == length){
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < length; i++){
            if (visited[i]) continue;
            if (i > 0 && (nums[i] == nums[i - 1]) && !visited[i - 1]) continue;
            int num = nums[i];
            list.add(num);
            visited[i] = true;
            backtrace(nums, idx + 1, list);
            visited[i] = false;
            list.remove(list.size() - 1);
        }
    }
}
