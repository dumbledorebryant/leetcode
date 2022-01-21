package pass;

public class lc11 {
    public int maxArea(int[] height) {
        int length = height.length;
        int left = 0;
        int right = length - 1;
        int ans = 0;
        while (left < right){
            int lh = height[left];
            int rh = height[right];
            int area = (right - left) * Math.min(lh, rh);
            if (area > ans){
                ans = area;
            }
            if (lh == Math.min(lh, rh)) left++;
            else right--;
        }
        return ans;
    }
}
