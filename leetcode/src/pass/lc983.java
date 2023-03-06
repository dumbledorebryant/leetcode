package pass;

public class lc983 {
    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[366];
        dp[0] = 0;
        int one = costs[0];
        int seven = costs[1];
        int thirty = costs[2];
        int length = days.length;

        int sum = 0;
        for (int i = 0; i < length; i++){
            int j = days[i];
            if (j >= 1){
                dp[j] = dp[j - 1] + one;
            }
           
            if (j >= 7){
                dp[j] = Math.min(dp[j], dp[j - 7] + seven);
            }
            

            if (j >= 30){
                dp[j] = Math.min(dp[j], dp[j - 30] + thirty);
            }
            
        }
        return dp[days[length - 1]];
    }
}
