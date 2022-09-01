package pass;
import java.util.*;
public class lc140 {
    List<String> ans;
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        for (String word : wordDict){
            set.add(word);
        }
        ans = new ArrayList<>();
        char[] chrs = s.toCharArray();
        backtrack(chrs, 0, "", set);
        return ans;
    }

    public void backtrack(char[] chrs, int index, String str, Set<String> set){
        int length = chrs.length;
        if (index == length) {
            ans.add(str);
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = index; i < length; i++){
            char ch = chrs[i];
            sb.append(ch);
            if (set.contains(sb.toString())){
                if (i == length - 1){
                    backtrack(chrs, length, str + sb.toString(), set);
                }  
                else {
                    backtrack(chrs, i + 1, str + sb.toString() + " ", set);
                } 
            }
        }
    }
}
