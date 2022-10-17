package pass;
import java.util.*;

public class lc438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        char[] cp = p.toCharArray();
        char[] cs = s.toCharArray();
        int length = cs.length;

        Map<Character, Integer> map = new HashMap<>();
        for (char ch : cp){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int l = 0;
        int r = 0;
        Map<Character, Integer> cur = new HashMap<>(); 
        while (r < length){
            char ch = cs[r];
            r++;
            if (!map.containsKey(ch)){
                l = r;
                cur.clear();
                continue;
            }

            cur.put(ch, cur.getOrDefault(ch, 0) + 1);
            if (cur.get(ch) > map.get(ch)){
                while (l < r && cs[l] != ch) {
                    cur.put(cs[l], cur.get(cs[l]) - 1);
                    l++;
                }
                cur.put(cs[l], cur.get(cs[l]) - 1);
                l++;
            }
            if (cur.equals(map)){
                ans.add(l);
                char left = cs[l];
                cur.put(left, cur.get(left) - 1);
                l++;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        String s = "abaacbabc";
        String p = "abc";
        lc438 lc = new lc438();
        System.out.println(lc.findAnagrams(s, p));
    }
}
