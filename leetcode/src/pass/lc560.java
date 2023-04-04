package pass;

public class lc560 {
    public int subarraySum(int[] nums, int k) {
        int length = nums.length;
        int count = 0;
        int[] prefix = new int[length + 1];
        for (int i = 1; i <= length; i++){
            prefix[i] = prefix[i - 1] + nums[i - 1];
        }
        for (int i = 0; i < length; i++){
            for (int j = i; j < length; j++){
                if (prefix[j + 1] - prefix[i] == k) count++;
            }
        }
        return count;
    }
}
