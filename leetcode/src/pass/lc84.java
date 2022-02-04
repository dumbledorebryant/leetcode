package pass;

import java.util.Stack;

public class lc84 {
    public int largestRectangleArea(int[] heights) {
        int ans = 0;
        int length = heights.length;
        Stack<Integer> stack = new Stack<>();
        stack.add(heights[0]);
        for (int i = 1; i < length; i++){
            int num = heights[i];
            while (!stack.isEmpty() && stack.peek() > num){
                
            }
        }
        return ans;
    }
}
