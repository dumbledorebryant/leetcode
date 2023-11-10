package pass;

public class lc457 {
    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            // 当前元素为0，不可能构成环
            if (nums[i] == 0) {
                continue;
            }
            int slow = i, fast = next(nums, i);
            while (slow != fast) {
                // 方向不同或者到达了0或者越界
                if (nums[slow] * nums[fast] <= 0 || nums[next(nums, fast)] * nums[slow] <= 0) {
                    break;
                }
                slow = next(nums, slow);
                fast = next(nums, next(nums, fast));
            }
            // 找到环
            if (slow == fast && slow != next(nums, slow)) {
                return true;
            }
            // 标记已走过的位置为0
            int cur = i;
            while (nums[cur] * nums[next(nums, cur)] > 0) {
                int tmp = cur;
                cur = next(nums, cur);
                nums[tmp] = 0;
            }
        }
        return false;
    }

    // 求下一步的位置
    private int next(int[] nums, int cur) {
        int n = nums.length;
        return ((cur + nums[cur]) % n + n) % n;
    }
}
