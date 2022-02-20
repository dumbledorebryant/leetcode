package pass.weekly_contest.wc2022_02_19;

import java.util.*;

public class lc6015 {
    public long coutPairs(int[] nums, int k) {
        int n = nums.length;
        int[] arr = new int[n];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++){
            int num = nums[i];
            if (arr[i] == 1) continue;
            if (num % k == 0){
                list.add(i);
            }
        }
        int ans = 0;
        int len = list.size();
        for (int i = 0; i < len; i++){
            ans += (n - 1 - i);
        }
        return ans;
    }
}
