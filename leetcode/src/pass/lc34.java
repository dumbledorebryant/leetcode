package pass;

public class lc34 {
    public int[] searchRange(int[] nums, int target) {
        int length = nums.length;
        int left = 0;
        int right = length - 1;
        while (left < right){
            int mid = left + (right - left)/2;
            int mnum = nums[mid];
            if (mnum == target){
                int l = mid;
                int r = mid;
                while (l >= 0 && nums[l] == target){
                    l--;
                }
                while (r < length && nums[r] == target){
                    r++;
                }
                return new int[]{l + 1, r - 1};
            }
            if (mnum > target){
                right = mid - 1;
            }
            if (mnum < target){
                left = mid + 1;
            }
        }
        return new int[]{-1, -1};
    }

    public int[] searchRanges(int[] nums, int target) {
        int length = nums.length;
        int left = 0;
        int right = length - 1;
        while (left <= right){
            int mid = left + (right - left)/2;
            int mnum = nums[mid];
           
            if (mnum == target){
                right = mid - 1;
            }
            if (mnum > target){
                right = mid - 1;
            }
            if (mnum < target){
                left = mid + 1;
            }
        }
        
        int ansl = left;
        if (left == length || nums[left] != target) return new int[]{-1, -1};
        left = 0; 
        right = length - 1;
        while (left <= right){
            int mid = left + (right - left)/2;
            int mnum = nums[mid];
           
            if (mnum == target){
                left = mid + 1;
            }
            if (mnum > target){
                right = mid - 1;
            }
            if (mnum < target){
                left = mid + 1;
            }
        }
        int ansr = right;
        if (right == -1 || nums[right] != target) return new int[]{-1, -1};
        return new int[]{ansl, ansr};
    }
}
