package pass;

public class TrieTest {

    class Trie {
        boolean isEnd;
        Trie[] children;

        public Trie(){
            isEnd = false;
            children = new Trie[26];
        }

        public boolean checkEnd(){
            return isEnd;
        }

        public Trie[] getChildren(){
            return children;
        }

        public void setEnd(boolean flag){
            isEnd = flag;
        }
    }

    Trie root;
    public TrieTest(){
        root = new Trie();
    }

    public void addWord(String word) {
        Trie ptr = root;
        char[] chrs = word.toCharArray();
        int length = chrs.length;
        for (int i = 0; i < length; i++){
            char ch = chrs[i];
            int idx = ch - 'a';
            if (ptr.children[idx] == null){
                ptr.children[idx] = new Trie();
            }
            ptr = ptr.children[idx];
        }
        ptr.setEnd(true);
    }
    
    public boolean search(String word) {
        return dfs(root, word, 0);
    }

    private boolean dfs(Trie root, String word, int idx){
        if (idx == word.length()) {
            if (root.checkEnd() == true) return true;
            else return false;
        }
        char ch = word.charAt(idx);
        if (ch == '.'){
            for (int i = 0; i < 26; i++){
                if (root.children[i] != null){
                    if (dfs(root.children[i], word, idx + 1)) return true;
                }
            }
            return false;
        }
        else{
            int index = ch - 'a';
            if (root.children[index] == null) return false;
            return dfs(root.children[index], word, idx + 1);
        }
    }
}