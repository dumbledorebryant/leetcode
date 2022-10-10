package pass;

public class lc410 {
    public int splitArray(int[] nums, int k) {
        int left = Integer.MIN_VALUE;
        int right = 0;
        for (int num : nums){
            left = Math.max(left, num);
            right += num;
        }

        while (left <= right){
            int mid = left + (right - left)/2;
            int num = check(nums, mid);
            if (num <= k){
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return left;
    }

    public int check(int[] nums, int tgt){
        int ans = 0;
        int i = 0;
        int length = nums.length;
        for (; i < length;){
            int cap = tgt;
            while (i < length && cap >= nums[i]){
                cap -= nums[i];
                i++;
            }
            ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        int k = 2;
        lc410 lc = new lc410();
        System.out.println(lc.splitArray(nums, k));
    }
}
