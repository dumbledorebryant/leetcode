package pass;

public class lc677 {
    class Trie{
        int val;
        Trie[] children;

        public Trie(){
            val = 0;
            children = new Trie[26];
        }
    }
    Trie root;
    public lc677() {
        root = new Trie();
    }
    
    public void insert(String key, int val) {
        Trie cur = root;
        char[] cs = key.toCharArray();
        for (char ch : cs){
            int idx = ch - 'a';
            if (cur.children[idx] == null){
                cur.children[idx] = new Trie();
            }
            cur = cur.children[ch];
        }
        cur.val = val;
    }
    
    int ans = 0;
    public int sum(String prefix) {
        ans = 0;
        Trie cur = root;
        char[] cs = prefix.toCharArray();
        for (char ch : cs){
            int idx = ch - 'a';
            if (cur.children[idx] == null) return 0;
            cur = cur.children[idx];
        }
        ans += cur.val;
        traverse(cur);
        return ans;
    }
    public void traverse(Trie cur){
        for (Trie child : cur.children){
            if (child == null) continue;
            if (child.val > 0) ans += child.val;
            traverse(child);
        }
    }
}
