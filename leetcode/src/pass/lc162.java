package pass;

public class lc162 {
    public int findPeakElement(int[] nums) {
        int length = nums.length;
        int left = 0;
        int right = length - 1;
        while (left < right){
            int mid = left + ((right - left) >> 1);
            if (nums[mid] < nums[mid + 1]) left = mid + 1;
            else right = mid;
        }
        return left;
    }
}
