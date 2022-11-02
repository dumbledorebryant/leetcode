package pass;
import java.util.*;

public class lc648 {
    class Trie{
        boolean isEnd;
        Trie[] children;
        Trie(){
            isEnd = false;
            children = new Trie[26];
        }
        public void insert(String word){
            char[] cs = word.toCharArray();
            Trie cur = this;
            for (char ch : cs){
                int idx = ch - 'a';
                if (cur.children[idx] == null){
                    cur.children[idx] = new Trie();
                }
                cur = cur.children[idx];
            }
            cur.isEnd = true;
        }

        public String search(String word){
            char[] cs = word.toCharArray();
            Trie cur = this;
            int length = cs.length;
            for (int i = 0; i < length; i++){
                int idx = word.charAt(i) - 'a';
                if (cur.children[idx] == null){
                    return "";
                }
                else if (cur.children[idx].isEnd == true){
                    return word.substring(0, i + 1);
                }
                else {
                    cur = cur.children[idx];
                }
            }
            if (cur.isEnd == true) return word;
            return "";
        }
    }

    Trie root = new Trie();
    public String replaceWords(List<String> dictionary, String sentence) {
        for (String word : dictionary){
            root.insert(word);
        }
        String[] words = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String word : words){
            String str = root.search(word);
            if (str.equals("")) {
                sb.append(word);
            }
            else {
                sb.append(str);
            }
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
