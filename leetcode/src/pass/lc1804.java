package pass;

public class lc1804 {
    
}
class Trie {
    class Node{
        int count;
        Node[] children;
        public Node() {
            children = new Node[26];
            count = 0;
        }
    }

    Node root;
    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node cur = root;
        char[] cs = word.toCharArray();
        for (char ch : cs){
            int idx = ch - 'a';
            if (cur.children[idx] == null){
                cur.children[idx] = new Node();
            }
            cur = cur.children[idx];
        }
        cur.count++;
    }
    
    public int countWordsEqualTo(String word) {
        Node cur = root;
        char[] cs = word.toCharArray();
        for (char ch : cs){
            int idx = ch - 'a';
            if (cur.children[idx] == null){
                return 0;
            }
            cur = cur.children[idx];
        }
        return cur.count;
    }
    
    public int countWordsStartingWith(String prefix) {
        Node cur = root;
        char[] cs = prefix.toCharArray();
        for (char ch : cs){
            int idx = ch - 'a';
            if (cur.children[idx] == null){
                return 0;
            }
            cur = cur.children[idx];
        }
        return count(cur);
    }
    int count(Node node){
        int ans = node.count;
        for (Node child : node.children){
            if (child != null){
                ans += count(child);
            }
        }
        return ans;
    }
    
    public void erase(String word) {
        Node cur = root;
        char[] cs = word.toCharArray();
        int len = cs.length;
        for (int i = 0; i < len; i++){
            int idx = word.charAt(i) - 'a';
            if (i == len - 1){
                if (cur.children[idx].count != 0)
                    cur.children[idx].count--;
            }
            cur = cur.children[idx];
        }
    }
}