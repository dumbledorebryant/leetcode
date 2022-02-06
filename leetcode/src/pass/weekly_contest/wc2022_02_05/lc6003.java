package pass.weekly_contest.wc2022_02_05;

public class lc6003 {
    public int minimumTime(String s) {
        int length = s.length();
        int[] left = new int[length];
        int[] right = new int[length];
        char[] chrs = s.toCharArray();

        left[0] = chrs[0] == '1' ? 1 : 0;
        for (int i = 1; i < length; i++){
            char pre = chrs[i - 1];
            char cur = chrs[i];
            if (cur == '1' && pre == '1'){
                left[i] = Math.min(2, left[i - 1]);
            }
            if (cur == '1' && pre == '0'){
                left[i] = 2;
            }
            else {
                left[i] = 0;
            }
        }

        right[length - 1] = chrs[length - 1] == '1' ? 1 : 0;
        for (int i = length - 2; i >= 0; i++){
            char pre = chrs[i + 1];
            char cur = chrs[i];
            if (cur == '1' && pre == '1'){
                left[i] = Math.min(2, left[i + 1]);
            }
            if (cur == '1' && pre == '0'){
                left[i] = 2;
            }
            else {
                left[i] = 0;
            }
        }

        int cost = 0;
        for (int i = 1; i < length; i++){
            cost += Math.min(left[i], right[i]);
        }
        return cost;
    }
}
