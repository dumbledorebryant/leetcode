package pass;
import java.util.*;
public class lc40 {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> csum = new ArrayList<>();
        boolean[] used = new boolean[candidates.length];
        dfs(candidates, csum, 0, target, used);
        return ans;
    }
    public void dfs(int[] candidates, List<Integer> csum, int index, int target, boolean[] used){
        if (target == 0) {
            ans.add(new ArrayList<>(csum));
            return;
        }
        int length = candidates.length;
        if (index >= length) return;
        
        for (int i = index; i < length; i++){
            if (i > 0 && candidates[i] == candidates[i - 1] && !used[i - 1]) continue;
            
            int num = candidates[i];
            if (target - num < 0) return;
            else {
                csum.add(num);
                used[i] = true;
                dfs(candidates, csum, i + 1, target - num, used);
                used[i] = false;
                csum.remove(csum.size() - 1);
            }
        }
    }
}
