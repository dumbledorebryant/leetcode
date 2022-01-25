package pass;

import java.util.HashMap;
import java.util.*;

public class lc17 {
    public List<String> letterCombinations(String digits) {
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
        String[] list = new String[length];
        for (int i = 0; i < length; i++)
        {
            list[i] = map.get(digits.charAt(i));
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++){
            String str = construct(list, 0, 0);
        }
    }
    public String construct(String[]list, int i, int j){
        String str = "";
        str += list[i].charAt(j);
        if (j <= )
        str += construct(list, i, j + 1);
    }
}
