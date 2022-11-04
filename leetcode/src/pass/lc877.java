package pass;

public class lc877 {
    public boolean stoneGame(int[] piles) {
        class Pair{
            int fir, sec;
            Pair(int first, int second){
                fir = first;
                sec = second;
            }
        }

        int n = piles.length;
        Pair[][] dp = new Pair[n][n];
        for (int i = 0; i < n; i++){
            for (int j = i; j < n; j++){
                dp[i][j] = new Pair(0, 0);
            }
        }

        for (int i = 0; i < n; i++){
            dp[i][i].fir = piles[i];
            dp[i][i].sec = 0;
        }

        for (int i = n - 2; i >= 0; i--){
            for (int j = i + 1; j < n; j++){
                int l = piles[i] + dp[i + 1][j].sec;
                int r = piles[j] + dp[i][j - 1].sec;
                
                if (l > r){
                    dp[i][j].fir = l;
                    dp[i][j].sec = dp[i + 1][j].fir;
                }
                else {
                    dp[i][j].fir = r;
                    dp[i][j].sec = dp[i][j - 1].fir;
                }
            }
        }
        Pair ans = dp[0][n - 1];
        return (ans.fir - ans.sec) >= 0;
    }
}
