package pass.weekly_contest.wc2022_01_29;
import java.util.*;
public class lc5981 {
    public List<Integer> maxScoreIndices(int[] nums) {
        int length = nums.length;
        List<Integer> ans = new ArrayList<>();
        if (length == 0) return ans;
        int ori_score = 0;
        for (int i = 0; i < length; i++){
            if (nums[i] == 1) ori_score += 1;
        }

        int[] dp = new int[length + 1];
        dp[0] = ori_score;
        int max = ori_score;
        for (int i = 1; i <= length; i++){
            int num = nums[i - 1];
            if (num == 0) {
                dp[i] = dp[i - 1] + 1;
                max = Math.max(max, dp[i]);
            } 
            else {
                dp[i] = dp[i - 1] - 1;
            }
        }
        for (int i = 0; i <= length; i++){
            if (dp[i] == max) ans.add(i);
        }
        return ans;
    }
}
