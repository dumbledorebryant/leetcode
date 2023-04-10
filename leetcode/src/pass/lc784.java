package pass;
import java.util.*;;
public class lc784 {
    Set<String> set = new HashSet<>();
    public List<String> letterCasePermutation(String s) {
        backtrack(s, 0, new StringBuilder());
        return new ArrayList<>(set);
    }
    public void backtrack(String s, int idx, StringBuilder sb){
        int length = s.length();
        if (idx == length){
            set.add(sb.toString());
            return;
        }

        char ch = s.charAt(idx);
        if (Character.isDigit(ch)){
            sb.append(ch);
            backtrack(s, idx + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        else {
            sb.append(Character.toLowerCase(ch));
            backtrack(s, idx + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
            sb.append(Character.toUpperCase(ch));
            backtrack(s, idx + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
