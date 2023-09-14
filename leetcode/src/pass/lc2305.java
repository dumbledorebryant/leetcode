package pass;

import java.util.Arrays;

public class lc2305 {
    int ans = Integer.MAX_VALUE;
    public int distributeCookies(int[] cookies, int k) {
        int n = cookies.length;
        Arrays.sort(cookies);
        int i = 0, j = n - 1;
        while (i < j){
            int temp = cookies[i];
            cookies[i] = cookies[j];
            cookies[j] = temp;
            i++;
            j--;
        }

        int[] bucket = new int[k];
        backtrack(cookies, bucket, 0, k);
        return ans;
    }

    public void backtrack(int[] nums, int[] bucket, int idx, int k){
        int n = nums.length;
        if (idx == n){
            int temp = 0;
            for (int i = 0; i < k; i++){
                temp = Math.max(temp, bucket[i]);
            }
            ans = Math.min(ans, temp);
            return;
        }
        for (int i = 0; i < k; i++){
            if (idx == 0 && i > 0) continue; 
            int num = nums[idx];
            bucket[i] += num;
            backtrack(nums, bucket, idx + 1, k);
            bucket[i] -= num;
        }
    }
}
