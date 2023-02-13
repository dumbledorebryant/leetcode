package pass;

public class lc154 {
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
        
        if (num > end) {
            return binarySearch(nums, mid, j);
        }
        else if (num < start) {
            return binarySearch(nums, i, mid);
        }
        else {
            while (nums[i] == mid){
                i++;
            }
            while (nums[j] == mid){
                j--;
            }
            return binarySearch(nums, i, j);
        }
    }
}
