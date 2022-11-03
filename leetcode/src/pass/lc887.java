package pass;
import java.util.*;
public class lc887 {
    int[][] dp;
    public int superEggDrop(int e, int f) {
        dp = new int[e+1][f+1];
        for(int[] a: dp)
            Arrays.fill(a, -1);
        return solve(e, f);
    }
    
    private int solve(int e, int f) {
        if(e == 1) return f;
        if(f == 0 || f == 1) return f;
        
        if(dp[e][f] != -1) return dp[e][f];
        int ans = Integer.MAX_VALUE;
       
        int left = 1, right = f;
        while(left <= right) {
            int k = left + (right - left) / 2;
            
            int low = solve(e-1, k-1);
            int high = solve(e, f-k);
            
            int temp = 1 + Math.max(low, high);
            ans = Math.min(ans, temp);
            if(low < high) left = k + 1;
            else right = k - 1;          
        }   
		
        return dp[e][f] = ans;
    }
}
