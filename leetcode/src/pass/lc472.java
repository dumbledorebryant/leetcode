package pass;
import java.util.*;
public class lc472 {
    Node root = new Node();
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        List<String> ans = new ArrayList<>();
        for (String word : words){
            if (!word.isEmpty()){
                if (dfs(word, 0)){
                    ans.add(word);
                }
                else {
                    insert(word);
                }
            }
        }
        return ans;
    }

    public boolean dfs(String word, int i){
        Node cur = root;
        int len = word.length();
        if (i == len) return true;
        while (i < len){
            char ch = word.charAt(i);
            if (cur.children[ch - 'a'] == null) return false;
            else {
                cur = cur.children[ch - 'a'];
                if (cur.isEnd && dfs(word, i + 1)){
                    return true;
                }
                i++;
            }
        }
        return false;
    }

    public void insert(String word){
        Node cur = root;
        char[] chrs = word.toCharArray();
        for (char ch : chrs){
            if (cur.children[ch - 'a'] == null){
                cur.children[ch - 'a'] = new Node();
            }
            cur = cur.children[ch - 'a'];
        }
        cur.isEnd = true;
    }

    class Node {
        boolean isEnd;
        Node[] children;

        Node(){
            this.isEnd = false;
            this.children = new Node[26];
        }
    }
}
class Solution {
    class Trie{
        boolean isEnd;
        Trie[] children;
        public Trie(){
            isEnd = false;
            children = new Trie[26];
        }
    }
    Trie root = new Trie();

    public void insert(String word){
        char[] chrs = word.toCharArray();

        Trie cur = root;
        for (char ch : chrs){
            int index = ch - 'a';
            if (cur.children[index] == null){
                cur.children[index] = new Trie();
            }
            cur = cur.children[index];
        }
        cur.isEnd = true;
    }

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        List<String> ans = new ArrayList<>();
        for (String word : words){
            if (dfs(word, 0)){
                ans.add(word);
            }
            else insert(word);
        }
        return ans;
    }

    public boolean dfs(String word, int idx){
        char[] chrs = word.toCharArray();
        int length = word.length();
        if (idx == length) return true;

        Trie cur = root;
        for (int i = idx; i < length; i++){
            char ch = chrs[i];
            int index = ch - 'a';
            if (cur.children[index] == null) return false;
            cur = cur.children[index];
            if (cur.isEnd){
                if (dfs(word, i + 1)) return true;
            }
        }
        return false;
    }
}