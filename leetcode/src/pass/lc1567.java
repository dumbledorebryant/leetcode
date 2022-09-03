package pass;

public class lc1567 {
    public int getMaxLen(int[] nums) {
        int n = nums.length;
        // 负、正数个数 第一个负数出现的位置
        int neg = 0, pos = 0, fisrt = -1;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                // 遇到0所有标记初始化
                pos = 0;
                neg = 0;
                fisrt = -1;
            } else if (nums[i] > 0) {
                pos++;
            } else {
                // 记录该段第一个负数出现的位置
                if (fisrt == -1) {
                    fisrt = i;
                }
                neg++;
            }
            if (neg % 2 == 0) {
                // 该段所有数乘积为正
                ans = Math.max(ans, pos + neg);
            } else {
                // 从第一个负数出现的位置后面到当前位置的乘积为正
                ans = Math.max(ans, i - fisrt);
            }
        }
        return ans;    
    }
    public int getmaxlen(int[] nums){
        int length = nums.length;
        int[] positive = new int[length];
        int[] negative = new int[length];

        int n0 = nums[0];
        if (n0 > 0){
            positive[0] = 1;
        }
        else if (n0 < 0){
            negative[0] = 1;
        }
        for (int i = 1; i < length; i++){
            int num = nums[i];
            if (num > 0){
                positive[i] = positive[i - 1] + 1;
                negative[i] = negative[i - 1] == 0 ? 0 : negative[i - 1] + 1;
            }
            if (num < 0){
                positive[i] = negative[i - 1] == 0 ? 0 : negative[i - 1] + 1;
                negative[i] = positive[i - 1] + 1;
            }
        }
        int ans = 0;
        for (int i = 0; i < length; i++){
            ans = Math.max(ans, positive[i]);
        }
        return ans;
    }
}
