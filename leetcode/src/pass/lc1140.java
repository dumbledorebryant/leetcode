package pass;

public class lc1140 {
    Integer[][] dp;
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        dp = new Integer[n][n * 2];

        int total = 0;
        for (int pile : piles){
            total += pile;
        }

        return (total + maxScore(piles, 0, 1))/2;
    }

    public int maxScore(int[] piles, int idx, int m){
        int n = piles.length;
        if (idx == n){
            return 0;
        }
        if (dp[idx][m] != null) return dp[idx][m];
        
        int max = Integer.MIN_VALUE;
        int cur = 0;
        for (int x = 0; x < 2 * m; x++){
            int i = idx + x;
            if (i >= n) continue;
            cur += piles[i];
            int score = cur - maxScore(piles, i + 1, Math.max(x + 1, m));
            max = Math.max(max, score);
        }
        dp[idx][m] = max;
        return max;
    }
}
