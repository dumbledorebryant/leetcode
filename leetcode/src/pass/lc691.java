package pass;

import java.util.Arrays;

public class lc691 {
    int[] memo;
    public int minStickers(String[] stickers, String target) {
        int n = target.length();
        memo = new int[1 << n];
        Arrays.fill(memo, -1);
        memo[0] = 0;
        int ans = backtrace(stickers, target, (1 << n) - 1);
        return ans <= n ? ans : -1;
    }

    public int backtrace(String[] stickers, String target, int mask){
        int n = target.length();
        if (memo[mask] < 0){
            int ans = n + 1;
            for (String sticker : stickers){
                int left = mask;
                int[] cnt = new int[26];
                char[] cs = sticker.toCharArray();
                for (char ch : cs){
                    cnt[ch - 'a']++;
                }

                for (int i = 0; i < n; i++){
                    char ch = target.charAt(i);
                    if (cnt[ch - 'a'] > 0 && ((mask >> i) & 1) == 1){
                        cnt[ch - 'a']--;
                        left ^= (1 << i);
                    }
                }
                if (left < mask){
                    ans = Math.min(ans, backtrace(stickers, target, left) + 1);
                }
            }
            memo[mask] = ans;
        }
        return memo[mask];
    }
}
