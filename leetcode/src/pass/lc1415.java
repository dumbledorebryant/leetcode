package pass;


import java.util.*;

public class lc1415 {
    List<Character> list = new ArrayList<>();
    int cnt = 0;
    String res = "";
    public String getHappyString(int n, int k) {
        list.add('a');
        list.add('b');
        list.add('c');
        helper('X', 0, n, new StringBuilder(), k);
        return res;
    }

    public void helper(char cur, int i, int n, StringBuilder sb, int k){
        if (i == n){
            cnt++;
            if (cnt == k) {
                res = sb.toString();
                return;
            }
            return;
        }
        for (char next : list){
            if (next != cur){
                sb.append(next);
                helper(next, i + 1, n, sb, k);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
