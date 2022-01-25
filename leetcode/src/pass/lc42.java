package pass;

public class lc42 {
    public int trap(int[] height) {
        int length = height.length;
        int left = 0;
        int right = length - 1;
        int mlh = 0;
        int mrh = 0;
        int ans = 0;
        while (left < right){
            int clh = height[left];
            int crh = height[right];
            mlh = Math.max(mlh, clh);
            mrh = Math.max(mrh, crh);
            if (clh < crh){
                ans += (mlh - clh);
                left++;
            }
            else {
                ans += (mrh - crh);
                right--;
            }
        }
        return ans;
    }
}
