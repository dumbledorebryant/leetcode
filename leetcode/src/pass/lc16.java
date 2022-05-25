package pass;
import java.util.Arrays;

public class lc16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int length = nums.length;
        int csum = Integer.MAX_VALUE;
        for (int i = 0; i < length; i++){
            int a = nums[i];
            int m = i + 1;
            int n = length - 1;
            while (m < n){
                int b = nums[m];
                int c = nums[n];
                int sum = a + b + c;
                if (Math.abs(target - sum) < Math.abs(target - csum)){
                    csum = sum;
                }
                if (sum > target){
                    n--;
                }
                if (sum == target) return sum;
                if (sum < target) {
                    m++;
                }
            }
        }
        return csum;
    }
}
