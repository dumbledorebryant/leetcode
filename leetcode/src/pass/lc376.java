package pass;

public class lc376 {
    public int wiggleMaxLength(int[] nums) {
        int length = nums.length;
        int prediff = 0;
        int diff = 0;
        int count = 1;
        for (int i = 1; i < length; i++){
            int prev = nums[i - 1];
            int curr = nums[i];
            diff = curr - prev;
            if ((prediff >= 0 && diff < 0) || (prediff <= 0 && diff > 0)){
                count++;
                prediff = diff;
            }
        }
        return count;
    }
}
