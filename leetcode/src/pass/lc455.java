package pass;

import java.util.Arrays;

public class lc455 {
    public int findContentChildren(int[] g, int[] s) {
        int count = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int glen = g.length;
        int slen = s.length;
        if (slen == 0) return 0;
        if (glen == 0) return 0;
        int j = glen - 1;
        int i = slen - 1;
        while (i >= 0 && j >= 0){
            if (s[i] >= g[j]){
                count++;
                i--;
            }
            j--;
        }
        return count;
    }
}
