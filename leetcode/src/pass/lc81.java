package pass;

public class lc81 {
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        int l = 0, r = n - 1;
        // 恢复二段性
        while (l < r && nums[0] == nums[r]) r--;

        // 第一次二分，找旋转点
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (nums[mid] >= nums[0]) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        
        int idx = n;
        if (nums[r] >= nums[0] && r + 1 < n) idx = r + 1;

        // 第二次二分，找目标值
        int ans = find(nums, 0, idx - 1, target);
        if (ans != -1) return true;
        ans = find(nums, idx, n - 1, target);
        return ans != -1;
    }
    int find(int[] nums, int l, int r, int t) {
        while (l < r) {
            int mid = l + r >> 1;
            if (nums[mid] >= t) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return nums[r] == t ? r : -1;
    }
}
