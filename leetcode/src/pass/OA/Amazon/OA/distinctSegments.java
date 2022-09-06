package pass.OA.Amazon.OA;

import java.util.HashMap;
import java.util.Map;

public class distinctSegments {
    public int findSegmentsNum(String s){
        int ans = 1;
        Map<Character, Integer> map = new HashMap<>();
        char[] chrs = s.toCharArray();
        int length = chrs.length;
        int right = 0;
        while (right < length){
            char ch = chrs[right];
            if (map.containsKey(ch)){
                map.clear();
                ans++;
            }
            map.put(ch, right);
            right++;
        }
        return ans;
    }

    public static void main(String[] args) throws Exception 
    {
        String s = "aabcdea"; // ans = 3;
        String s1 = "adbccdbada"; // ans = 3
        String s2 = "abbddcacd"; // ans = 4
        distinctSegments ds = new distinctSegments();
        System.out.println(ds.findSegmentsNum(s1));
    }
}
