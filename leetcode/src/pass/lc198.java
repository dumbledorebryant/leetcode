package pass;

public class lc198 {
    public int rob(int[] nums) {
        int length = nums.length;
        if (length == 0) return 0;
        if (length == 1) return nums[0];
        int[] money = new int[length + 1];
        money[0] = 0;
        money[1] = nums[0];
        for (int i = 2; i <= length; i++){
            money[i] = Math.max(money[i - 2] + nums[i - 1], money[i - 1]);
        }
        return money[length];
    }
}
