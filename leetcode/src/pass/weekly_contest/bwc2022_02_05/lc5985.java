package pass.weekly_contest.bwc2022_02_05;

import java.util.*;

public class lc5985 {
    public int[] pivotArray(int[] nums, int pivot) {
        List<Integer> small = new ArrayList<>();
        List<Integer> large = new ArrayList<>();
        List<Integer> eqs = new ArrayList<>();
        int length = nums.length;
        for (int i = 0; i < length; i++){
            int num = nums[i];
            if (num < pivot) small.add(num);
            else if (num > pivot) large.add(num);
            else eqs.add(num);
        }
        int[] ans = new int[length];
        int slen = small.size();
        for (int i = 0; i < slen; i++){
            ans[i] = small.get(i);
        }
        int elen = eqs.size();
        for (int i = slen; i < slen + elen; i++){
            ans[i] = eqs.get(i - slen);
        }
        for (int i = slen + elen; i < length; i++){
            ans[i] = large.get(i - slen - elen);
        }
        
        return ans;
    }
}
