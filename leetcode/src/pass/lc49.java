package pass;

import java.util.*;

public class lc49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Map<Character, Integer>, List<String>> map = new HashMap<>();
        for (String str : strs){
            Map<Character, Integer> word = new HashMap<>();
            int length = str.length();
            for (int i = 0; i < length; i++){
                char ch = str.charAt(i);
                word.put(ch, word.getOrDefault(ch, 0) + 1);
            }
            if (map.containsKey(word)) System.out.println("shit");
            List<String> list = map.getOrDefault(word, new ArrayList<>());
            list.add(str);
            map.put(word, list);
        }
        List<List<String>> ans = new ArrayList<>();
        for (List<String> value : map.values()){
            ans.add(value);
        }
        return ans;
    }
}
