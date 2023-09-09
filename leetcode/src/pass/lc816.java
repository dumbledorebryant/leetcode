package pass;

import java.util.ArrayList;
import java.util.List;

public class lc816 {
    private List<String> xPoss, ans;
    public List<String> ambiguousCoordinates(String S) {
        ans = new ArrayList<>();
        for (int i = 2; i < S.length() - 1; i++) {
            String[] strs = {S.substring(1,i), S.substring(i, S.length() - 1)};
            xPoss = new ArrayList<>();
            for (int j = 0; j < 2; j++)
                if (xPoss.size() > 0 || j == 0) parse(strs[j], j);
        }
        return ans;
    }
    private void parse(String str, int xy) {
        if (str.length() == 1 || str.charAt(0) != '0')
            process(str, xy);
        if (str.length() > 1 && str.charAt(str.length()-1) != '0')
            process(str.substring(0,1) + "." + str.substring(1), xy);
        if (str.length() > 2 && str.charAt(0) != '0' && str.charAt(str.length()-1) != '0')
            for (int i = 2; i < str.length(); i++)
                process(str.substring(0,i) + "." + str.substring(i), xy);
    }
    private void process(String str, int xy) {
        if (xy > 0)
            for (String x : xPoss)
                ans.add("(" + x + ", " + str + ")");
        else xPoss.add(str);
    }
}
