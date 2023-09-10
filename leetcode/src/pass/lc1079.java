package pass;

import java.util.Arrays;

public class lc1079 {
    boolean[] used;
    int count = 0;
    public int numTilePossibilities(String tiles) {
        int n = tiles.length();
        char[] chrs = tiles.toCharArray();
        Arrays.sort(chrs);
        StringBuilder sb = new StringBuilder();
        for (char ch : chrs) sb.append(ch);
        used = new boolean[n];
        backtrack(sb.toString());
        return count - 1;
    }

    public void backtrack(String s){
        count++;
        int n = s.length();
        for (int i = 0; i < n; i++){
            char ch = s.charAt(i);
            if (used[i]) continue;
            if (i > 0 && s.charAt(i - 1) == ch && !used[i - 1]) continue;
            used[i] = true;
            backtrack(s);
            used[i] = false;
        }
    }
}
