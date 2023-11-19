package pass.weekly_contest.wc2023_11_18;

public class lc100122 {
    public long minimumSteps(String s) {
        int n = s.length();
        int left = n - 1;
        int right = n - 1;
        long cnt = 0;
        while (left >= 0){
            if (s.charAt(left) == '1'){
                cnt += right - left;
                right--;
            }
            left--;
        }
        return cnt;
    }
}
