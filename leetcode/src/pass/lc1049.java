package pass;

import java.util.Arrays;

public class lc1049 {
    public int lastStoneWeightII(int[] stones) {
        int length = stones.length;
        int[] dp = new int[length];
        Arrays.sort(stones);
        int sum = sum(stones);
        int target = sum / 2;
        for (int i = 0; i < length; i++){
            int st = stones[i];
            for (int j = target; j >= st; j--){
                dp[i] += dp[i - st];
            }
        }
        
    }
    public int sum(int[] stones){
        int ans = 0;
        for (int num : stones){
            ans += num;
        }
        return ans;
    }
}
