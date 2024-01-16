package pass;

import java.util.ArrayList;
import java.util.List;

public class lc293 {
    public List<String> generatePossibleNextMoves(String currentState) {
        int n = currentState.length();
        List<String> res = new ArrayList<>();
        for (int i = 0; i < n - 1; i++){
            char cur = currentState.charAt(i);
            char next = currentState.charAt(i + 1);
            if (cur == next && cur == '+'){
                res.add(change(currentState, i));
            }
        }
        return res;
    }

    public String change(String s, int i){
        char[] chrs = s.toCharArray();
        chrs[i] = '-';
        chrs[i + 1] = '-';
        return new String(chrs);
    }
}
