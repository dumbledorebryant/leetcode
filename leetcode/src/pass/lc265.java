package pass;

import java.util.Arrays;

public class lc265 {
    int n, k;
    int[][] dp;
    public int minCostII(int[][] costs) {
        n = costs.length;
        k = costs[0].length;
        dp = new int[n][k];
        for (int i = 0; i < n; i++){
            Arrays.fill(dp[i], 2001);
        }
        for (int i = 0; i < k; i++){
            dp[0][i] = costs[0][i];
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < k; i++){
            ans = Math.min(ans, recursive(n - 1, i, costs));
        }
        
        return ans;
    }

    public int recursive(int idx, int pc, int[][] costs){
        if (idx == 0){
            return dp[0][pc];
        }
        if (dp[idx][pc] != 2001) return dp[idx][pc];
        for (int i = 0; i < k; i++){
            if (i == pc) continue;
            dp[idx][pc] = Math.min(dp[idx][pc], costs[idx][pc] + recursive(idx - 1, i, costs));
        }
        return dp[idx][pc];
    }
}
