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

    public int max(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0]) return b[1] - a[1];
            return a[0] - b[0];
        });
        int n = envelopes.length;
        int[] piles = new int[n];
        int[] list = new int[n];
        for (int i = 0; i < n; i++){
            list[i] = envelopes[i][1];
        }

        return countPiles(piles, list);
    }

    public int countPiles(int[] piles, int[] list){
        int n = piles.length;
        int m = 0;
        for (int i = 0; i < n; i++){
            int left = 0;
            int right = m - 1;
            int num = list[i];
            while (left <= right){
                int mid = left + (right - left) / 2;
                if (piles[mid] < num) {
                    left = mid + 1;
                }
                else {
                    right = mid - 1;
                }
            }
            if (left == m) m++;
            piles[left] = num; 
        }
        return m;
    }
}
