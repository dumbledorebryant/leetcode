package pass;

import java.util.*;

public class lc76 {
    public String minWindow(String s, String t) {
        
    }
    public String minindow(String s, String t) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0;i < t.length();i++){
            map.put(t.charAt(i),map.containsKey(t.charAt(i)) ? map.get(t.charAt(i))+1 : 1);
        }
        int left = 0;
        int right = 0;
        int minleft = 0;
        int minlen = s.length()+1;
        int count = 0;
        while(right < s.length()){
            if(map.containsKey(s.charAt(right))){
                map.put(s.charAt(right),map.get(s.charAt(right))-1);
                if(map.get(s.charAt(right)) >= 0)count++;
            }
            while(count == t.length()){
                if(right - left + 1 < minlen){
                    minleft = left;
                    minlen = right - left + 1;
                }
                if(map.containsKey(s.charAt(left))){
                    map.put(s.charAt(left),map.get(s.charAt(left))+1);
                    if(map.get(s.charAt(left)) > 0)count--;
                }
                left++;
            }
            if(right < s.length())right++;
        }
        if(minlen > s.length())return "";
        return s.substring(minleft,minleft+minlen);
    }
}
