package pass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class lc267 {
    public int numWays(int n, int k) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = k;

        for (int i = 2; i <= n; i++){
            dp[i] = k * (dp[i - 2] + (k - 1) * dp[i - 1]); 
        }
        return dp[n];
    }

    boolean[] visited;
    List<String> ans = new ArrayList<>();
    public List<String> generatePalindromes(String s) {
        int n = s.length();
        visited = new boolean[n];
        char[] chrs = s.toCharArray();
        Arrays.sort(chrs);
        backtrack(chrs, new StringBuilder());
        return ans;
    }

    
    public void backtrack(char[] chrs, StringBuilder sb){
        int n = chrs.length;
        if (sb.length() == n){
            String str = sb.toString();
            if (isValid(str)){
                ans.add(str);
            }
            return;
        }

        for (int i = 0; i < n; i++){
            char ch = chrs[i];
            if (visited[i]) continue;
            if (i > 0 && chrs[i] == chrs[i - 1] && !visited[i - 1]) continue;
            sb.append(ch);
            visited[i] = true;
            backtrack(chrs, sb);
            visited[i] = false;
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public boolean isValid(String s){
        int n = s.length();
        int i = 0;
        int j = n - 1;
        while (i <= j){
            char lch = s.charAt(i);
            char rch = s.charAt(j);
            if (lch != rch) return false;
            i++;
            j--;
        }
        return true;
    }
    public List<String> generatePalindromes3(String s) {
        List<String> res = new ArrayList<>();
		// count characters and store in map
        Map<Character, Integer> map = new HashMap<>();
        for(char c: s.toCharArray()){
            map.put(c, map.containsKey(c)? map.get(c)+1: 1);
        }
		
		// find the middle character if there exist one
        Character middle = null;
        for(Map.Entry<Character, Integer> e: map.entrySet()){
            char k = e.getKey();
            int count = e.getValue();
            if(count%2 != 0){
			    // if we find two such middle character, it means no palindrome can be formed
                if(middle != null) return res;
                middle = k;
            }
        }
		
		// backtracking to find all permutation
        String string = middle == null? "": ""+middle;
        backtrack(res, map, string, s.length());
        return res;
    }
    
    public void backtrack(List<String> res, Map<Character, Integer> map, String string, int length){
        if(string.length() == length){
            res.add(string);
            return;
        }
        for(Map.Entry<Character, Integer> e: map.entrySet()){
            char k = e.getKey();
            int count = e.getValue();
            if(count < 2) continue;
            map.put(k, count-2);
            backtrack(res, map, k+string+k, length);
            map.put(k, count);
            String num;
        }
        return;
    }
    
}
