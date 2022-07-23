package pass;
import java.util.*;
public class lc438 {
    public List<Integer> findAnagrams(String s, String p) {
        int length = p.length();
        int len = s.length();
        List<Integer> ans = new ArrayList<>();
        if (len < length) return ans;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++){
            char ch = p.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        
        Map<Character, Integer> window = new HashMap<>();
        for (int i = 0; i < length; i++){
            char ch = s.charAt(i);
            window.put(ch, window.getOrDefault(ch, 0) + 1);
        }

        int flag = 1;
        for (Character ch : window.keySet()){
            if (window.get(ch) != map.get(ch)){
                flag = 0;
            }
        }
        if (flag == 1) ans.add(0);

        
        for (int i = length; i < len; i++){
            char och = s.charAt(i - length);
            char nch = s.charAt(i);
            if (window.get(och) == 1){
                window.remove(och);
            }
            else {
                window.put(och, window.get(och) - 1);
            }
            window.put(nch, window.getOrDefault(nch, 0) + 1);
            int temp = 1;
            for (Character ch : window.keySet()){
                if (window.get(ch) != map.get(ch)){
                    temp = 0;
                    break;
                }
            }
            if (temp == 1) ans.add(i - length + 1);
        }
        return ans;
    }
}
