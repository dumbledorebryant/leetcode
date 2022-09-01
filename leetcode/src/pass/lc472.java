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
