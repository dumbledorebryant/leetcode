package pass;

public class lc84 {
    public int largestRectangleArea(int[] heights) {
        int length = heights.length;
        int left = (length - 1) / 2;
        int right = 0;
        if (length % 2 == 0) right = left + 1;
        else right = left;
        int height = Integer.MAX_VALUE;
        int ans = 0;
        while (left >= 0 && right <= length - 1){
            int clh = heights[left];
            int crh = heights[right];
            height = Math.min(height, clh);
            height = Math.min(height, crh);
            ans = Math.max(Math.max(clh, crh), ans);
            int height = Math.min(mlh, mrh);
            int area = (right - left + 1) * height;
            ans = Math.max(ans, area);
            if (mlh > mrh) left--;
            else right++;
        }
        return ans;
    }
}
