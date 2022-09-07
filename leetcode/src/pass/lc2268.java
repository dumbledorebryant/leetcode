package pass;

import java.util.*;

public class lc2268 {
    public int minimumKeypresses(String s) {
        int[] count = new int[26];
        char[] chrs = s.toCharArray();
        for (char ch : chrs){
            count[ch - 'a']++;
        }
        Arrays.sort(count);
        int ans = 0;
        List<Integer> list = new ArrayList<>();
        for (int num : count){
            if (num != 0) list.add(num);
        }
        Collections.sort(list, (a, b) -> b - a);
        int len = list.size();
        for (int i = 0; i < len; i++){
            ans += (i / 9 + 1) * list.get(i);
        }
        return ans;
    }
}
