package pass;

import java.util.HashSet;
import java.util.Set;

public class lc208 {
    boolean isEnd;
    lc208[] children = new lc208[26];
    public lc208() {

    }
    
    public void insert(String word) {
        lc208 node = this;
        int length = word.length();
        for (int i = 0; i < length; i++){
            int ch = word.charAt(i) - 'a';
            if (node.children[ch] != null){
                continue;
            }
            else {
                node.children[ch] = new lc208();
            }
            node = node.children[ch];
        }
        node.isEnd = true;
    }
    
    public boolean search(String word) {
        lc208 node = this;
        int length = word.length();
        for (int i = 0; i < length; i++){
            int ch = word.charAt(i) - 'a';
            if (node.children[ch] == null) return false;
            else {
                node = node.children[ch];
            }
        }
        return node != null && node.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        lc208 node = this;
        int length = prefix.length();
        for (int i = 0; i < length; i++){
            int ch = prefix.charAt(i) - 'a';
            if (node.children[ch] == null) return false;
            else {
                node = node.children[ch];
            }
        }
        return node != null;
    }
}
