package pass;

public class lc1208 {
    public int equalSubstring(String s, String t, int maxCost) {
        int n = s.length();

        int l = 0;
        int r = 0;

        int max = 0;
        int cur = 0;
        int res = 0;
        while (r < n){
            char sch = s.charAt(r);
            char tch = t.charAt(r);
            r++;

            int num = (int)Math.abs(sch - tch);
            cur += num;
            if (cur <= maxCost){
                max = Math.max(max, cur);
                res = Math.max(res, r - l);
            }

            while (cur > maxCost){
                char spre = s.charAt(l);
                char tpre = t.charAt(l);
                int pre = (int)Math.abs(spre - tpre);
                cur -= pre;
                l++;
            }
        }
        return res;
    }
}
