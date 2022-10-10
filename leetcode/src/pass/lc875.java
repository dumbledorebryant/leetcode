package pass;

public class lc875 {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = Integer.MIN_VALUE;
        for (int num : piles){
            r = Math.max(r, num);
        }
        r+=1;

        while (l < r){
            int mid = l + (r - l)/2;
            int num = check(piles, mid);
            if (num <= h){
                r = mid;
            }
            else {
                l = mid + 1;
            }
        }
        return l;
    }

    public int check(int[] nums, int tgt){
        int ans = 0;
        int i = 0;
        int length = nums.length;
        for (; i < length; ){
            int num = nums[i];
            int cap = tgt;
            while (cap < num){
                num -= cap;
                ans++;
            }
            ans++;
            i++;
        }
        return ans;
    }
}
