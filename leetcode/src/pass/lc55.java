package pass;

public class lc55 {
    public boolean canJump(int[] nums) {
        int length = nums.length;
        int reach = 0;
        for (int i = 0; i < length - 1; i++){
            reach = Math.max(reach, i + nums[i]);
            if (reach <= i) return false;
        }
        return reach >= length - 1;
    }
}
