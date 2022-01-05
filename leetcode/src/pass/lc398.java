package pass;

import java.util.Arrays;
import java.util.Random;

public class lc398 {
    int[] numss;
    public lc398(int[] nums) {
        Arrays.sort(nums);
        numss = Arrays.copyOf(nums, nums.length);
    }
    
    public int pick(int target) {
        int left = leftb(numss, target);
        int right = rightb(numss, target);
        return (int)(left + Math.random() * (right - left + 1));
    }
    public int leftb(int[] nums, int target){
        int lindex = -1;
        int start = 0;
        int end = nums.length;
        while (start < end){
            int mid = end + ((start - end) >> 2);
            int num = nums[mid];
            if (target > num) {
                start = mid + 1;
            }
            else if (target < num) end = mid - 1;
            else {
                while (nums[mid] == target){
                    mid--;
                }
                lindex = mid + 1;
            }
        }
        return lindex;
    }
    public int rightb(int[] nums, int target){
        int lindex = -1;
        int start = 0;
        int end = nums.length;
        while (start < end){
            int mid = end + ((start - end) >> 2);
            int num = nums[mid];
            if (target > num) {
                start = mid + 1;
            }
            else if (target < num) end = mid - 1;
            else {
                while (nums[mid] == target){
                    mid++;
                }
                lindex = mid - 1;
            }
        }
        return lindex;
    }
}
