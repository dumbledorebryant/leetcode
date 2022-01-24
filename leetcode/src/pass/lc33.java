package pass;

public class lc33 {
    public int search(int[] nums, int target) {
        int length = nums.length;
        int left = 0; 
        int right = length - 1;
        while (left <= right){
            int ln = nums[left];
            int rn = nums[right];
            int mid = left + ((right - left)/2);
            int mn = nums[mid];
            if (mn == target) return mid;
            if (mn <= rn){
                if (target > mn && target <= rn) {left = mid + 1;}
                else {right = mid - 1;}
            }
            else if (ln <= mn){
                if (target < mn && target >= ln) {right = mid - 1;}
                else {left = mid + 1;}
            }
        }
        return -1;
    }
}
