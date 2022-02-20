package pass;

import java.util.*;

public class lc131 {
    List<List<String>> ans;
    public List<List<String>> partition(String s) {
        ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<>();
        backtrace(s, 0, sb, list);
        return ans;
    }
    public void backtrace(String s, int i, StringBuilder sb, List<String> list){
        int length = s.length();
        if (i >= length) {
            String cur = sb.toString();
            if (check(cur)){
                list.add(cur);
                ans.add(new ArrayList<>(list));
            }
            return;
        }
        char ch = s.charAt(i);
        sb.append(ch);
        String cur = sb.toString();
        if (check(cur)){
            list.add(cur);
            backtrace(s, i + 1, new StringBuilder(), list);
            list.remove(list.size() - 1);
        }
        
        else backtrace(s, i + 1, sb, list);
    }
    public boolean check(String s){
        int len = s.length();
        if (len == 1) return true;
        if (len == 0) return false;
        int left = 0;
        int right = len - 1;
        while (left < right){
            char lch = s.charAt(left);
            char rch = s.charAt(right);
            if (lch != rch) return false;
            else {
                left++;
                right--;
            }
        }
        return true;
    }
}
