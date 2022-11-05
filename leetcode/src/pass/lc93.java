package pass;
import java.util.*;
public class lc93 {
    List<String> ans = new ArrayList<>();
    StringBuilder ip = new StringBuilder();
    public List<String> restoreIpAddresses(String s) {
        backtrace(new StringBuilder(s), 0, 0);
        return ans;
    }

    public void backtrace(StringBuilder sb, int start, int cnt){
        int n = sb.length();
        if (start == n && cnt == 4){
            ans.add(ip.toString());
            return;
        }
        if (start == n || cnt == 4) return;

        for (int i = start; i < n && i < start + 3; i++){
            if (i > start && sb.charAt(start) == '0') return;
            String seg = sb.substring(start, i + 1);
            int val = Integer.valueOf(seg);
            if (val > 255){
                return;
            }
            ip.append(seg);
            if (cnt < 3) ip.append('.');
            backtrace(sb, i + 1, cnt + 1);
            ip.delete(start + cnt, ip.length());
        }
    }
}
