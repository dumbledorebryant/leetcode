package pass.weekly_contest.wc2022_08_27;

import java.util.Arrays;

public class lc6160 {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int n = nums.length;
        int m = queries.length;
        int[] ans = new int[m];
        
        for (int j = 0; j < m; j++){
            int sum = 0;
            for (int i = 0; i < n; i++){
                sum += nums[i];
                if (sum > queries[j]){
                    ans[j] = i + 1;
                }
            }
        }
        return ans;
    }
}
