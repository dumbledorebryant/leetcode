package pass;

public class lc462 {
    int sum = 0;
    for (int num : nums){
        sum += num;
    }
    int n = nums.length;
    int left = sum % n;
    int avg = sum / n;
    if (left > n - left){
        avg++;
    }
    int ans = 0;
    for (int num : nums){
        ans += Math.abs(num - avg);
    }
    return ans;
}
