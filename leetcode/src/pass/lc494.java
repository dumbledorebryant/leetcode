package pass;

public class lc494 {
    int length;
    int tgt;
    int count = 0;
    public int findTargetSumWays(int[] nums, int target) {
        length = nums.length;
        tgt = target;
        backtrace(nums, 0, 0);
        return count;
    }
    public void backtrace(int[] nums, int index, int sum){
        if (index == length && sum == tgt) {
            count++;
            return;
        };
        if (index == length) return;

        int num = nums[index];
        backtrace(nums, index + 1, sum + num);
        backtrace(nums, index + 1, sum - num);
    }
}
