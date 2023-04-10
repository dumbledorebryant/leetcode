package pass;
import java.util.*;
public class lc320 {
    Set<String> ans = new HashSet<>();
    public List<String> generateAbbreviations(String word) {
        backtrack(word, 0, new StringBuilder(), 0);
        return new ArrayList<>(ans);
    }
    public void backtrack(String word, int idx, StringBuilder sb, int f){
        int length = word.length();
        if (idx == length){
            ans.add(sb.toString());
            return;
        }

        // pre letter
        if (f == 0) {
            for (int i = idx; i < length; i++){
                sb.append(i - idx + 1);
                backtrack(word, i + 1, sb, 1);
                if (i - idx + 1 < 10)
                    sb.deleteCharAt(sb.length() - 1);
                else 
                    sb.delete(sb.length() - 2, sb.length());
            }
        }
        // pre num
        for (int i = idx; i < length; i++){
            sb.append(word.substring(idx, i + 1));
            backtrack(word, i + 1, sb, 0);
            sb.delete(sb.length() - (i - idx + 1), sb.length());
        }
    }
}
