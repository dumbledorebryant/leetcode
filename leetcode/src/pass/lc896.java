package pass;

public class lc896 {
    int n = nums.length;
        if (n <= 2) return true;
        int flag = 0;
        if (nums[0] < nums[n - 1]) flag = 1;
        if (nums[0] > nums[n - 1]) flag = -1;
        for (int i = 1; i < n; i++){
            if (flag == 1 && nums[i - 1] > nums[i]) return false;
            if (flag == -1 && nums[i - 1] < nums[i]) return false;
            if (flag == 0 && nums[i - 1] != nums[i]) return false;
        }
        return true;
}
