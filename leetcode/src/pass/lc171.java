package pass;

import java.util.HashMap;
import java.util.Map;

public class lc171 {
    public int titleToNumber(String columnTitle) {
        int length = columnTitle.length();
        int ans = 0;
        for (int i = length - 1; i >= 0; i++){
            char ch = columnTitle.charAt(i);
            int num = ch - 'A' + 1;
            ans += (Math.pow(26, length - 1 - i) * num);
        }
        return ans;
    }
}
