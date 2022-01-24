package pass;

public class lc41 {
    public int firstMissingPositive(int[] nums) {
        int length = nums.length;
        int cur = 0;
        int need = 1;
        for (int i = 1; i < length; i++){
            int num = nums[i];
            if (num >= cur) continue;
            else {
                if (num < need) continue;
                else if (num == need){
                    need++;
                    if (need == cur){
                        need = cur + 1;
                    }
                }
            }
        }
    }
}
