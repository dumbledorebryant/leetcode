package pass;

import java.util.Arrays;

public class lc354 {
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0]) return b[1] - a[1];
            return a[0] - b[0];
        });

        int[] heights = new int[n];
        for (int i = 0; i < n; i++){
            heights[i] = envelopes[i][1];
        }
        return lengthOfLIS(heights);
    }

    public int lengthOfLIS(int[] nums){
        int n = nums.length;
        int[] top = new int[n];

        int piles = 0;
        for (int i = 0; i < n; i++){
            int num = nums[i];
            int l = 0;
            int r = piles;
            while (l < r){
                int mid = l + ((r - l) / 2);
                int item = top[mid];
                if (num <= item){
                    r = mid;
                }
                else {
                    l = mid + 1;
                }
            }

            if (l == piles){
                piles++;
            }
            top[l] = num;
        }
        return piles;
    }
}
