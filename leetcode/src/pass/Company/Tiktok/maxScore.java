package pass.Company.Tiktok;
class Solution {
    static int dp[][];
    public static int PredictTheWinner(int[] nums) {
        
        int n = nums.length;
        dp = new int[n][n];
        predictTheWinnerFrom(nums, 0, n - 1);
        
        // Compare final scores of two players.
        return dp[0][n-1];
    }
    
    private static int predictTheWinnerFrom(int[] nums, int i, int j) {
        if (i > j) {
            return 0;
        }
        if (i == j) {
            return dp[i][j] = nums[i];
        }
        if(dp[i][j] > 0){
            return dp[i][j];
        }
        
        int curScore = Math.max(
            nums[i] + (nums[i+1] >= nums[j]? 
                predictTheWinnerFrom(nums, i + 2, j):
                predictTheWinnerFrom(nums, i + 1, j - 1)
            ),
            nums[j] + (nums[i] >= nums[j-1]? 
                predictTheWinnerFrom(nums, i + 1, j - 1):
                predictTheWinnerFrom(nums, i, j - 2)
            )
        );
        
        if(nums[i+1] == nums[j]){
            int sum = nums[i] + Math.min(
                predictTheWinnerFrom(nums, i + 2, j), 
                predictTheWinnerFrom(nums, i + 1, j - 1)
            );
            curScore = Math.max(curScore, sum);
        }

        if(nums[i] == nums[j-1]){
            int sum = nums[j] + Math.min(
                predictTheWinnerFrom(nums, i, j - 2), 
                predictTheWinnerFrom(nums, i + 1, j - 1)
            );
            curScore = Math.max(curScore, sum);
        }
        
        return dp[i][j] = curScore;
    }

    public static void main(String[] args) {
        System.out.println(PredictTheWinner(new int[]{3,7,1,3}));
        System.out.println(PredictTheWinner(new int[]{5,3,7,1,2}));
        System.out.println(PredictTheWinner(new int[]{5,3,7,1,2,6}));
    }
}