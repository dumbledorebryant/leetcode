package pass;

public class lc42 {
    public int trap(int[] height) {
        int length = height.length;
        int left = 0;
        int right = length - 1;
        int lh = 0;
        int rh = 0;
        int ans = 0;
        while (left < right){
            int clh = height[left];
            int crh = height[right];
            ans -= (Math.min(Math.min(lh, clh), Math.min(rh, crh)) * (right - left + 1));
            ans += (Math.min(clh, crh) * (right - left - 1));
            lh = clh;
            rh = crh;
            if (lh == Math.min(lh, rh)) left++;
            else right--;
        }
        return ans;
    }
}
