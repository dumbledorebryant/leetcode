package pass.weekly_contest.wc2022_02_05;

import java.util.*;

public class lc6000 {
    public int[] sortEvenOdd(int[] nums) {
        int length = nums.length;
        List<Integer> elist = new ArrayList<>();
        List<Integer> olist = new ArrayList<>();
        for (int i = 0; i < length; i++){
            int num = nums[i];
            if (i % 2 == 1) olist.add(num);
            else elist.add(num);
        }
        Collections.sort(olist);
        Collections.reverse(olist);
        Collections.sort(elist);
        int[] ans = new int[length];
        int left = 0;
        int right = 0;
        for (int i = 0; i < length; i += 2){
            ans[i] = elist.get(left);
            left++;
        }
        for (int i = 1; i < length; i += 2){
            ans[i] = olist.get(right);
            right++;
        }
        return ans;
    }
}
