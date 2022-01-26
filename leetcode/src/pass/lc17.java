package pass;

import java.util.*;

public class lc17 {
    List<String> ans;
    public List<String> letterCombinations(String digits) {
        ans = new ArrayList<>();
        Map<Character, String> map = new HashMap<>();
        
        map.put('2', "abc");
        map.put('3', "edf");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        int length = digits.length();
        if (length == 0) return ans;
        
        String[] list = new String[length];
        for (int i = 0; i < length; i++)
        {
            list[i] = map.get(digits.charAt(i));
        }
        
        String str = "";
        construct(list, 0, str);
        return ans;
    }
    public void construct(String[]list, int i, String str){
        if (i == list.length) {
            ans.add(str);
            return;
        }
        String cur = list[i];
        int len = cur.length();
        for (int m = 0; m < len; m++){
            construct(list, i + 1, str + cur.charAt(m));
        }
    }
}
