package pass.weekly_contest.wc2022_08_27;

public class lc6162 {
    public int garbageCollection(String[] garbage, int[] travel) {
        int n = garbage.length;
        int l = travel.length;
        int m = 0;
        int p = 0;
        int g = 0;
        int ans = 0;
        for (int i = 0; i < n; i++){
            String str = garbage[i];
            int len = str.length();
            for (int j = 0; j < len; j++){
                if (str.charAt(j) == 'M') m = i;
                if (str.charAt(j) == 'P') p = i;
                if (str.charAt(j) == 'G') g = i;
            }
            ans += len;
        }
        for (int i = 0; i < l; i++){
            if (m > i) ans += travel[i];
            if (p > i) ans += travel[i];
            if (g > i) ans += travel[i];
        }
        return ans;
    }
}
