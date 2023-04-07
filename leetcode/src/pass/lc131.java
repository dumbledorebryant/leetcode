package pass;

import java.util.*;

public class lc131 {
    List<List<String>> ans = new ArrayList<>();
    public List<List<String>> partition(String s) {
        backtrack(s, 0, new ArrayList<>(), new StringBuilder());
        return ans;
    }
    public void backtrack(String s, int i, List<String> path, StringBuilder sb){
        int length = s.length();
        if (i == length){
            String str = sb.toString();
            if (check(str)){
                path.add(str);
                ans.add(new ArrayList<>(path));
                path.remove(path.size() - 1);
            }
            
            return;
        }
        char ch = s.charAt(i);
        sb.append(ch);
        String cur = sb.toString();
        if (check(cur)){
            path.add(cur);
            backtrack(s, i + 1, path, new StringBuilder());
            path.remove(path.size() - 1);
        }
        
        backtrack(s, i + 1, path, sb);
        sb.deleteCharAt(sb.length() - 1);
    }

    public boolean check(String s){
        int size = s.length();
        int left = 0;
        int right = size - 1;
        while (left < right){
            if (s.charAt(left) != s.charAt(right)) return false;
            else {
                left++;
                right--;
            }
        }
        return true;
    }
}
