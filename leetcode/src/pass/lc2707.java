package pass;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class lc2707 {
    int[] memo;
    class Trie{
        Trie[] children;
        boolean flag;

        public Trie(){
            children = new Trie[26];
            flag = false;
        }
    }
    Trie root;
    public int minExtraChar(String s, String[] dictionary) {
        int n = s.length();
        memo = new int[n];
        Arrays.fill(memo, -1);

        root = new Trie();
        
        for (String str : dictionary){
            insertTree(str);
        }

        return dfs(s, 0);
    }

    public int dfs(String s, int idx){
        int n = s.length();
        if (idx == n){
            return 0;
        }

        if (memo[idx] != -1) return memo[idx];
        int res = dfs(s, idx + 1) + 1;
        Trie cur = root;
        for (int i = idx; i < n; i++){
            char ch = s.charAt(i);
            int j = ch - 'a';
            if (cur.children[j] == null) break;
            cur = cur.children[j];
            if (cur.flag){
                res = Math.min(res, dfs(s, i + 1));
            }
        }
        
        memo[idx] = res;
        return res;
    }

    public void insertTree(String s){
        int n = s.length();
        Trie cur = root;
        for (int i = 0; i < n; i++){
            char ch = s.charAt(i);
            int idx = ch - 'a';
            if (cur.children[idx] == null) {
                cur.children[idx] = new Trie();
            }
            cur = cur.children[idx];
        }
        cur.flag = true;
    }

    // Set<String> set = new HashSet<>();
    // int[] memo;
    // public int minExtraChar(String s, String[] dictionary) {
    //     int n = s.length();
    //     memo = new int[n];
    //     Arrays.fill(memo, -1);
    //     for (String str : dictionary){
    //         set.add(str);
    //     }
    //     return dfs(s, 0);
    // }

    // public int dfs(String s, int idx){
    //     int n = s.length();
    //     if (idx == n) {
    //         return 0;
    //     }

    //     if (memo[idx] != -1) return memo[idx];
    //     int res = dfs(s, idx + 1) + 1;
        
    //     for (int i = idx; i < n; i++){
    //         String str = s.substring(idx, i + 1);
    //         if (set.contains(str)){
    //             res = Math.min(res, dfs(s, i + 1));
    //         }
    //     }
    //     memo[idx] = res;
    //     return res;
    // }
}
