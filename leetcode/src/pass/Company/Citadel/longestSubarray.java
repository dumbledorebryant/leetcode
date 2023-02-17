import java.util.*;
public class LongestSubarray {
    public int longestSubarray(int[] nums, int k){
        int ans = 0;
        int n = nums.length;
        int l = 0;
        int r = 0;
        int sum = 0;
        while (r < n){
            int num = nums[r];
            r++;
            sum += num;
            ans = Math.max(ans, r - l);
            while (sum >= k){
                sum -= nums[l];
                l++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LongestSubarray ls = new LongestSubarray();
        int[] nums = {1, 2, 3};
        int k = 3;
        System.out.println(ls.longestSubarray(nums, k));
    }
}
