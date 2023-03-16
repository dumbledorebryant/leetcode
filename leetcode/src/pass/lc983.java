package pass;

public class lc983 {
    public int mincostTickets(int[] days, int[] costs) {
        int length = days.length;
        if (days == null || length == 0 || costs == null || costs.length == 0){
            return 0;
        }

        int[] dp = new int[days[length - 1] + 1];
        dp[0] = 0;

        for (int day : days){
            dp[day] = Integer.MAX_VALUE;
        }

        for (int i = 1; i < dp.length; i++){
            if (dp[i] == 0){
                dp[i] = dp[i - 1];
                continue;
            }

            int c1 = dp[i - 1] + costs[0];
            int c2 = i > 7 ? dp[i - 7] + costs[1] : costs[1];
            int c3 = i > 30 ? dp[i - 30] + costs[2] : costs[2];

            dp[i] = Math.min(c1, Math.min(c2, c3));
        }
        return dp[days[length - 1]];
    }
}
