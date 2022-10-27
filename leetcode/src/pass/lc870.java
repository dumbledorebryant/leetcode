package pass;

import java.util.Arrays;
import java.util.PriorityQueue;

public class lc870 {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int n = nums1.length;
        
        Arrays.sort(nums1);
        
        PriorityQueue<int[]> maxpq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (int i = 0; i < n; i++){
            maxpq.add(new int[]{nums2[i], i});
        }

        int l = 0; 
        int r = n - 1;
        int[] ans = new int[n];
        while (!maxpq.isEmpty()){
            int[] pair = maxpq.poll();
            int num = pair[0];
            int idx = pair[1];
            int right = nums1[r];
            if (right > num){
                ans[idx] = right;
                r--;
            }
            else {
                ans[idx] = nums1[l];
                l++;
            }
        }
        return ans;
    }
}
