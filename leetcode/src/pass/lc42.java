package pass;

import java.util.Stack;

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
            if (mlh < mrh){
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

    public int trapStack(int[] height){
        int length = height.length;
        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < length; i++){
            int cur = height[i];
            while (!stack.isEmpty() && cur > height[stack.peek()]){
                int top = stack.pop();
                if (stack.isEmpty()){
                    break;
                }
                else {
                    int left = stack.peek();
                    int width = i - left - 1;
                    int cur_h = Math.min(cur, height[left]) - height[top];
                    ans += width * cur_h;
                }
            }
            stack.push(i);
        }
        return ans;
    }
}
