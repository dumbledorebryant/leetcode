package pass;

import java.util.ArrayList;
import java.util.List;

public class lc1286 {
    List<String> list = new ArrayList<>();
    int pos = 0;
    public CombinationIterator(String characters, int combinationLength) {
        backtrack(characters, combinationLength, 0, new StringBuilder());
    }

    private void backtrack(String s, int len, int idx, StringBuilder sb){
        if (sb.length() == len){
            list.add(sb.toString());
            return;
        }

        int n = s.length();
        for (int i = idx; i < n; i++){
            char ch = s.charAt(i);
            sb.append(ch);
            backtrack(s, len, i + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    
    public String next() {
        pos++;
        return list.get(pos - 1);
    }
    
    public boolean hasNext() {
        if (pos == list.size()) return false;
        else return true;
    }
}
