package pass;

public class lc974 {
    public int subarraysDivByK(int[] nums, int k) {
        int n = nums.length;
        int[] prefix = new int[n + 1];
        int[] map = new int[k];
        map[0] = 1;
        int ans = 0;
        for (int i = 1; i <= n; i++){
            int num = prefix[i - 1] + nums[i - 1];
            prefix[i] = num;
            int key = (num % k + k) % k;
            ans += map[key];
            map[key]++;
        }
        return ans;
    }
}
