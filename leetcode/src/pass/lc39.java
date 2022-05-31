package pass;
import java.util.*;
public class lc39 {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        int length = candidates.length;
        for (int i = 0; i < length; i++){
            List<Integer> item = new ArrayList<>();
            int sum = 0;
            backtrace(candidates, i, item, sum, target);
        }
        return ans;
    }
    public void backtrace(int[] cand, int i, List<Integer> item, int sum, int target){
        int length = cand.length;
        if (i >= length) return;
        int num = cand[i];
        int csum = sum + num;
        if (csum > target) return;
        item.add(num);
        if (csum == target){
            ans.add(new ArrayList<>(item));
            item.remove(item.size() - 1);
            return;
        }
        else {
            backtrace(cand, i, item, csum, target);
            item.remove(item.size() - 1);
            backtrace(cand, i + 1, item, csum, target);
            item.remove(item.size() - 1);
        }
    }
}
