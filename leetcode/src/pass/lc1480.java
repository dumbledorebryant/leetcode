package pass;

public class lc1480 {
    public int[] runningSum(int[] nums) {
        int length = nums.length;
        if (length == 0) return null;
        int[] temp = new int[length];
        temp[0] = nums[0];
        for (int i = 1; i < length; i++){
            temp[i] = temp[i - 1] + nums[i];
        }

        return temp;
    }
}
