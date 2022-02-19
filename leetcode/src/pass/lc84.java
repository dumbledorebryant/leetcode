package pass;

import java.util.Stack;

public class lc84 {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        
        int ans = 0;

        int length = heights.length;
        int[] nheights = new int[length + 2];
        for (int i = 1; i <= length; i++){
            nheights[i] = heights[i - 1];
        }
        heights = nheights;
        for (int i = 1; i < heights.length; i++){
            int num = heights[i];
            while (!stack.isEmpty() && heights[stack.peek()] > num){
                int mid = stack.pop();
                int left = stack.peek();
                int right = i;
                int height = heights[mid];
                ans = Math.max(ans, (right - left - 1) * height);
            }
            stack.push(i);
        }
        return ans;
    }
}
