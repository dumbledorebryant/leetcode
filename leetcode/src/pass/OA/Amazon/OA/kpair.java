package pass.OA.Amazon.OA;

import java.util.*;

public class kpair {
    public List<Integer> ksmallest(int[] nums, int k){
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < k; i++){
            ans.add(smallestDistancePair(nums, i));
        }
        return ans;
    }

    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length, left = 0, right = nums[n - 1] - nums[0];
        while (left <= right) {
            int mid = (left + right) / 2;
            int cnt = 0;
            for (int i = 0, j = 0; j < n; j++) {
                while (nums[j] - nums[i] > mid) {
                    i++;
                }
                cnt += j - i;
            }
            if (cnt >= k) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
