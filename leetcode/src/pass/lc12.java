package pass;

import java.util.Arrays;

public class lc12 {
    char[] chrs = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        int i = 1;
        while (num > 0){
            int cur = num % 10;
            String str = compose(cur, i);
            sb.insert(0, str);
            num = num / 10;
            i++;
        }
        return sb.toString();
    }

    public String compose(int cur, int i){
        if (i == 4) {
            char[] res = new char[cur];
            Arrays.fill(res, 'M');
            return new String(res);
        }
        int idx = 2 * (i - 1);
        char v1 = chrs[idx];
        char v5 = chrs[idx + 1];
        char vn = chrs[idx + 2];
        StringBuilder sb = new StringBuilder();
        if (cur == 4){
            sb.append(v1).append(v5);
            return sb.toString();
        }
        if (cur == 9){
            sb.append(v1).append(vn);
            return sb.toString();
        }
        else {
            int c5 = cur / 5;
            int c1 = cur - c5 * 5;
            if (c5 == 1) sb.append(v5);
            for(int j = 0; j < c1; j++) sb.append(v1);
            return sb.toString();
        }
    }
}
