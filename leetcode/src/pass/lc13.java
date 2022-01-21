package pass;

import java.util.HashMap;
import java.util.Map;

public class lc13 {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        char[] chrs = s.toCharArray();
        int length = chrs.length;
        int ans = 0;
        for (int i = 0; i < length; i++){
            char ch = chrs[i];
            int cur = map.get(ch);
            if (i < length - 1){
                char nch = chrs[i + 1];
                int next = map.get(nch);
                if (cur < next) cur = 0 - cur;
            }
            ans += cur;
        }

        return ans;
    }
}
