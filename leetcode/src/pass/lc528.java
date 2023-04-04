package pass;

import java.util.Random;

public class lc528 {
    int[] prefix;
    int length;
    public lc528(int[] w) {
        length = w.length;
        prefix = new int[length + 1];
        for (int i = 1; i <= length; i++){
            prefix[i] = prefix[i - 1] + w[i - 1];
        }
    }
    
    public int pickIndex() {
        Random random = new Random();
        int target = random.nextInt(prefix[length]) + 1;
        int left = left_bound(prefix, target);
        return left - 1;
    }

    public int left_bound(int[] nums, int target){
        int left = 0;
        int right = length;
        while (left <= right){
            int mid = left + (right - left)/2;
            int num = nums[mid];
            if (target == num){
                right = mid - 1;
            }
            else if (target > num){
                left = mid + 1;
            }
            else if (target < num){
                right = mid - 1;
            }
        }
        return left;
    }
}
