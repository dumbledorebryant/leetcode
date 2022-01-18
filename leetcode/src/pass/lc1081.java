package pass;

import java.util.HashMap;

import java.util.*;

public class lc1081 {
    public String smallestSubsequence(String s) {
        char[] chrs = s.toCharArray();
        int length = chrs.length;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++){
            char ch = chrs[i];
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        boolean[] visited = new boolean[26];
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < length; i++){
            char ch = chrs[i];
            map.put(ch, map.get(ch) - 1);
            if (visited[ch - 'a']) continue;

            while (!stack.isEmpty() && ch < stack.peek() && map.get(stack.peek()) > 0){
                visited[stack.pop() - 'a'] = false;
            }
            stack.push(ch);
            visited[ch - 'a'] = true;
        }
        
        StringBuilder ans = new StringBuilder();
        while (!stack.isEmpty()){
            ans.append(stack.pop());
        }
        return ans.reverse().toString();
    }
}
