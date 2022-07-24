package pass;

public class lc153 {
    public int findMin(int[] nums) {
        int length = nums.length;
        return binarySearch(nums, 0, length - 1);
    }
    public int binarySearch(int[] nums, int i, int j){
        if (i == j) return nums[i];
        int start = nums[i];
        int end = nums[j];
        if (j - i == 1) return Math.min(start, end);
        int mid = i + ((j - i) >> 1);
        int num = nums[mid];
        
        if (num > start && num > end){
            return binarySearch(nums, mid, j);
        }
        else {
            return binarySearch(nums, i, mid);
        }
    }
}
