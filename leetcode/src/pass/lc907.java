package pass;

import java.util.*;

public class lc907 {
    private static final int MOD = 1000000007;

    // 重写根据下标取值方法，-1和n返回MIN_VALUE
    private int getElement(int[] arr, int n, int i) {
        if (i == -1 || i == n) {
            return Integer.MIN_VALUE;
        }
        return arr[i];
    }
    
    public int sumSubarrayMins(int[] arr) {
        // 处理边界情况
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int n = arr.length;
        long ans = 0;
        Deque<Integer> stack = new LinkedList<>();
        // 将下标-1和n作为两个哨兵元素，它们对应的元素为MIN_VALUE
        // -1作为最左边界，n作为最右边界
        for (int i = -1; i <= n; i++) {
            // 向左寻找第一个小于等于A[i]的元素
            while (!stack.isEmpty() && getElement(arr, n, stack.peek()) > getElement(arr, n, i)) {
                // A[cur]就是之前思路中的A[i]，注意区分和上面代码的区别
                // 对于每个出栈元素来说，i就是它们的右边界，而栈顶元素就是左边界
                int cur = stack.pop();
                // 计算贡献值
                ans = (ans + (long)(cur - stack.peek()) * (i - cur) * arr[cur]) % MOD;
            }
            stack.push(i);
        }

        return (int)ans;
    }
}
